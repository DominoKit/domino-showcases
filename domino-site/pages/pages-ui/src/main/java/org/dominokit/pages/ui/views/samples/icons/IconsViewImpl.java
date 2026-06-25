package org.dominokit.pages.ui.views.samples.icons;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.pages.views.IconsView;
import org.dominokit.showcases.samples.icons.MdiIconsSample;

@UiView
public class IconsViewImpl extends BrixView<HTMLDivElement, IconsView.IconsUiHandlers>
    implements IconsView {

  private final MdiIconsSample iconsSample;

  @Inject
  public IconsViewImpl() {
    this.iconsSample = MdiIconsSample.create();
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return iconsSample.element();
  }

  @Override
  public void setTag(String tag) {
    iconsSample.setTag(tag);
  }
}
