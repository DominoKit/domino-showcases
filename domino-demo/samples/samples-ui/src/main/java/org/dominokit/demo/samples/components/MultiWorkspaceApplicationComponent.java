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
import org.dominokit.demo.samples.presenters.blueprints.BrixMultiWorkspaceApplicationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.MultiWorkspaceApplicationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.MultiWorkspaceApplicationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation.BrixMultiWorkspaceApplicationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MultiWorkspaceApplicationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMultiWorkspaceApplicationPresenterModule_.class,
        BrixMultiWorkspaceApplicationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MultiWorkspaceApplicationComponent
    extends IsBrixComponent, HasPresenterProvider<MultiWorkspaceApplicationPresenterProvider> {

  ComponentProvider<MultiWorkspaceApplicationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MultiWorkspaceApplicationComponent newInstance() {
          return DaggerMultiWorkspaceApplicationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
