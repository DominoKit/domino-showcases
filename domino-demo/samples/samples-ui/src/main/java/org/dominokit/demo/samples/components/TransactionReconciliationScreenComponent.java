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
import org.dominokit.demo.samples.presenters.blueprints.BrixTransactionReconciliationScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.TransactionReconciliationScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.TransactionReconciliationScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixTransactionReconciliationScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TransactionReconciliationScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTransactionReconciliationScreenPresenterModule_.class,
        BrixTransactionReconciliationScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TransactionReconciliationScreenComponent
    extends IsBrixComponent, HasPresenterProvider<TransactionReconciliationScreenPresenterProvider> {

  ComponentProvider<TransactionReconciliationScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TransactionReconciliationScreenComponent newInstance() {
          return DaggerTransactionReconciliationScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
