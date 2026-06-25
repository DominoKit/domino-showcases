package org.dominokit.demo;

import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ConfigUtils;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.FileSystemAccess;
import io.vertx.ext.web.handler.StaticHandler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import java.nio.file.Paths;
import java.util.Optional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class IndexPageFilter {
  @Inject
  Router router;

  @ConfigProperty(name = "brix.dev.web.root")
  String brixDevWebRoot;
  @ConfigProperty(name = "brix.application.root")
  Optional<String> brixAppRoot;

  void init(@Observes StartupEvent ev) {
    String applicationRoot = normalizeAppRoot(brixAppRoot.orElse(""));

    if (!applicationRoot.isEmpty()) {
      String applicationPrefix = "/" + applicationRoot;

      router
          .route(applicationPrefix)
          .handler(routingContext -> routingContext.reroute("/"));

      router
          .route(applicationPrefix + "/*")
          .handler(
              routingContext ->
                  routingContext.reroute(
                      stripApplicationRoot(routingContext.request().path(), applicationPrefix)));
    }

    StaticHandler webRootStaticHandler =
        StaticHandler.create(FileSystemAccess.ROOT, systemWebRoot());

    if (ConfigUtils.getProfiles().contains("dev")) {
      router
          .route("/*")
          .handler(webRootStaticHandler);
    }
  }

  private String stripApplicationRoot(String requestPath, String applicationPrefix) {
    String normalizedPath = requestPath == null ? "" : requestPath.trim();

    if (normalizedPath.equals(applicationPrefix)) {
      return "/";
    }

    if (normalizedPath.startsWith(applicationPrefix + "/")) {
      String strippedPath = normalizedPath.substring(applicationPrefix.length());
      return strippedPath.isEmpty() ? "/" : strippedPath;
    }

    return normalizedPath.isEmpty() ? "/" : normalizedPath;
  }

  private String systemWebRoot() {
    return Paths.get(brixDevWebRoot).toAbsolutePath().toString();
  }

  private String normalizeAppRoot(String rawRoot) {
    String normalized = rawRoot == null ? "" : rawRoot.trim();
    if (normalized.isEmpty() || ".".equals(normalized) || "./".equals(normalized)) {
      return "";
    }
    if (normalized.startsWith("/")) {
      normalized = normalized.substring(1);
    }
    if (normalized.endsWith("/")) {
      normalized = normalized.substring(0, normalized.length() - 1);
    }
    return normalized;
  }
}
