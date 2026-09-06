package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.ResponsiveDensityTransformationView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ResponsiveDensityTransformationSample;

@UiView
public class ResponsiveDensityTransformationViewImpl extends BlueprintSamplePageView<ResponsiveDensityTransformationView.ResponsiveDensityTransformationUiHandlers>
    implements ResponsiveDensityTransformationView {

  @Inject
  public ResponsiveDensityTransformationViewImpl() {
    super("Responsive density transformation", "Layout: Desktop table/panel composition transforms into cards, drawers, stacked sections, or prioritized fields on narrow screens. Interaction: Users retain the same task flow through mobile-friendly navigation and action placement. Variants: Table-to-card, split-to-drill-in, or toolbar-to-bottom-action-bar.");
    addSample("Responsive density transformation", "Layout: Desktop table/panel composition transforms into cards, drawers, stacked sections, or prioritized fields on narrow screens. Interaction: Users retain the same task flow through mobile-friendly navigation and action placement. Variants: Table-to-card, split-to-drill-in, or toolbar-to-bottom-action-bar.", ResponsiveDensityTransformationSample.class, ResponsiveDensityTransformationSample::create);
    initPage();
  }
}
