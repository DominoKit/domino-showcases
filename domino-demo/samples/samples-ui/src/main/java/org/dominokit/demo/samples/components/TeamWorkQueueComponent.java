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
import org.dominokit.demo.samples.presenters.blueprints.BrixTeamWorkQueuePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.TeamWorkQueuePresenter;
import org.dominokit.demo.samples.presenters.blueprints.TeamWorkQueuePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixTeamWorkQueueViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TeamWorkQueuePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTeamWorkQueuePresenterModule_.class,
        BrixTeamWorkQueueViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TeamWorkQueueComponent
    extends IsBrixComponent, HasPresenterProvider<TeamWorkQueuePresenterProvider> {

  ComponentProvider<TeamWorkQueueComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TeamWorkQueueComponent newInstance() {
          return DaggerTeamWorkQueueComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
