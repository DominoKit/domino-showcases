package org.dominokit.demo.samples.ui.views.colors;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.colors.ColorsView;
import org.dominokit.showcases.samples.colors.ColorsSample;

@UiView
public class ColorsViewImpl extends SamplePageView<ColorsView.ColorsUiHandlers>
    implements ColorsView {

  private final ColorsSample colorsSample;

  @Inject
  public ColorsViewImpl() {
    super("Colors", "Material and semantic color palettes rendered from the shared demo-samples module.");
    this.colorsSample = ColorsSample.create();
    root.appendChild(colorsSample);
    initPage();
  }
}
