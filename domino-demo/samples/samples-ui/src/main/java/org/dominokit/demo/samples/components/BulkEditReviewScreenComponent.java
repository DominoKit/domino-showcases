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
import org.dominokit.demo.samples.presenters.blueprints.BrixBulkEditReviewScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.BulkEditReviewScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.BulkEditReviewScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations.BrixBulkEditReviewScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = BulkEditReviewScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixBulkEditReviewScreenPresenterModule_.class,
        BrixBulkEditReviewScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BulkEditReviewScreenComponent
    extends IsBrixComponent, HasPresenterProvider<BulkEditReviewScreenPresenterProvider> {

  ComponentProvider<BulkEditReviewScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected BulkEditReviewScreenComponent newInstance() {
          return DaggerBulkEditReviewScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
