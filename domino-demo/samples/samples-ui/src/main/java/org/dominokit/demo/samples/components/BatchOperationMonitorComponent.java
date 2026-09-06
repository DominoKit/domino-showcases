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
import org.dominokit.demo.samples.presenters.blueprints.BrixBatchOperationMonitorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.BatchOperationMonitorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.BatchOperationMonitorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixBatchOperationMonitorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = BatchOperationMonitorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixBatchOperationMonitorPresenterModule_.class,
        BrixBatchOperationMonitorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BatchOperationMonitorComponent
    extends IsBrixComponent, HasPresenterProvider<BatchOperationMonitorPresenterProvider> {

  ComponentProvider<BatchOperationMonitorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected BatchOperationMonitorComponent newInstance() {
          return DaggerBatchOperationMonitorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
