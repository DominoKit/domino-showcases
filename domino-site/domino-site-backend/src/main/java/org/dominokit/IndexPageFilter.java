package org.dominokit;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.web.Router;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.dominokit.provider.IndexPageRenderer;
import org.dominokit.provider.TemplatesContext;

@ApplicationScoped
public class IndexPageFilter {
  @Inject
  Router router;

    @Inject
    IndexPageRenderer renderer;

  void init(@Observes StartupEvent ev) {

    router.route("/")
        .handler(routingContext -> {
            String html = renderer.render("index", TemplatesContext.get());
            routingContext.response()
                    .putHeader("Content-Type", "text/html; charset=UTF-8")
                    .end(html);
        });


  }
}
