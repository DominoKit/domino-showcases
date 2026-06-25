package org.dominokit.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Fetches releases from multiple GitHub repositories and returns them sorted by published date.
 */
public class GitHubReleaseFetcher {

    private final HttpClient httpClient;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String token; // optional

    public GitHubReleaseFetcher(String token) {
        this.httpClient = HttpClient.newHttpClient();
        this.token = token;
    }

    /**
     * Fetch releases for the provided repositories and sort them newest-first.
     *
     * @param repositories e.g. ["dominokit/domino-rest", "dominokit/domino-ui"]
     */
    public List<ReleaseInfo> fetchAll(List<String> repositories) throws IOException, InterruptedException {
        List<ReleaseInfo> all = new ArrayList<>();
        for (String repo : repositories) {
            all.addAll(fetchRepoReleases(repo));
        }
        all.sort((a, b) -> b.publishedAt.compareTo(a.publishedAt)); // newest first
        return all;
    }

    private List<ReleaseInfo> fetchRepoReleases(String repo) throws IOException, InterruptedException {
        String url = "https://api.github.com/repos/" + repo + "/releases";
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github+json")
                .header("User-Agent", "domino-site-release-fetcher");

        if (token != null && !token.isBlank()) {
            builder.header("Authorization", "Bearer " + token);
        }

        HttpResponse<String> response = httpClient.send(builder.GET().build(), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        if (response.statusCode() >= 400) {
            throw new IOException("Failed to fetch releases for " + repo + ": " + response.statusCode() + " " + response.body());
        }

        List<Map<String, Object>> items = mapper.readValue(response.body(), new TypeReference<>() {});
        List<ReleaseInfo> releases = new ArrayList<>();
        for (Map<String, Object> item : items) {
            String name = (String) item.getOrDefault("name", item.get("tag_name"));
            String tag = (String) item.get("tag_name");
            String htmlUrl = (String) item.get("html_url");
            String publishedAtStr = (String) item.get("published_at");
            OffsetDateTime publishedAt = publishedAtStr != null ? OffsetDateTime.parse(publishedAtStr) : OffsetDateTime.MIN;

            releases.add(new ReleaseInfo(repo, name, tag, htmlUrl, publishedAt));
        }
        return releases;
    }

    public record ReleaseInfo(String repository, String name, String tag, String url, OffsetDateTime publishedAt) {}
}
