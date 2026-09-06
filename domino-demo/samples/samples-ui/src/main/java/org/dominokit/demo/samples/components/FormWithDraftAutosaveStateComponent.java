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
import org.dominokit.demo.samples.presenters.blueprints.BrixFormWithDraftAutosaveStatePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.FormWithDraftAutosaveStatePresenter;
import org.dominokit.demo.samples.presenters.blueprints.FormWithDraftAutosaveStatePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixFormWithDraftAutosaveStateViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FormWithDraftAutosaveStatePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFormWithDraftAutosaveStatePresenterModule_.class,
        BrixFormWithDraftAutosaveStateViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FormWithDraftAutosaveStateComponent
    extends IsBrixComponent, HasPresenterProvider<FormWithDraftAutosaveStatePresenterProvider> {

  ComponentProvider<FormWithDraftAutosaveStateComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FormWithDraftAutosaveStateComponent newInstance() {
          return DaggerFormWithDraftAutosaveStateComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
