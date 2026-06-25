package org.dominokit.demo;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.Map;
import org.dominokit.brix.Brix;
import org.dominokit.brix.api.BrixComponentInitializer;
import org.dominokit.brix.api.BrixComponentInitializer_ServiceLoader;
import org.dominokit.brix.api.BrixStartupTask_ServiceLoader;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.rest.DominoRestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint, ElementsFactory, DominoCss {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
  private static final int CONFIG_RETRY_DELAY_MS = 1500;
  private static final String REMOTE_APP_ROOT = "/domino-ui/demo/v2";
  private static final String DEFAULT_API_ROOT = "/api/";
  private static final String REMOTE_API_ROOT = REMOTE_APP_ROOT + "/api/";

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    BrixComponentInitializer_ServiceLoader.load()
        .forEach(BrixComponentInitializer::init);

    DominoRestConfig.initDefaults()
        .setDefaultServiceRoot(resolveInitialApiRoot());

    DominoThemeManager.INSTANCE.applyUserThemes();

    loadConfiguration();
  }

  private void loadConfiguration() {
    ConfigServiceFactory.INSTANCE.configs()
        .onSuccess(this::initializeApplication)
        .onFailed(failedResponse -> {
          LOGGER.error(
              "Failed to load domino-demo configuration. Retrying in {} ms.",
              CONFIG_RETRY_DELAY_MS);
          new Timer() {
            @Override
            public void run() {
              loadConfiguration();
            }
          }.schedule(CONFIG_RETRY_DELAY_MS);
        })
        .send();
  }

  private String resolveInitialApiRoot() {
    String path = Window.Location.getPath();
    if (path == null || path.isEmpty()) {
      return DEFAULT_API_ROOT;
    }

    return path.startsWith(REMOTE_APP_ROOT) ? REMOTE_API_ROOT : DEFAULT_API_ROOT;
  }

  private void initializeApplication(Map<String, String> response) {
    Brix.get().init(response);
    Brix.get().config()
        .get("brix.api.url")
        .ifPresent(apiUrl -> DominoRestConfig.initDefaults().setDefaultServiceRoot(apiUrl));

    Brix.get().start(BrixStartupTask_ServiceLoader.load(), () -> {
      Brix.get().config()
          .get("brix.application.root")
          .map(String::trim)
          .filter(appRoot -> !appRoot.isEmpty())
          .filter(appRoot -> !".".equals(appRoot))
          .filter(appRoot -> !"./".equals(appRoot))
          .map(this::normalizeRouterRootPath)
          .filter(appRoot -> !appRoot.isEmpty())
          .ifPresent(appRoot -> Brix.get().router().setRootPath(appRoot));

      LOGGER.info("domino-demo frontend initialized.");
      if (Brix.get().router().currentToken().isEmpty()) {
        Brix.get().router().fireState(StateToken.of("home"));
      }

      Brix.get().router().fireCurrentStateHistory();
    });
  }

  private String normalizeRouterRootPath(String appRoot) {
    String normalized = appRoot == null ? "" : appRoot.trim();
    while (normalized.startsWith("/")) {
      normalized = normalized.substring(1);
    }
    while (normalized.endsWith("/")) {
      normalized = normalized.substring(0, normalized.length() - 1);
    }
    return normalized;
  }
}
