package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.layouts.BrixGridLayoutProxyModule_;
import org.dominokit.pages.presenters.samples.layouts.GridLayoutProxy;
import org.dominokit.pages.presenters.samples.layouts.GridLayoutProxyProvider;
import org.dominokit.pages.ui.views.samples.layouts.gridlayout.BrixGridLayoutViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = GridLayoutProxy.class)
@Component(
    modules = {
        BrixGridLayoutProxyModule_.class,
        BrixGridLayoutViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface GridLayoutComponent
    extends IsBrixComponent, HasPresenterProvider<GridLayoutProxyProvider> {

  ComponentProvider<GridLayoutComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected GridLayoutComponent newInstance() {
          return DaggerGridLayoutComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
