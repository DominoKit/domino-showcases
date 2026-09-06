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
import org.dominokit.demo.samples.presenters.blueprints.BrixOperationalChecklistAndInspectionPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.OperationalChecklistAndInspectionPresenter;
import org.dominokit.demo.samples.presenters.blueprints.OperationalChecklistAndInspectionPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixOperationalChecklistAndInspectionViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = OperationalChecklistAndInspectionPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixOperationalChecklistAndInspectionPresenterModule_.class,
        BrixOperationalChecklistAndInspectionViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface OperationalChecklistAndInspectionComponent
    extends IsBrixComponent, HasPresenterProvider<OperationalChecklistAndInspectionPresenterProvider> {

  ComponentProvider<OperationalChecklistAndInspectionComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected OperationalChecklistAndInspectionComponent newInstance() {
          return DaggerOperationalChecklistAndInspectionComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
