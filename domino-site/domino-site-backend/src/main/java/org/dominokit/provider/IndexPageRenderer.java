package org.dominokit.provider;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.dominokit.domino.ui.icons.lib.MdiTags;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@ApplicationScoped
public class IndexPageRenderer {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexPageRenderer.class);

    public static final String TEMPLATE_PREFIX = "dominokitsite/templates/";
    public static final String TEMPLATE_SUFFIX = ".html";
    private static final String WEB_ASSETS_PREFIX = "/assets/";
    private static final String CLASSPATH_ASSETS_PREFIX = "/META-INF/resources/assets/";
    private static final String DEFAULT_RELEASE_IMAGE = "/assets/release-plan.jpeg";
    private static final DateTimeFormatter RELEASE_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
    private static final DateTimeFormatter GROUP_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

    private final TemplateEngine engine;
    private GitHub gitHub;

    @Inject
    @ConfigProperty(name = "GITHUB_APP_PRIVATE_KEY")
    Optional<String> privateKey;

    @Inject
    @ConfigProperty(name = "GITHUB_APP_ID")
    Optional<String> appId;

    @Inject
    @ConfigProperty(name = "GITHUB_APP_PRIVATE_KEY_FILE")
    Optional<String> privateKeyFile;

    public IndexPageRenderer() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix(TEMPLATE_PREFIX);
        templateResolver.setSuffix(TEMPLATE_SUFFIX);
        templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        templateResolver.setCacheable(false);

        this.engine = new TemplateEngine();
        this.engine.setTemplateResolver(templateResolver);
    }

    public String render(String templateName, Map<String, Object> variables) {

        Context ctx = new Context(Locale.ROOT);
        Map<String, Object> vars = new HashMap<>();

        if (variables != null) {
            vars.putAll(variables);
        }

        String contentTemplateName = templateName.startsWith("pages/")
                ? templateName
                : "pages/" + templateName;

        if (contentTemplateName.startsWith("pages/")) {
            Map<String, String> snippets = loadSnippets(contentTemplateName);
            vars.put("code", snippets);
        }

        vars.forEach(ctx::setVariable);
        ctx.setVariable("githubReleases", getGitHubReleases());
        List<ReleaseCard> releaseCards = buildReleaseCards();
        ctx.setVariable("githubReleaseCards", releaseCards);
        ctx.setVariable("githubReleaseGroups", buildReleaseGroups(releaseCards));

        String content = engine.process(templateName, ctx);

        Document websiteDocument = Jsoup.parse(content);
        processJavaDocs(websiteDocument);
        processSideNav(websiteDocument);
        processIconsMenu(websiteDocument);

        return websiteDocument.html();
    }

    public static String deriveSnippetsDir(String renderedTemplate) {
        if (renderedTemplate == null || renderedTemplate.isBlank()) {
            throw new IllegalArgumentException("Template path must not be null");
        }

        int lastSlash = renderedTemplate.lastIndexOf('/');
        if (lastSlash == -1) {
            throw new IllegalArgumentException(
                    "Cannot derive directory from template path: " + renderedTemplate);
        }

        String dir = renderedTemplate.substring(0, lastSlash + 1);

        return "/dominokitsite/templates/" + dir;
    }

    private Map<String, String> loadSnippets(String renderedTemplate) {
        Map<String, String> snippets =
                CodeSnippetLoader.loadSnippets("/dominokitsite/templates/" + renderedTemplate + "/");

        if (!snippets.isEmpty()) {
            return snippets;
        }

        return CodeSnippetLoader.loadSnippets(deriveSnippetsDir(renderedTemplate));
    }

    private void processIconsMenu(Document websiteDocument) {
        Element iconsMenu = websiteDocument.getElementById("dui-mdi-icons-menu");
        if (nonNull(iconsMenu)) {
            MdiTags.TAGS.forEach(tag -> {
                iconsMenu.append("<li class=\"dui dui-site-docs-sub-menu-item\">\n" +
                        "\t\t\t\t\t\t<a class=\"dui dui-site-menu-link\" tabindex=\"0\" dui-site-data=\"nav-anchor\" href=\"/solutions/domino-ui/v2/docs/mdi-icons?tag=" + tagToLinkParam(tag) + "\" aria-expanded=\"true\">\n" +
                        "\t\t\t\t\t\t\t<span class=\"dui dui-site-menu-item-text\">" + tag + "</span>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t</li>");
            });
        }
    }

    private String tagToLinkParam(String tag) {
        return tag.replace(" / ", "_");
    }

    private List<GitHub.Release> getGitHubReleases() {
        try {
            GitHub client = getGitHubClient();
            if (client == null) {
                return List.of();
            }
            return client.listAllReleases(GitHubRepositories.REPOSITORIES);
        } catch (Exception e) {
            LOGGER.warn("Failed to load GitHub releases", e);
            return List.of();
        }
    }

    private synchronized GitHub getGitHubClient() {
        if (gitHub != null) {
            return gitHub;
        }

        String resolvedAppId = appId.orElse("").trim();
        String resolvedPrivateKey = resolvePrivateKey();
        if (resolvedAppId.isEmpty() || resolvedPrivateKey.isEmpty()) {
            return null;
        }

        try {
            gitHub = new GitHub(Long.parseLong(resolvedAppId), resolvedPrivateKey);
            return gitHub;
        } catch (Exception e) {
            LOGGER.warn("Failed to initialize GitHub client", e);
            return null;
        }
    }

    private String resolvePrivateKey() {
        String inlinePrivateKey = privateKey.orElse("").trim();
        if (!inlinePrivateKey.isEmpty()) {
            return inlinePrivateKey;
        }

        String privateKeyFilePath = privateKeyFile.orElse("").trim();
        if (privateKeyFilePath.isEmpty()) {
            return "";
        }

        try {
            return Files.readString(Path.of(privateKeyFilePath)).trim();
        } catch (Exception e) {
            LOGGER.warn("Failed to read GitHub private key file: {}", privateKeyFilePath, e);
            return "";
        }
    }

    private List<ReleaseCard> buildReleaseCards() {
        List<GitHub.Release> releases = getGitHubReleases();
        if (releases == null || releases.isEmpty()) {
            return List.of();
        }

        return releases.stream()
                .map(this::toReleaseCard)
                .toList();
    }

    private ReleaseCard toReleaseCard(GitHub.Release release) {
        String repoShortName = repoName(release.repository());
        LocalDate publishedDate = parsePublishedDate(release.publishedAt());

        return new ReleaseCard(
                release.url(),
                DEFAULT_RELEASE_IMAGE,
                findBanner(repoShortName),
                repoShortName.toUpperCase(Locale.ROOT),
                Optional.ofNullable(release.name()).filter(name -> !name.isBlank()).orElse(release.tag()),
                release.publishedAt(),
                publishedDate
        );
    }

    private String findBanner(String repoShortName) {
        String baseName = repoShortName + "-banner";
        String[] extensions = {"svg", "png", "jpg", "jpeg"};

        for (String ext : extensions) {
            String assetName = baseName + "." + ext;
            if (assetExists(assetName)) {
                return WEB_ASSETS_PREFIX + assetName;
            }
        }

        return DEFAULT_RELEASE_IMAGE;
    }

    private boolean assetExists(String assetName) {
        try (var stream = this.getClass().getResourceAsStream(CLASSPATH_ASSETS_PREFIX + assetName)) {
            return stream != null;
        } catch (IOException e) {
            return false;
        }
    }

    private String repoName(String repository) {
        if (repository == null || repository.isBlank()) {
            return "";
        }
        int slashIndex = repository.indexOf('/');
        return slashIndex >= 0 ? repository.substring(slashIndex + 1) : repository;
    }

    private LocalDate parsePublishedDate(String publishedAt) {
        if (publishedAt == null || publishedAt.isBlank()) {
            return null;
        }
        try {
            return LocalDate.parse(publishedAt, RELEASE_DATE_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    private List<ReleaseGroup> buildReleaseGroups(List<ReleaseCard> releaseCards) {
        if (releaseCards == null || releaseCards.isEmpty()) {
            return List.of();
        }

        Map<String, List<ReleaseCard>> grouped = new LinkedHashMap<>();

        for (ReleaseCard card : releaseCards) {
            String label = groupLabel(card.publishedDate);
            grouped.computeIfAbsent(label, k -> new ArrayList<>()).add(card);
        }

        List<ReleaseGroup> result = new ArrayList<>();
        grouped.forEach((label, cards) -> result.add(new ReleaseGroup(label, cards)));
        return result;
    }

    private String groupLabel(LocalDate publishedDate) {
        if (publishedDate == null) {
            return "Unknown date";
        }
        try {
            YearMonth ym = YearMonth.from(publishedDate);
            return GROUP_DATE_FORMATTER.format(ym);
        } catch (Exception e) {
            return "Unknown date";
        }
    }

    private record ReleaseCard(
            String link,
            String image,
            String banner,
            String category,
            String description,
            String date,
            LocalDate publishedDate
    ) {}

    private record ReleaseGroup(
            String label,
            List<ReleaseCard> releases
    ) {}

    private void processJavaDocs(Document websiteDocument) {
        Elements docsClassElements = websiteDocument.getElementsByAttribute("dui-site-docs");
        docsClassElements.forEach(docsClassElement -> {
            if (nonNull(docsClassElement)) {
                String docsClass = docsClassElement.attributes().get("dui-site-data");
                String idPrefix = docsClassElement.attributes().get("dui-site-data-id-prefix");
                if (!docsClass.trim().isEmpty()) {
                    loadDocsFragment(docsClass, "class").ifPresent(classDocs -> {
                        Element websiteClassDocsElement = websiteDocument.getElementById(idPrefix + "-class-docs");
                        if (nonNull(websiteClassDocsElement)) {
                            websiteClassDocsElement.html(classDocs);
                        }
                    });

                    loadDocsFragment(docsClass, "members").ifPresent(membersDocs -> {
                        Element websiteMethodsDocsElement = websiteDocument.getElementById(idPrefix + "-method-docs");
                        if (nonNull(websiteMethodsDocsElement)) {
                            websiteMethodsDocsElement.html(membersDocs);
                        }
                    });
                }
            }
        });
    }

    private Optional<String> loadDocsFragment(String docsClass, String fragmentType) {
        String resourcePath = docsClass.replace(".", "/") + "-dui-site-" + fragmentType + "-docs.html";
        try (InputStream docsStream = this.getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (docsStream == null) {
                LOGGER.warn("Missing generated JavaDoc fragment [{}] for [{}]", fragmentType, docsClass);
                return Optional.empty();
            }
            return Optional.of(new String(docsStream.readAllBytes(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            LOGGER.error("Failed to load JavaDoc fragment [{}] for [{}]", fragmentType, docsClass, e);
            return Optional.empty();
        }
    }

    private void processSideNav(Document websiteDocument) {
        Element sideNavElement = websiteDocument.getElementById("dui-site-doc-page-side-nav");
        if (nonNull(sideNavElement)) {

            String navElements = sideNavElement.attributes().get("dui-site-data");
            String sideNavHtml = Arrays.stream(navElements.split(","))
                    .map(navItem -> "<span class=\"dui dui-labeled-icon dui-reversed dui-site-side-nav-item\" onclick=\"scrollToSection('dui-side-nav-" + navItem.toLowerCase().replace(" ", "-") + "')\">\n" +
                            "            <i class=\"dui mdi " + getNavIcon(navItem) + "\"></i>\n" +
                            "            <span class=\"dui dui-mdi-text dui-text-ellipsis\">" + navItem + "</span>\n" +
                            "        </span>")
                    .collect(Collectors.joining("\n"));

            String sideDocsNavButton =
                    "<span id=\"dui-site-doc-page-side-nav-button\" class=\"dui dui-site-doc-page-side-nav-button dui-labeled-icon dui-reversed dui-site-side-nav-item dui-show-on-small-and-down dui-hide-on-medium-and-up\" > <i class=\"dui mdi mdi-gamepad-circle-left\"></i> <span class=\"dui dui-mdi-text dui-text-ellipsis\"></span> </span>\n";

            sideNavElement.append(sideDocsNavButton + sideNavHtml);
        }
    }

    private String getNavIcon(String navItem) {
        switch (navItem.toLowerCase()) {
            case "top":
                return "mdi-arrow-up-thin";
            default:
                return "mdi-circle-small";
        }
    }
}
