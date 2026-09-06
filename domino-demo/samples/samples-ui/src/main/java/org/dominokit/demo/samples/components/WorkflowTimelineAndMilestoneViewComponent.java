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
import org.dominokit.demo.samples.presenters.blueprints.BrixWorkflowTimelineAndMilestoneViewPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.WorkflowTimelineAndMilestoneViewPresenter;
import org.dominokit.demo.samples.presenters.blueprints.WorkflowTimelineAndMilestoneViewPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixWorkflowTimelineAndMilestoneViewViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = WorkflowTimelineAndMilestoneViewPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixWorkflowTimelineAndMilestoneViewPresenterModule_.class,
        BrixWorkflowTimelineAndMilestoneViewViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface WorkflowTimelineAndMilestoneViewComponent
    extends IsBrixComponent, HasPresenterProvider<WorkflowTimelineAndMilestoneViewPresenterProvider> {

  ComponentProvider<WorkflowTimelineAndMilestoneViewComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected WorkflowTimelineAndMilestoneViewComponent newInstance() {
          return DaggerWorkflowTimelineAndMilestoneViewComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
