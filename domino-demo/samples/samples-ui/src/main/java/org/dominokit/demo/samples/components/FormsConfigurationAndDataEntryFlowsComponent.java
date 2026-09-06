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
import org.dominokit.demo.samples.presenters.blueprints.BrixFormsConfigurationAndDataEntryFlowsPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.FormsConfigurationAndDataEntryFlowsPresenter;
import org.dominokit.demo.samples.presenters.blueprints.FormsConfigurationAndDataEntryFlowsPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixFormsConfigurationAndDataEntryFlowsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FormsConfigurationAndDataEntryFlowsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixFormsConfigurationAndDataEntryFlowsPresenterModule_.class,
      BrixFormsConfigurationAndDataEntryFlowsViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface FormsConfigurationAndDataEntryFlowsComponent
    extends IsBrixComponent, HasPresenterProvider<FormsConfigurationAndDataEntryFlowsPresenterProvider> {

  ComponentProvider<FormsConfigurationAndDataEntryFlowsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FormsConfigurationAndDataEntryFlowsComponent newInstance() {
          return DaggerFormsConfigurationAndDataEntryFlowsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
