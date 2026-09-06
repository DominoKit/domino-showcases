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
import org.dominokit.demo.samples.presenters.blueprints.BrixDataCleanupWorkspacePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.DataCleanupWorkspacePresenter;
import org.dominokit.demo.samples.presenters.blueprints.DataCleanupWorkspacePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixDataCleanupWorkspaceViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DataCleanupWorkspacePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDataCleanupWorkspacePresenterModule_.class,
        BrixDataCleanupWorkspaceViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DataCleanupWorkspaceComponent
    extends IsBrixComponent, HasPresenterProvider<DataCleanupWorkspacePresenterProvider> {

  ComponentProvider<DataCleanupWorkspaceComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DataCleanupWorkspaceComponent newInstance() {
          return DaggerDataCleanupWorkspaceComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
