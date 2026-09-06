package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.WizardWithReviewAndConfirmStepView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(WizardWithReviewAndConfirmStepPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class WizardWithReviewAndConfirmStepPresenter extends ChildPresenter<ShellPresenter, WizardWithReviewAndConfirmStepView>
    implements WizardWithReviewAndConfirmStepView.WizardWithReviewAndConfirmStepUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows/wizard-with-review-and-confirm-step";
}
