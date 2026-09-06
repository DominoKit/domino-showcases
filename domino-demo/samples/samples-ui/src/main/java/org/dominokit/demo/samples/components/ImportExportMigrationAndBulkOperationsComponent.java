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
import org.dominokit.demo.samples.presenters.blueprints.BrixImportExportMigrationAndBulkOperationsPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ImportExportMigrationAndBulkOperationsPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ImportExportMigrationAndBulkOperationsPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixImportExportMigrationAndBulkOperationsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ImportExportMigrationAndBulkOperationsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixImportExportMigrationAndBulkOperationsPresenterModule_.class,
      BrixImportExportMigrationAndBulkOperationsViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface ImportExportMigrationAndBulkOperationsComponent
    extends IsBrixComponent, HasPresenterProvider<ImportExportMigrationAndBulkOperationsPresenterProvider> {

  ComponentProvider<ImportExportMigrationAndBulkOperationsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ImportExportMigrationAndBulkOperationsComponent newInstance() {
          return DaggerImportExportMigrationAndBulkOperationsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
