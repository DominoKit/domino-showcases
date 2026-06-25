package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixScrollLoadingProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.ScrollLoadingProxy;
import org.dominokit.pages.presenters.samples.datatable.ScrollLoadingProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.scroll.BrixScrollLoadingViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ScrollLoadingProxy.class)
@Component(
    modules = {
        BrixScrollLoadingProxyModule_.class,
        BrixScrollLoadingViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ScrollLoadingComponent
    extends IsBrixComponent, HasPresenterProvider<ScrollLoadingProxyProvider> {

  ComponentProvider<ScrollLoadingComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ScrollLoadingComponent newInstance() {
          return DaggerScrollLoadingComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
