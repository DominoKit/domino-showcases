package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixCollapsibleProxyModule_;
import org.dominokit.pages.presenters.samples.components.CollapsibleProxy;
import org.dominokit.pages.presenters.samples.components.CollapsibleProxyProvider;
import org.dominokit.pages.ui.views.samples.components.collapsible.BrixCollapsibleViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = CollapsibleProxy.class)
@Component(
    modules = {
        BrixCollapsibleProxyModule_.class,
        BrixCollapsibleViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CollapsibleComponent
    extends IsBrixComponent, HasPresenterProvider<CollapsibleProxyProvider> {

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
