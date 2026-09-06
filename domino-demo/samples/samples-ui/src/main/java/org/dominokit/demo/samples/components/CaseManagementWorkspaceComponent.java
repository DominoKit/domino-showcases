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
import org.dominokit.demo.samples.presenters.blueprints.BrixCaseManagementWorkspacePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.CaseManagementWorkspacePresenter;
import org.dominokit.demo.samples.presenters.blueprints.CaseManagementWorkspacePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement.BrixCaseManagementWorkspaceViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CaseManagementWorkspacePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCaseManagementWorkspacePresenterModule_.class,
        BrixCaseManagementWorkspaceViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CaseManagementWorkspaceComponent
    extends IsBrixComponent, HasPresenterProvider<CaseManagementWorkspacePresenterProvider> {

  ComponentProvider<CaseManagementWorkspaceComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CaseManagementWorkspaceComponent newInstance() {
          return DaggerCaseManagementWorkspaceComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
