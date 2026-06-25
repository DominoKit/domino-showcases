package org.dominokit;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import java.util.Map;
import org.dominokit.brix.Brix;
import org.dominokit.brix.api.BrixComponentInitializer;
import org.dominokit.brix.api.BrixComponentInitializer_ServiceLoader;
import org.dominokit.brix.api.BrixStartupTask_ServiceLoader;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.rest.DominoRestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint, ElementsFactory, DominoCss {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
  private static final int CONFIG_RETRY_DELAY_MS = 1500;

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    BrixComponentInitializer_ServiceLoader.load()
        .forEach(BrixComponentInitializer::init);

    DominoRestConfig.initDefaults()
        .setDefaultServiceRoot("/api/");

    DominoThemeManager.INSTANCE.applyUserThemes();

    loadConfiguration();
  }

  private void loadConfiguration() {
    ConfigServiceFactory.INSTANCE.configs()
        .onSuccess(this::initializeApplication)
        .onFailed(failedResponse -> {
          LOGGER.error(
              "Failed to load dominokit-site configuration. Retrying in {} ms.",
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

  private void initializeApplication(Map<String, String> response) {
    Brix.get().init(response);
    Brix.get().start(BrixStartupTask_ServiceLoader.load(), () -> {
      Brix.get().config()
          .get("brix.api.url")
          .ifPresent(apiUrl -> DominoRestConfig.initDefaults().setDefaultServiceRoot(apiUrl));

      LOGGER.info("dominokit-site Application frontend have been initialized.");
      if (Brix.get().router().currentToken().isEmpty()) {
        Brix.get().router().fireState(StateToken.of("home"));
      }

      Brix.get()
          .router()
          .listen(
              TokenFilter.startsWithPathFilter("solutions/:solution/:version/docs"),
              state -> {
                ElementsFactory.elements.body().removeCss("dui-hide-left-menu");
              })
          .onDirectUrl();
      Brix.get()
          .router()
          .listen(
              TokenFilter.not(
                  TokenFilter.startsWithPathFilter("solutions/:solution/:version/docs")),
              state -> {
                ElementsFactory.elements.body().addCss("dui-hide-left-menu");
              })
          .onDirectUrl();
      Brix.get().router().fireCurrentStateHistory();
    });
  }
}
