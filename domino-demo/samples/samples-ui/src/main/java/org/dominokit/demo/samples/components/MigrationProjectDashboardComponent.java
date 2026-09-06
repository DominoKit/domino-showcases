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
import org.dominokit.demo.samples.presenters.blueprints.BrixMigrationProjectDashboardPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.MigrationProjectDashboardPresenter;
import org.dominokit.demo.samples.presenters.blueprints.MigrationProjectDashboardPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixMigrationProjectDashboardViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MigrationProjectDashboardPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMigrationProjectDashboardPresenterModule_.class,
        BrixMigrationProjectDashboardViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MigrationProjectDashboardComponent
    extends IsBrixComponent, HasPresenterProvider<MigrationProjectDashboardPresenterProvider> {

  ComponentProvider<MigrationProjectDashboardComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MigrationProjectDashboardComponent newInstance() {
          return DaggerMigrationProjectDashboardComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
