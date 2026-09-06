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
import org.dominokit.demo.samples.presenters.blueprints.BrixErrorRecoveryScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ErrorRecoveryScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ErrorRecoveryScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixErrorRecoveryScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ErrorRecoveryScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixErrorRecoveryScreenPresenterModule_.class,
        BrixErrorRecoveryScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ErrorRecoveryScreenComponent
    extends IsBrixComponent, HasPresenterProvider<ErrorRecoveryScreenPresenterProvider> {

  ComponentProvider<ErrorRecoveryScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ErrorRecoveryScreenComponent newInstance() {
          return DaggerErrorRecoveryScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
