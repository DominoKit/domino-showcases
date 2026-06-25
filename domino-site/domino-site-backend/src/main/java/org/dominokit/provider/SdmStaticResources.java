package org.dominokit.provider;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.FileSystemAccess;
import io.vertx.ext.web.handler.StaticHandler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@IfBuildProfile("dev") // only active in dev
public class SdmStaticResources {

    /**
     * Absolute path to the GWT / brix SDM output.
     * Example: /home/ahmad/work/domino-site/target/sdm-webroot
     */
    @ConfigProperty(name = "brix.dev.web.root")
    String sdmWebRoot;

    /**
     * The web root for the SPA (usually "app").
     * So SDM resources will be served under /app/**
     */
    @ConfigProperty(name = "brix.dev.application.root", defaultValue = "app")
    String appRoot;

    void installRoute(@Observes StartupEvent startupEvent, Router router) {
        String resolvedRoot = resolveRoot(sdmWebRoot);

        System.out.println("SDM static root = " + resolvedRoot + ", appRoot = " + appRoot);

        router.route("/" + appRoot + "/*")
                .order(Integer.MIN_VALUE)
                .handler(
                        StaticHandler.create(FileSystemAccess.ROOT, resolvedRoot)
                                .setCachingEnabled(false)
                                .setDefaultContentEncoding("UTF-8")
                );
    }

    private String resolveRoot(String configuredPath) {
        Path configured = Paths.get(configuredPath).normalize();
        if (configured.isAbsolute()) {
            return configured.toAbsolutePath().normalize().toString();
        }

        Path current = Paths.get(System.getProperty("user.dir")).toAbsolutePath().normalize();
        while (current != null) {
            Path candidate = current.resolve(configured).normalize();
            if (Files.isDirectory(candidate)) {
                return candidate.toAbsolutePath().normalize().toString();
            }
            current = current.getParent();
        }

        return configured.toAbsolutePath().normalize().toString();
    }
}
