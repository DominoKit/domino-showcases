package org.dominokit.demo.samples.ui.views.icons;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.icons.IconsView;
import org.dominokit.showcases.samples.icons.MdiIconsSample;

@UiView
public class IconsViewImpl extends SamplePageView<IconsView.IconsUiHandlers>
    implements IconsView {

  private final MdiIconsSample iconsSample;

  @Inject
  public IconsViewImpl() {
    super("MDI Icons", "Browse, search, and copy shared Material Design Icons samples.");
    this.iconsSample = MdiIconsSample.create();
    root.appendChild(iconsSample);
    initPage();
  }

  @Override
  public void setTag(String tag) {
    iconsSample.setTag(tag);
  }
}
