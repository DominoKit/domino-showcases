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
import org.dominokit.demo.samples.presenters.components.BrixCollapsiblePresenterModule_;
import org.dominokit.demo.samples.presenters.components.CollapsiblePresenter;
import org.dominokit.demo.samples.presenters.components.CollapsiblePresenterProvider;
import org.dominokit.demo.samples.ui.views.components.collapsible.BrixCollapsibleViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CollapsiblePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCollapsiblePresenterModule_.class,
        BrixCollapsibleViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CollapsibleComponent
    extends IsBrixComponent, HasPresenterProvider<CollapsiblePresenterProvider> {

  ComponentProvider<CollapsibleComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CollapsibleComponent newInstance() {
          return DaggerCollapsibleComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
