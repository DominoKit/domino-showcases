package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.ConflictResolutionScreenView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ConflictResolutionScreenSample;

@UiView
public class ConflictResolutionScreenViewImpl extends BlueprintSamplePageView<ConflictResolutionScreenView.ConflictResolutionScreenUiHandlers>
    implements ConflictResolutionScreenView {

  @Inject
  public ConflictResolutionScreenViewImpl() {
    super("Conflict-resolution screen", "Layout: Local changes and current server values are shown side by side or in a field-level conflict list. Interaction: Users keep local, accept remote, merge fields, and retry the save. Variants: Record conflict, document conflict, or concurrent bulk-change conflict.");
    addSample("Conflict-resolution screen", "Layout: Local changes and current server values are shown side by side or in a field-level conflict list. Interaction: Users keep local, accept remote, merge fields, and retry the save. Variants: Record conflict, document conflict, or concurrent bulk-change conflict.", ConflictResolutionScreenSample.class, ConflictResolutionScreenSample::create);
    initPage();
  }
}
