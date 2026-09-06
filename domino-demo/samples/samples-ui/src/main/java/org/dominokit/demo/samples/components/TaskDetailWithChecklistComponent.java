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
import org.dominokit.demo.samples.presenters.blueprints.BrixTaskDetailWithChecklistPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.TaskDetailWithChecklistPresenter;
import org.dominokit.demo.samples.presenters.blueprints.TaskDetailWithChecklistPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixTaskDetailWithChecklistViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TaskDetailWithChecklistPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTaskDetailWithChecklistPresenterModule_.class,
        BrixTaskDetailWithChecklistViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TaskDetailWithChecklistComponent
    extends IsBrixComponent, HasPresenterProvider<TaskDetailWithChecklistPresenterProvider> {

  ComponentProvider<TaskDetailWithChecklistComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TaskDetailWithChecklistComponent newInstance() {
          return DaggerTaskDetailWithChecklistComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
