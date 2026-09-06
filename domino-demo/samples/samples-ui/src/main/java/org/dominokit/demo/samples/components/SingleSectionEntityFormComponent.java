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
import org.dominokit.demo.samples.presenters.blueprints.BrixSingleSectionEntityFormPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SingleSectionEntityFormPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SingleSectionEntityFormPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixSingleSectionEntityFormViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SingleSectionEntityFormPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSingleSectionEntityFormPresenterModule_.class,
        BrixSingleSectionEntityFormViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SingleSectionEntityFormComponent
    extends IsBrixComponent, HasPresenterProvider<SingleSectionEntityFormPresenterProvider> {

  ComponentProvider<SingleSectionEntityFormComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SingleSectionEntityFormComponent newInstance() {
          return DaggerSingleSectionEntityFormComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
