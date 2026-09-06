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
import org.dominokit.demo.samples.presenters.blueprints.BrixHierarchicalEntityExplorerPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.HierarchicalEntityExplorerPresenter;
import org.dominokit.demo.samples.presenters.blueprints.HierarchicalEntityExplorerPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces.BrixHierarchicalEntityExplorerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = HierarchicalEntityExplorerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixHierarchicalEntityExplorerPresenterModule_.class,
        BrixHierarchicalEntityExplorerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface HierarchicalEntityExplorerComponent
    extends IsBrixComponent, HasPresenterProvider<HierarchicalEntityExplorerPresenterProvider> {

  ComponentProvider<HierarchicalEntityExplorerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected HierarchicalEntityExplorerComponent newInstance() {
          return DaggerHierarchicalEntityExplorerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
