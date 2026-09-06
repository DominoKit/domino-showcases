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
import org.dominokit.demo.samples.presenters.blueprints.BrixFormWithConditionalFieldsPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.FormWithConditionalFieldsPresenter;
import org.dominokit.demo.samples.presenters.blueprints.FormWithConditionalFieldsPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixFormWithConditionalFieldsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FormWithConditionalFieldsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFormWithConditionalFieldsPresenterModule_.class,
        BrixFormWithConditionalFieldsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FormWithConditionalFieldsComponent
    extends IsBrixComponent, HasPresenterProvider<FormWithConditionalFieldsPresenterProvider> {

  ComponentProvider<FormWithConditionalFieldsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FormWithConditionalFieldsComponent newInstance() {
          return DaggerFormWithConditionalFieldsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
