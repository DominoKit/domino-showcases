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
import org.dominokit.demo.samples.presenters.blueprints.BrixRepeatableCollectionFormPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.RepeatableCollectionFormPresenter;
import org.dominokit.demo.samples.presenters.blueprints.RepeatableCollectionFormPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixRepeatableCollectionFormViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RepeatableCollectionFormPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRepeatableCollectionFormPresenterModule_.class,
        BrixRepeatableCollectionFormViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RepeatableCollectionFormComponent
    extends IsBrixComponent, HasPresenterProvider<RepeatableCollectionFormPresenterProvider> {

  ComponentProvider<RepeatableCollectionFormComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RepeatableCollectionFormComponent newInstance() {
          return DaggerRepeatableCollectionFormComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
