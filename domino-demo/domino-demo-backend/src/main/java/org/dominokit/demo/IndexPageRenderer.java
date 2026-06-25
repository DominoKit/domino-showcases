package org.dominokit.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class IndexPageRenderer {

  private static final String INDEX_TEMPLATE = "index.ftl";
  private static final String DOMINO_UI_PRO_STYLESHEET =
      "META-INF/resources/app/css/domino-ui-pro/domino-ui-pro.css";

  private final Configuration configuration = new Configuration(Configuration.VERSION_2_3_33);
  private final String appRootPath;
  private final boolean hasDominoUiProStyles;

  private Template template;

  IndexPageRenderer(@ConfigProperty(name = "brix.application.root") Optional<String> brixAppRoot) {
    this.appRootPath = normalizeAppRoot(brixAppRoot.orElse(""));
    this.hasDominoUiProStyles = resourceExists(DOMINO_UI_PRO_STYLESHEET);
  }

  @PostConstruct
  void init() {
    configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
    configuration.setClassLoaderForTemplateLoading(
        Thread.currentThread().getContextClassLoader(), "templates");

    try {
      template = configuration.getTemplate(INDEX_TEMPLATE);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load template " + INDEX_TEMPLATE, e);
    }
  }

  public String render() {
    Map<String, Object> templateContext = new HashMap<>();
    templateContext.put("appRootPath", appRootPath);
    templateContext.put("hasDominoUiProStyles", hasDominoUiProStyles);

    StringWriter writer = new StringWriter();
    try {
      template.process(templateContext, writer);
      return writer.toString();
    } catch (IOException | TemplateException e) {
      throw new IllegalStateException("Failed to render index template", e);
    }
  }

  private boolean resourceExists(String resourcePath) {
    return Thread.currentThread().getContextClassLoader().getResource(resourcePath) != null;
  }

  private String normalizeAppRoot(String rawRoot) {
    String normalized = rawRoot == null ? "" : rawRoot.trim();
    if (normalized.isEmpty() || ".".equals(normalized) || "./".equals(normalized)) {
      return "";
    }
    if (!normalized.startsWith("/")) {
      normalized = "/" + normalized;
    }
    if (normalized.endsWith("/")) {
      normalized = normalized.substring(0, normalized.length() - 1);
    }
    return normalized;
  }
}
