package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.layouts.BrixAppLayoutProxyModule_;
import org.dominokit.pages.presenters.samples.layouts.AppLayoutProxy;
import org.dominokit.pages.presenters.samples.layouts.AppLayoutProxyProvider;
import org.dominokit.pages.ui.views.samples.layouts.applayout.BrixAppLayoutViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = AppLayoutProxy.class)
@Component(
    modules = {
        BrixAppLayoutProxyModule_.class,
        BrixAppLayoutViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AppLayoutComponent
    extends IsBrixComponent, HasPresenterProvider<AppLayoutProxyProvider> {

  ComponentProvider<AppLayoutComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AppLayoutComponent newInstance() {
          return DaggerAppLayoutComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
