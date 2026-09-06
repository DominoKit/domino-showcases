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
import org.dominokit.demo.samples.presenters.blueprints.BrixUnsavedChangesProtectionPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.UnsavedChangesProtectionPresenter;
import org.dominokit.demo.samples.presenters.blueprints.UnsavedChangesProtectionPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixUnsavedChangesProtectionViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = UnsavedChangesProtectionPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixUnsavedChangesProtectionPresenterModule_.class,
        BrixUnsavedChangesProtectionViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface UnsavedChangesProtectionComponent
    extends IsBrixComponent, HasPresenterProvider<UnsavedChangesProtectionPresenterProvider> {

  ComponentProvider<UnsavedChangesProtectionComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected UnsavedChangesProtectionComponent newInstance() {
          return DaggerUnsavedChangesProtectionComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
