package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public final class ApplicationFoundationSampleElement
    extends BaseDominoElement<HTMLDivElement, ApplicationFoundationSampleElement> {

  private final DivElement root;

  private ApplicationFoundationSampleElement(DivElement root) {
    this.root = root;
    init(this);
  }

  public static ApplicationFoundationSampleElement create(DivElement root) {
    return new ApplicationFoundationSampleElement(root);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
