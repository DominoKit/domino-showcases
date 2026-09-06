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
import org.dominokit.demo.samples.presenters.blueprints.BrixWorkflowApprovalsAndTaskManagementPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.WorkflowApprovalsAndTaskManagementPresenter;
import org.dominokit.demo.samples.presenters.blueprints.WorkflowApprovalsAndTaskManagementPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixWorkflowApprovalsAndTaskManagementViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = WorkflowApprovalsAndTaskManagementPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixWorkflowApprovalsAndTaskManagementPresenterModule_.class,
      BrixWorkflowApprovalsAndTaskManagementViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface WorkflowApprovalsAndTaskManagementComponent
    extends IsBrixComponent, HasPresenterProvider<WorkflowApprovalsAndTaskManagementPresenterProvider> {

  ComponentProvider<WorkflowApprovalsAndTaskManagementComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected WorkflowApprovalsAndTaskManagementComponent newInstance() {
          return DaggerWorkflowApprovalsAndTaskManagementComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
