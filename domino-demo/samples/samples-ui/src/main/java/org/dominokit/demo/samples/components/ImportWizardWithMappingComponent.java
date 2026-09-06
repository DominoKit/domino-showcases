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
import org.dominokit.demo.samples.presenters.blueprints.BrixImportWizardWithMappingPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ImportWizardWithMappingPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ImportWizardWithMappingPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixImportWizardWithMappingViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ImportWizardWithMappingPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixImportWizardWithMappingPresenterModule_.class,
        BrixImportWizardWithMappingViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ImportWizardWithMappingComponent
    extends IsBrixComponent, HasPresenterProvider<ImportWizardWithMappingPresenterProvider> {

  ComponentProvider<ImportWizardWithMappingComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ImportWizardWithMappingComponent newInstance() {
          return DaggerImportWizardWithMappingComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
