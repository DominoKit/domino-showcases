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
import org.dominokit.demo.samples.presenters.blueprints.BrixIncidentManagementWorkspacePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.IncidentManagementWorkspacePresenter;
import org.dominokit.demo.samples.presenters.blueprints.IncidentManagementWorkspacePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixIncidentManagementWorkspaceViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = IncidentManagementWorkspacePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixIncidentManagementWorkspacePresenterModule_.class,
        BrixIncidentManagementWorkspaceViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface IncidentManagementWorkspaceComponent
    extends IsBrixComponent, HasPresenterProvider<IncidentManagementWorkspacePresenterProvider> {

  ComponentProvider<IncidentManagementWorkspaceComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected IncidentManagementWorkspaceComponent newInstance() {
          return DaggerIncidentManagementWorkspaceComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
