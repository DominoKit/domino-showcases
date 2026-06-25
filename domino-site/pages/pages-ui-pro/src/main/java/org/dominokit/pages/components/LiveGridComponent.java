package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixLiveGridProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.LiveGridProxy;
import org.dominokit.pages.presenters.samples.datatable.LiveGridProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.livegrid.BrixLiveGridViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = LiveGridProxy.class)
@Component(
    modules = {
        BrixLiveGridProxyModule_.class,
        BrixLiveGridViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LiveGridComponent
    extends IsBrixComponent, HasPresenterProvider<LiveGridProxyProvider> {

  ComponentProvider<LiveGridComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LiveGridComponent newInstance() {
          return DaggerLiveGridComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
