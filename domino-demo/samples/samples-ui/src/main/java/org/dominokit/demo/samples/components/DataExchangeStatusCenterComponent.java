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
import org.dominokit.demo.samples.presenters.blueprints.BrixDataExchangeStatusCenterPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.DataExchangeStatusCenterPresenter;
import org.dominokit.demo.samples.presenters.blueprints.DataExchangeStatusCenterPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixDataExchangeStatusCenterViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DataExchangeStatusCenterPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDataExchangeStatusCenterPresenterModule_.class,
        BrixDataExchangeStatusCenterViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DataExchangeStatusCenterComponent
    extends IsBrixComponent, HasPresenterProvider<DataExchangeStatusCenterPresenterProvider> {

  ComponentProvider<DataExchangeStatusCenterComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DataExchangeStatusCenterComponent newInstance() {
          return DaggerDataExchangeStatusCenterComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
