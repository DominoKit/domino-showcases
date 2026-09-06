package org.dominokit.demo.samples.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.demo.samples.presenters.blueprints.BrixWizardWithReviewAndConfirmStepPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.WizardWithReviewAndConfirmStepPresenter;
import org.dominokit.demo.samples.presenters.blueprints.WizardWithReviewAndConfirmStepPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixWizardWithReviewAndConfirmStepViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = WizardWithReviewAndConfirmStepPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixWizardWithReviewAndConfirmStepPresenterModule_.class,
        BrixWizardWithReviewAndConfirmStepViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface WizardWithReviewAndConfirmStepComponent
    extends IsBrixComponent, HasPresenterProvider<WizardWithReviewAndConfirmStepPresenterProvider> {

  ComponentProvider<WizardWithReviewAndConfirmStepComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected WizardWithReviewAndConfirmStepComponent newInstance() {
          return DaggerWizardWithReviewAndConfirmStepComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
