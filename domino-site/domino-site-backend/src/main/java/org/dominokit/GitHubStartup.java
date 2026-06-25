package org.dominokit;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.dominokit.provider.GitHub;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.dominokit.provider.GitHubRepositories;

@ApplicationScoped
public class GitHubStartup {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(GitHubStartup.class);

    @ConfigProperty(name = "GITHUB_APP_PRIVATE_KEY")
    Optional<String> privateKey;

    @ConfigProperty(name = "GITHUB_APP_ID")
    Optional<String> appId;

    @ConfigProperty(name = "GITHUB_APP_PRIVATE_KEY_FILE")
    Optional<String> privateKeyFile;

    void onStart(@Observes StartupEvent event) {
        String resolvedAppId = appId.orElse("").trim();
        String resolvedPrivateKey = resolvePrivateKey();

        if (resolvedAppId.isEmpty() || resolvedPrivateKey.isEmpty()) {
            LOGGER.info("GitHub startup fetch skipped: missing GITHUB_APP_ID or GitHub private key configuration");
            return;
        }

        try {
            GitHub gitHub = new GitHub(Long.parseLong(resolvedAppId), resolvedPrivateKey);
            List<GitHub.Release> dominokit = gitHub.listAllReleases(GitHubRepositories.REPOSITORIES);
            dominokit.forEach(release -> LOGGER.info(release.repository() + ":" + release.name()));
        } catch (Exception e) {
            LOGGER.warn("GitHub startup fetch skipped: failed to initialize GitHub client", e);
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
}
