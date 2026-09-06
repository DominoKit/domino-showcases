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
import org.dominokit.demo.samples.presenters.blueprints.BrixConflictResolutionScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ConflictResolutionScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ConflictResolutionScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixConflictResolutionScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ConflictResolutionScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixConflictResolutionScreenPresenterModule_.class,
        BrixConflictResolutionScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ConflictResolutionScreenComponent
    extends IsBrixComponent, HasPresenterProvider<ConflictResolutionScreenPresenterProvider> {

  ComponentProvider<ConflictResolutionScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ConflictResolutionScreenComponent newInstance() {
          return DaggerConflictResolutionScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
