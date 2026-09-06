package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.WizardWithReviewAndConfirmStepView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.WizardWithReviewAndConfirmStepSample;

@UiView
public class WizardWithReviewAndConfirmStepViewImpl extends BlueprintSamplePageView<WizardWithReviewAndConfirmStepView.WizardWithReviewAndConfirmStepUiHandlers>
    implements WizardWithReviewAndConfirmStepView {

  @Inject
  public WizardWithReviewAndConfirmStepViewImpl() {
    super("Wizard with review-and-confirm step", "Layout: Data-entry steps are followed by a read-only summary with grouped changes and warnings. Interaction: Users jump back to correct a section, confirm, and submit the complete operation. Variants: Pricing preview, policy acceptance, or batch creation.");
    addSample("Wizard with review-and-confirm step", "Layout: Data-entry steps are followed by a read-only summary with grouped changes and warnings. Interaction: Users jump back to correct a section, confirm, and submit the complete operation. Variants: Pricing preview, policy acceptance, or batch creation.", WizardWithReviewAndConfirmStepSample.class, WizardWithReviewAndConfirmStepSample::create);
    initPage();
  }
}
