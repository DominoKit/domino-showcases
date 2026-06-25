package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.layouts.BrixResponsiveGridsProxyModule_;
import org.dominokit.pages.presenters.samples.layouts.ResponsiveGridsProxy;
import org.dominokit.pages.presenters.samples.layouts.ResponsiveGridsProxyProvider;
import org.dominokit.pages.ui.views.samples.layouts.grids.BrixResponsiveGridsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ResponsiveGridsProxy.class)
@Component(
    modules = {
        BrixResponsiveGridsProxyModule_.class,
        BrixResponsiveGridsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ResponsiveGridsComponent
    extends IsBrixComponent, HasPresenterProvider<ResponsiveGridsProxyProvider> {

  ComponentProvider<ResponsiveGridsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ResponsiveGridsComponent newInstance() {
          return DaggerResponsiveGridsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
