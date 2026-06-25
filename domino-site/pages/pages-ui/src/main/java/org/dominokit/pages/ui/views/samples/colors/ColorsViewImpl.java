package org.dominokit.pages.ui.views.samples.colors;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.pages.views.ColorsView;
import org.dominokit.showcases.samples.colors.ColorsSample;

@UiView
public class ColorsViewImpl extends BrixView<HTMLDivElement, ColorsView.ColorsUiHandlers>
    implements ColorsView {

  private final ColorsSample colorsSample;

  @Inject
  public ColorsViewImpl() {
    this.colorsSample = ColorsSample.create();
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return colorsSample.element();
  }
}
