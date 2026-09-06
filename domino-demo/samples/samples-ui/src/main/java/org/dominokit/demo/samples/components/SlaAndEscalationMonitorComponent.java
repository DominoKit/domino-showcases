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
import org.dominokit.demo.samples.presenters.blueprints.BrixSlaAndEscalationMonitorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SlaAndEscalationMonitorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SlaAndEscalationMonitorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixSlaAndEscalationMonitorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SlaAndEscalationMonitorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSlaAndEscalationMonitorPresenterModule_.class,
        BrixSlaAndEscalationMonitorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SlaAndEscalationMonitorComponent
    extends IsBrixComponent, HasPresenterProvider<SlaAndEscalationMonitorPresenterProvider> {

  ComponentProvider<SlaAndEscalationMonitorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SlaAndEscalationMonitorComponent newInstance() {
          return DaggerSlaAndEscalationMonitorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
