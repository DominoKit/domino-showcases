package org.dominokit.demo.samples.ui.views;

import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.brix.api.UiHandlers;

public abstract class BlueprintSamplePageView<H extends UiHandlers>
    extends SamplePageView<H> {

  protected BlueprintSamplePageView(String title, String description) {
    super(title, description, NavBar.create(title).setDescription(description));
  }
}
