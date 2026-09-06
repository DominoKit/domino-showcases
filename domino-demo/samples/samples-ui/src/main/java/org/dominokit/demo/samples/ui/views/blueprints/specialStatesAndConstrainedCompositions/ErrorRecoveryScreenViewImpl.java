package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.ErrorRecoveryScreenView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ErrorRecoveryScreenSample;

@UiView
public class ErrorRecoveryScreenViewImpl extends SamplePageView<ErrorRecoveryScreenView.ErrorRecoveryScreenUiHandlers>
    implements ErrorRecoveryScreenView {

  @Inject
  public ErrorRecoveryScreenViewImpl() {
    super("Error recovery screen", "Layout: Failed content is localized with a clear explanation, affected region, retry action, and optional diagnostic detail. Interaction: Users retry, change filters, report the issue, or continue with unaffected content. Variants: Full-page failure, partial panel failure, or failed mutation recovery.");
    addSample("Error recovery screen", "Layout: Failed content is localized with a clear explanation, affected region, retry action, and optional diagnostic detail. Interaction: Users retry, change filters, report the issue, or continue with unaffected content. Variants: Full-page failure, partial panel failure, or failed mutation recovery.", ErrorRecoveryScreenSample.class, ErrorRecoveryScreenSample::create);
    initPage();
  }
}
