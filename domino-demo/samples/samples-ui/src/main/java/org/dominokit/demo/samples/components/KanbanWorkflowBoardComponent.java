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
import org.dominokit.demo.samples.presenters.blueprints.BrixKanbanWorkflowBoardPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.KanbanWorkflowBoardPresenter;
import org.dominokit.demo.samples.presenters.blueprints.KanbanWorkflowBoardPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixKanbanWorkflowBoardViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = KanbanWorkflowBoardPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixKanbanWorkflowBoardPresenterModule_.class,
        BrixKanbanWorkflowBoardViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface KanbanWorkflowBoardComponent
    extends IsBrixComponent, HasPresenterProvider<KanbanWorkflowBoardPresenterProvider> {

  ComponentProvider<KanbanWorkflowBoardComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected KanbanWorkflowBoardComponent newInstance() {
          return DaggerKanbanWorkflowBoardComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
