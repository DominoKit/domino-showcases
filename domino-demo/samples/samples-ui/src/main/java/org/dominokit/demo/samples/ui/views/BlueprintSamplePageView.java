package org.dominokit.demo.samples.ui.views;

import org.dominokit.brix.api.UiHandlers;
import org.dominokit.demo.samples.ui.components.BlueprintShowcase;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.layout.NavBar;

import java.util.function.Supplier;

public abstract class BlueprintSamplePageView<H extends UiHandlers>
    extends SamplePageView<H> {

  protected BlueprintSamplePageView(String title, String description) {
    super(title, description, NavBar.create(title).setDescription(description));
  }

  @Override
  protected <T extends IsElement<?>> void addSample(
          String title, String description, Class<?> sampleClass, Supplier<T> supplier) {
    root.appendChild(BlueprintShowcase.create(title, description, sampleClass, supplier));
  }
}
