package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.UnsavedChangesProtectionView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.UnsavedChangesProtectionSample;

@UiView
public class UnsavedChangesProtectionViewImpl extends SamplePageView<UnsavedChangesProtectionView.UnsavedChangesProtectionUiHandlers>
    implements UnsavedChangesProtectionView {

  @Inject
  public UnsavedChangesProtectionViewImpl() {
    super("Unsaved-changes protection", "Layout: Editable screen includes dirty-state indicators and an explicit save/cancel footer or toolbar. Interaction: Users save, discard, continue editing, or resolve navigation/unload warnings. Variants: Single form, multi-tab form, or multi-record editing.");
    addSample("Unsaved-changes protection", "Layout: Editable screen includes dirty-state indicators and an explicit save/cancel footer or toolbar. Interaction: Users save, discard, continue editing, or resolve navigation/unload warnings. Variants: Single form, multi-tab form, or multi-record editing.", UnsavedChangesProtectionSample.class, UnsavedChangesProtectionSample::create);
    initPage();
  }
}
