package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.GuidedFirstRunExperienceView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.GuidedFirstRunExperienceSample;

@UiView
public class GuidedFirstRunExperienceViewImpl extends BlueprintSamplePageView<GuidedFirstRunExperienceView.GuidedFirstRunExperienceUiHandlers>
    implements GuidedFirstRunExperienceView {

  @Inject
  public GuidedFirstRunExperienceViewImpl() {
    super("Guided first-run experience", "Layout: Empty or lightly populated workspace is paired with onboarding steps, contextual tips, and sample actions. Interaction: Users complete setup, skip or resume guidance, and reach the first meaningful result. Variants: Product onboarding, tenant setup, or feature-specific tour.");
    addSample("Guided first-run experience", "Layout: Empty or lightly populated workspace is paired with onboarding steps, contextual tips, and sample actions. Interaction: Users complete setup, skip or resume guidance, and reach the first meaningful result. Variants: Product onboarding, tenant setup, or feature-specific tour.", GuidedFirstRunExperienceSample.class, GuidedFirstRunExperienceSample::create);
    initPage();
  }
}
