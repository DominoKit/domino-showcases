package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.ReadOnlyPermissionVariantView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ReadOnlyPermissionVariantSample;

@UiView
public class ReadOnlyPermissionVariantViewImpl extends SamplePageView<ReadOnlyPermissionVariantView.ReadOnlyPermissionVariantUiHandlers>
    implements ReadOnlyPermissionVariantView {

  @Inject
  public ReadOnlyPermissionVariantViewImpl() {
    super("Read-only permission variant", "Layout: Editing controls are removed or replaced with explanatory permission messaging while the information hierarchy remains intact. Interaction: Users inspect, copy, export where allowed, or request access. Variants: Field-level masking, section-level read-only, or complete read-only page.");
    addSample("Read-only permission variant", "Layout: Editing controls are removed or replaced with explanatory permission messaging while the information hierarchy remains intact. Interaction: Users inspect, copy, export where allowed, or request access. Variants: Field-level masking, section-level read-only, or complete read-only page.", ReadOnlyPermissionVariantSample.class, ReadOnlyPermissionVariantSample::create);
    initPage();
  }
}
