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
import org.dominokit.demo.samples.presenters.blueprints.BrixApprovalMatrixConfigurationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ApprovalMatrixConfigurationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ApprovalMatrixConfigurationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixApprovalMatrixConfigurationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ApprovalMatrixConfigurationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixApprovalMatrixConfigurationPresenterModule_.class,
        BrixApprovalMatrixConfigurationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ApprovalMatrixConfigurationComponent
    extends IsBrixComponent, HasPresenterProvider<ApprovalMatrixConfigurationPresenterProvider> {

  ComponentProvider<ApprovalMatrixConfigurationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ApprovalMatrixConfigurationComponent newInstance() {
          return DaggerApprovalMatrixConfigurationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
