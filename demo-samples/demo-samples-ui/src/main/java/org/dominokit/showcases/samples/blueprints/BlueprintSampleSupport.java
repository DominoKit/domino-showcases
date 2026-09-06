package org.dominokit.showcases.samples.blueprints;

import org.dominokit.domino.ui.elements.DivElement;

public final class BlueprintSampleSupport {

  private BlueprintSampleSupport() {}

  public static BlueprintSampleCanvas create(
      String title, String description, BlueprintSampleKind kind, String... regions) {
    return BlueprintSampleCanvas.create(title, description, kind, regions);
  }

  static DivElement panel(String title, String body) {
    return org.dominokit.domino.ui.utils.Domino.div()
        .cssText("border: 1px solid var(--dui-border-color, #d9e1ea); border-radius: 6px; padding: 12px; min-height: 72px;")
        .appendChild(org.dominokit.domino.ui.utils.Domino.h(5).textContent(title))
        .appendChild(org.dominokit.domino.ui.utils.Domino.p().textContent(body));
  }
}
