package org.dominokit.demo.samples.ui.views;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import java.util.function.Supplier;
import org.dominokit.brix.api.UiHandlers;
import org.dominokit.brix.api.Viewable;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;

public abstract class SamplePageView<H extends UiHandlers> extends BrixView<HTMLDivElement, H>
    implements Viewable {

  private static final String DEFAULT_SAMPLE_DESCRIPTION =
      "Shared sample implementation from the demo-samples module.";

  protected final DivElement root;

  protected SamplePageView(String title, String description) {
    this.root =
        div()
            .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(BlockHeader.create(title, description));
  }

  protected <T extends IsElement<?>> void addSample(Class<?> sampleClass, Supplier<T> supplier) {
    addSample(defaultTitle(sampleClass), DEFAULT_SAMPLE_DESCRIPTION, sampleClass, supplier);
  }

  protected <T extends IsElement<?>> void addSample(
      String title, Class<?> sampleClass, Supplier<T> supplier) {
    addSample(title, DEFAULT_SAMPLE_DESCRIPTION, sampleClass, supplier);
  }

  protected <T extends IsElement<?>> void addSample(
      String title, String description, Class<?> sampleClass, Supplier<T> supplier) {
    root.appendChild(SampleShowcase.create(title, description, sampleClass, supplier));
  }

  protected void initPage() {
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  private String defaultTitle(Class<?> sampleClass) {
    return sampleClass
        .getSimpleName()
        .replace("Sample", "")
        .replace("Playground", " Playground")
        .replaceAll("([a-z\\d])([A-Z])", "$1 $2")
        .replaceAll("([A-Z]+)([A-Z][a-z])", "$1 $2")
        .trim();
  }
}
