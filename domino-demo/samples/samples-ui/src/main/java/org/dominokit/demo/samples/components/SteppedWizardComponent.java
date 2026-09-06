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
import org.dominokit.demo.samples.presenters.blueprints.BrixSteppedWizardPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SteppedWizardPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SteppedWizardPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixSteppedWizardViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SteppedWizardPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSteppedWizardPresenterModule_.class,
        BrixSteppedWizardViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SteppedWizardComponent
    extends IsBrixComponent, HasPresenterProvider<SteppedWizardPresenterProvider> {

  ComponentProvider<SteppedWizardComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SteppedWizardComponent newInstance() {
          return DaggerSteppedWizardComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
