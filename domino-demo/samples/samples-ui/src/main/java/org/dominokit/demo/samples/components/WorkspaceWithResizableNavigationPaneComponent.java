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
import org.dominokit.demo.samples.presenters.blueprints.BrixWorkspaceWithResizableNavigationPanePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.WorkspaceWithResizableNavigationPanePresenter;
import org.dominokit.demo.samples.presenters.blueprints.WorkspaceWithResizableNavigationPanePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation.BrixWorkspaceWithResizableNavigationPaneViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = WorkspaceWithResizableNavigationPanePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixWorkspaceWithResizableNavigationPanePresenterModule_.class,
        BrixWorkspaceWithResizableNavigationPaneViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface WorkspaceWithResizableNavigationPaneComponent
    extends IsBrixComponent, HasPresenterProvider<WorkspaceWithResizableNavigationPanePresenterProvider> {

  ComponentProvider<WorkspaceWithResizableNavigationPaneComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected WorkspaceWithResizableNavigationPaneComponent newInstance() {
          return DaggerWorkspaceWithResizableNavigationPaneComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
