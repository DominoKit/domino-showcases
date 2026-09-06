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
import org.dominokit.demo.samples.presenters.blueprints.BrixExportBuilderPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ExportBuilderPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ExportBuilderPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixExportBuilderViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ExportBuilderPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixExportBuilderPresenterModule_.class,
        BrixExportBuilderViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ExportBuilderComponent
    extends IsBrixComponent, HasPresenterProvider<ExportBuilderPresenterProvider> {

  ComponentProvider<ExportBuilderComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ExportBuilderComponent newInstance() {
          return DaggerExportBuilderComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
