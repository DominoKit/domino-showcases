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
import org.dominokit.demo.samples.presenters.blueprints.BrixApprovalRequestScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ApprovalRequestScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ApprovalRequestScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixApprovalRequestScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ApprovalRequestScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixApprovalRequestScreenPresenterModule_.class,
        BrixApprovalRequestScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ApprovalRequestScreenComponent
    extends IsBrixComponent, HasPresenterProvider<ApprovalRequestScreenPresenterProvider> {

  ComponentProvider<ApprovalRequestScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ApprovalRequestScreenComponent newInstance() {
          return DaggerApprovalRequestScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
