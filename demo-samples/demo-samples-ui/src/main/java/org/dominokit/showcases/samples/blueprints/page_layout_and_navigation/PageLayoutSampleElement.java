package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public final class PageLayoutSampleElement
    extends BaseDominoElement<HTMLDivElement, PageLayoutSampleElement> {

  private final DivElement root;

  private PageLayoutSampleElement(DivElement root) {
    this.root = root;
    init(this);
  }

  public static PageLayoutSampleElement create(DivElement root) {
    return new PageLayoutSampleElement(root);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
