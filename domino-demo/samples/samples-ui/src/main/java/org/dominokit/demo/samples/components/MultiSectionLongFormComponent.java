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
import org.dominokit.demo.samples.presenters.blueprints.BrixMultiSectionLongFormPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.MultiSectionLongFormPresenter;
import org.dominokit.demo.samples.presenters.blueprints.MultiSectionLongFormPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixMultiSectionLongFormViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MultiSectionLongFormPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMultiSectionLongFormPresenterModule_.class,
        BrixMultiSectionLongFormViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MultiSectionLongFormComponent
    extends IsBrixComponent, HasPresenterProvider<MultiSectionLongFormPresenterProvider> {

  ComponentProvider<MultiSectionLongFormComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MultiSectionLongFormComponent newInstance() {
          return DaggerMultiSectionLongFormComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
