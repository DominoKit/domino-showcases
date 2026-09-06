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
import org.dominokit.demo.samples.presenters.blueprints.BrixImportValidationAndCorrectionQueuePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ImportValidationAndCorrectionQueuePresenter;
import org.dominokit.demo.samples.presenters.blueprints.ImportValidationAndCorrectionQueuePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixImportValidationAndCorrectionQueueViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ImportValidationAndCorrectionQueuePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixImportValidationAndCorrectionQueuePresenterModule_.class,
        BrixImportValidationAndCorrectionQueueViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ImportValidationAndCorrectionQueueComponent
    extends IsBrixComponent, HasPresenterProvider<ImportValidationAndCorrectionQueuePresenterProvider> {

  ComponentProvider<ImportValidationAndCorrectionQueueComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ImportValidationAndCorrectionQueueComponent newInstance() {
          return DaggerImportValidationAndCorrectionQueueComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
