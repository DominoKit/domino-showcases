package org.dominokit.demo.samples.ui.components;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;

import elemental2.dom.HTMLDivElement;
import java.util.function.Supplier;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class SampleShowcase<T extends IsElement<?>> extends BaseDominoElement<HTMLDivElement, SampleShowcase<T>> {

  private final DivElement root;

  public static <T extends IsElement<?>> SampleShowcase<T> create(
      String title, String description, Class<?> sampleClass, Supplier<T> supplier) {
    return new SampleShowcase<>(title, description, sampleClass, supplier);
  }

  public SampleShowcase(
      String title, String description, Class<?> sampleClass, Supplier<T> supplier) {
    this.root =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(
                Card.create(title, description)
                    .appendChild(supplier.get()))
            .appendChild(SampleCodeCard.create(sampleClass));

    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
