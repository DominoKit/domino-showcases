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
import org.dominokit.demo.samples.presenters.blueprints.BrixReadOnlyPermissionVariantPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ReadOnlyPermissionVariantPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ReadOnlyPermissionVariantPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixReadOnlyPermissionVariantViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ReadOnlyPermissionVariantPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixReadOnlyPermissionVariantPresenterModule_.class,
        BrixReadOnlyPermissionVariantViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ReadOnlyPermissionVariantComponent
    extends IsBrixComponent, HasPresenterProvider<ReadOnlyPermissionVariantPresenterProvider> {

  ComponentProvider<ReadOnlyPermissionVariantComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ReadOnlyPermissionVariantComponent newInstance() {
          return DaggerReadOnlyPermissionVariantComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
