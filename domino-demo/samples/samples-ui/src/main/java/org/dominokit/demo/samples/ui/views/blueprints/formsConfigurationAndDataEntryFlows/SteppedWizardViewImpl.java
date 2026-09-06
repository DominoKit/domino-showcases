package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.SteppedWizardView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.SteppedWizardSample;

@UiView
public class SteppedWizardViewImpl extends BlueprintSamplePageView<SteppedWizardView.SteppedWizardUiHandlers>
    implements SteppedWizardView {

  @Inject
  public SteppedWizardViewImpl() {
    super("Stepped wizard", "Layout: Stepper indicates progress, with one focused form section per step and a final review. Interaction: Users move back and forward, save progress, validate each step, and submit at the end. Variants: Linear required steps, optional steps, or branching steps.");
    addSample("Stepped wizard", "Layout: Stepper indicates progress, with one focused form section per step and a final review. Interaction: Users move back and forward, save progress, validate each step, and submit at the end. Variants: Linear required steps, optional steps, or branching steps.", SteppedWizardSample.class, SteppedWizardSample::create);
    initPage();
  }
}
