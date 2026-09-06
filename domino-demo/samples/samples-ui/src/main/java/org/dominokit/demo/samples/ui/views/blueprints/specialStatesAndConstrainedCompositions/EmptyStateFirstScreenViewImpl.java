package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.EmptyStateFirstScreenView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.EmptyStateFirstScreenSample;

@UiView
public class EmptyStateFirstScreenViewImpl extends SamplePageView<EmptyStateFirstScreenView.EmptyStateFirstScreenUiHandlers>
    implements EmptyStateFirstScreenView {

  @Inject
  public EmptyStateFirstScreenViewImpl() {
    super("Empty-state-first screen", "Layout: The normal page shell is present but the primary content area explains the absence of records and offers a clear next action. Interaction: Users create the first record, import data, adjust filters, or learn more. Variants: First-use empty state, filtered-empty state, or permission-empty state.");
    addSample("Empty-state-first screen", "Layout: The normal page shell is present but the primary content area explains the absence of records and offers a clear next action. Interaction: Users create the first record, import data, adjust filters, or learn more. Variants: First-use empty state, filtered-empty state, or permission-empty state.", EmptyStateFirstScreenSample.class, EmptyStateFirstScreenSample::create);
    initPage();
  }
}
