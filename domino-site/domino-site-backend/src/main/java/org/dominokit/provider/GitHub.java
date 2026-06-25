package org.dominokit.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.PrivateKey;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.isNull;

public class GitHub {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHub.class);
    private static final String DEFAULT_ORG = "DominoKit";

    private final long appId;
    private final RSAPrivateKey privateKey;
    private Long installationId;

    private static final Duration RELEASES_CACHE_TTL = Duration.ofDays(1);
    private List<Release> cachedReleases = List.of();
    private Set<String> cachedRepos = Set.of();
    private Instant releasesFetchedAt = Instant.MIN;

    private static final HttpClient HTTP = HttpClient.newHttpClient();
    private static final ObjectMapper JSON = new ObjectMapper();
    private static final DateTimeFormatter PUBLISHED_FORMATTER =
            DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);

    public GitHub(long appId, String privateKey) throws Exception {
        this.appId = appId;
        this.privateKey = toRSAPrivateKey(privateKey);
    }

    static {
        if (Security.getProvider("BC") == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    public RSAPrivateKey toRSAPrivateKey(String pem) throws Exception {
        pem = normalizePem(pem);

        try (PEMParser parser = new PEMParser(new StringReader(pem))) {
            Object object = parser.readObject();

            if (object == null) {
                throw new IllegalArgumentException(
                        "PEMParser could not read the key. " +
                                "Check PEM formatting and newlines."
                );
            }

            JcaPEMKeyConverter converter =
                    new JcaPEMKeyConverter().setProvider("BC");

            PrivateKey key;

            if (object instanceof PEMKeyPair pair) {
                // PKCS#1 (RSA PRIVATE KEY)
                key = converter.getKeyPair(pair).getPrivate();
            } else if (object instanceof PrivateKeyInfo info) {
                // PKCS#8 (PRIVATE KEY)
                key = converter.getPrivateKey(info);
            } else {
                throw new IllegalArgumentException(
                        "Unsupported PEM object: " + object.getClass()
                );
            }

            if (!(key instanceof RSAPrivateKey rsa)) {
                throw new IllegalStateException("Key is not RSA");
            }

            return rsa;
        }
    }

    private static String normalizePem(String pem) {
        return pem
                .replace("\\n", "\n")
                .replace("\r", "")
                .trim();
    }

    private String createJwt() {
        Instant now = Instant.now();

        return JWT.create()
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(now.plusSeconds(600))) // 10 minutes
                .withIssuer(String.valueOf(appId))
                .sign(Algorithm.RSA256(null, privateKey));
    }

    private long findInstallationId(String jwt, String orgLogin) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/app/installations"))
                .header("Authorization", "Bearer " + jwt)
                .header("Accept", "application/vnd.github+json")
                .build();

        HttpResponse<String> response =
                HttpClient.newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IllegalStateException(
                    "Failed to list installations: " + response.statusCode() + "\n" + response.body()
            );
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode installations = mapper.readTree(response.body());

        for (JsonNode installation : installations) {
            String login = installation.path("account").path("login").asText();
            if (orgLogin.equalsIgnoreCase(login)) {
                return installation.path("id").asLong();
            }
        }

        throw new IllegalStateException(
                "No installation found for org: " + orgLogin
        );
    }

    private String getAccessToken() throws Exception {
        if (isNull(installationId)) {
            this.installationId = findInstallationId(createJwt(), "dominokit");
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://api.github.com/app/installations/" + installationId + "/access_tokens"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .header("Authorization", "Bearer " + createJwt())
                .header("Accept", "application/vnd.github+json")
                .build();

        HttpResponse<String> response =
                HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new ObjectMapper()
                .readTree(response.body())
                .get("token")
                .asText();
    }

    public List<String> listAllOrgRepos(String org) throws Exception {
        List<String> repos = new ArrayList<>();
        int page = 1;

        while (true) {
            URI uri = URI.create(
                    "https://api.github.com/orgs/" + org +
                            "/repos?per_page=100&page=" + page);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Authorization", "Bearer " + getAccessToken())
                    .header("Accept", "application/vnd.github+json")
                    .build();

            HttpResponse<String> response =
                    HTTP.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IllegalStateException(
                        "Failed to list repos: " +
                                response.statusCode() + "\n" + response.body());
            }

            JsonNode array = JSON.readTree(response.body());
            if (!array.isArray() || array.isEmpty()) {
                break; // no more pages
            }

            for (JsonNode repo : array) {
                repos.add(repo.get("name").asText());
            }

            page++;
        }

        return repos;
    }

    public synchronized List<Release> listAllReleases(List<String> whitelistedRepos) throws Exception {
        List<String> normalizedRepos = normalizeRepos(whitelistedRepos);
        if (normalizedRepos.isEmpty()) {
            return List.of();
        }

        Set<String> requestedRepos = new LinkedHashSet<>(normalizedRepos);
        if (isCacheValid(requestedRepos)) {
            return cachedReleases;
        }

        List<Release> releases = fetchAllReleases(normalizedRepos);
        cachedReleases = releases;
        cachedRepos = requestedRepos;
        releasesFetchedAt = Instant.now();

        return releases;
    }

    private boolean isCacheValid(Set<String> requestedRepos) {
        if (requestedRepos.isEmpty() || cachedRepos.isEmpty()) {
            return false;
        }

        if (!cachedRepos.equals(requestedRepos)) {
            return false;
        }

        if (Instant.MIN.equals(releasesFetchedAt)) {
            return false;
        }

        Duration age = Duration.between(releasesFetchedAt, Instant.now());
        return age.compareTo(RELEASES_CACHE_TTL) < 0;
    }

    private List<Release> fetchAllReleases(List<String> normalizedRepos) throws Exception {
        List<ReleaseWithInstant> releases = new ArrayList<>();

        for (String repo : normalizedRepos) {
            URI uri = URI.create("https://api.github.com/repos/" + repo + "/releases");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Authorization", "Bearer " + getAccessToken())
                    .header("Accept", "application/vnd.github+json")
                    .build();

            HttpResponse<String> response =
                    HTTP.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                LOGGER.warn("Failed to list releases for repo {} status={} body={}", repo,
                        response.statusCode(), response.body());
                continue;
            }

            JsonNode array = JSON.readTree(response.body());
            if (!array.isArray()) {
                continue;
            }

            for (JsonNode release : array) {
                Instant publishedAtInstant = parsePublishedAt(release.path("published_at").asText());
                Release releaseDto = new Release(
                        repo,
                        release.path("name").asText(release.path("tag_name").asText()),
                        release.path("tag_name").asText(),
                        release.path("html_url").asText(),
                        formatPublishedAt(publishedAtInstant)
                );
                releases.add(new ReleaseWithInstant(releaseDto, publishedAtInstant));
            }
        }

        releases.sort((a, b) -> b.publishedAt().compareTo(a.publishedAt()));

        List<Release> result = new ArrayList<>(releases.size());
        for (ReleaseWithInstant release : releases) {
            result.add(release.release());
        }
        return result;
    }

    private List<String> normalizeRepos(List<String> repos) {
        if (repos == null || repos.isEmpty()) {
            return List.of();
        }

        List<String> normalized = new ArrayList<>();
        for (String repo : repos) {
            String normalizedRepo = normalizeRepoName(repo);
            if (normalizedRepo.isBlank()) {
                continue;
            }
            if (!normalized.contains(normalizedRepo)) {
                normalized.add(normalizedRepo);
            }
        }

        return normalized;
    }

    private Instant parsePublishedAt(String value) {
        if (value == null || value.isBlank()) {
            return Instant.MIN;
        }
        try {
            return Instant.parse(value);
        } catch (Exception e) {
            return Instant.MIN;
        }
    }

    private String formatPublishedAt(Instant instant) {
        if (Instant.MIN.equals(instant)) {
            return "";
        }
        try {
            return PUBLISHED_FORMATTER.format(instant.atZone(ZoneOffset.UTC));
        } catch (Exception e) {
            return "";
        }
    }

    private String normalizeRepoName(String repo) {
        if (repo == null || repo.isBlank()) {
            return "";
        }
        return repo.contains("/") ? repo : DEFAULT_ORG + "/" + repo;
    }

    public record Release(String repository, String name, String tag, String url, String publishedAt) {
    }

    private record ReleaseWithInstant(Release release, Instant publishedAt) {
    }
}
