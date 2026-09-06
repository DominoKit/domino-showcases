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
import org.dominokit.demo.samples.presenters.blueprints.BrixPersonalTaskInboxPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.PersonalTaskInboxPresenter;
import org.dominokit.demo.samples.presenters.blueprints.PersonalTaskInboxPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixPersonalTaskInboxViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = PersonalTaskInboxPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixPersonalTaskInboxPresenterModule_.class,
        BrixPersonalTaskInboxViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PersonalTaskInboxComponent
    extends IsBrixComponent, HasPresenterProvider<PersonalTaskInboxPresenterProvider> {

  ComponentProvider<PersonalTaskInboxComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PersonalTaskInboxComponent newInstance() {
          return DaggerPersonalTaskInboxComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
