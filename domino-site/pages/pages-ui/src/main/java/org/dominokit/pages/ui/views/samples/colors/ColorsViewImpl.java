package org.dominokit.pages.ui.views.samples.colors;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.Domino;
import org.dominokit.pages.views.ColorsView;
import org.dominokit.showcases.samples.colors.ColorsSample;
import org.dominokit.showcases.samples.themes.ThemeCompositionSample;

@UiView
public class ColorsViewImpl extends BrixView<HTMLDivElement, ColorsView.ColorsUiHandlers>
    implements ColorsView {

  private final DivElement root;

  @Inject
  public ColorsViewImpl() {
    this.root =
        Domino.div()
            .appendChild(ColorsSample.create())
            .appendChild(ThemeCompositionSample.create());
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
