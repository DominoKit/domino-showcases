package org.dominokit.pages.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.pages.presenters.samples.data.BrixDataListProxyModule_;
import org.dominokit.pages.presenters.samples.data.DataListProxy;
import org.dominokit.pages.presenters.samples.data.DataListProxyProvider;
import org.dominokit.pages.ui.views.samples.data.BrixDataListViewModule_;

@BrixComponent(presenter = DataListProxy.class)
@Component(
    modules = {
        BrixDataListProxyModule_.class,
        BrixDataListViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DataListComponent extends IsBrixComponent, HasPresenterProvider<DataListProxyProvider> {

  ComponentProvider<DataListComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DataListComponent newInstance() {
          return DaggerDataListComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
