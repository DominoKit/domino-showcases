package org.dominokit.demo.samples.ui.components;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.function.Supplier;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;

public class BlueprintShowcase<T extends IsElement<?>> extends BaseDominoElement<HTMLDivElement, BlueprintShowcase<T>> {

  private final DivElement root;
  private final DivElement sampleContainer;

  public static <T extends IsElement<?>> BlueprintShowcase<T> create(
      String title, String description, Class<?> sampleClass, Supplier<T> supplier) {
    return new BlueprintShowcase<>(title, description, sampleClass, supplier);
  }

  public BlueprintShowcase(
      String title, String description, Class<?> sampleClass, Supplier<T> supplier) {
    this.sampleContainer = div();
    this.root =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(Card.create(title, description).appendChild(sampleContainer))
            .appendChild(SampleCodeCard.create(sampleClass));
    this.root.setId(anchorId(title));

    init(this);
    nowAndWhenAttached(() -> mountSample(supplier));
  }

  private void mountSample(Supplier<T> supplier) {
    sampleContainer.clearElement();
    try {
      T sample = supplier.get();
      if (sample != null) {
        sampleContainer.appendChild(sample);
      } else {
        sampleContainer.appendChild(div().textContent("Sample is not available."));
      }
    } catch (Throwable error) {
      sampleContainer.appendChild(div().textContent("Failed to render sample."));
    }
  }

  private String anchorId(String title) {
    return title.toLowerCase().replaceAll("[^a-z0-9]+", "-");
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
