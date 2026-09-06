package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.LoadingAndProgressiveContentScreenView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.LoadingAndProgressiveContentScreenSample;

@UiView
public class LoadingAndProgressiveContentScreenViewImpl extends BlueprintSamplePageView<LoadingAndProgressiveContentScreenView.LoadingAndProgressiveContentScreenUiHandlers>
    implements LoadingAndProgressiveContentScreenView {

  @Inject
  public LoadingAndProgressiveContentScreenViewImpl() {
    super("Loading and progressive-content screen", "Layout: Stable page structure appears immediately while cards, rows, and detail sections load progressively. Interaction: Users can use ready regions while slower regions resolve or retry. Variants: Skeleton loading, staged panels, or table placeholder rows.");
    addSample("Loading and progressive-content screen", "Layout: Stable page structure appears immediately while cards, rows, and detail sections load progressively. Interaction: Users can use ready regions while slower regions resolve or retry. Variants: Skeleton loading, staged panels, or table placeholder rows.", LoadingAndProgressiveContentScreenSample.class, LoadingAndProgressiveContentScreenSample::create);
    initPage();
  }
}
