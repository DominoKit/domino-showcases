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
import org.dominokit.demo.samples.presenters.blueprints.BrixImportBackedDataEntryFormPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ImportBackedDataEntryFormPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ImportBackedDataEntryFormPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixImportBackedDataEntryFormViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ImportBackedDataEntryFormPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixImportBackedDataEntryFormPresenterModule_.class,
        BrixImportBackedDataEntryFormViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ImportBackedDataEntryFormComponent
    extends IsBrixComponent, HasPresenterProvider<ImportBackedDataEntryFormPresenterProvider> {

  ComponentProvider<ImportBackedDataEntryFormComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ImportBackedDataEntryFormComponent newInstance() {
          return DaggerImportBackedDataEntryFormComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
