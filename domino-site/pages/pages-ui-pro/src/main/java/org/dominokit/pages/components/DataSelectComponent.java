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
import org.dominokit.pages.presenters.samples.data.BrixDataSelectProxyModule_;
import org.dominokit.pages.presenters.samples.data.DataSelectProxy;
import org.dominokit.pages.presenters.samples.data.DataSelectProxyProvider;
import org.dominokit.pages.ui.views.samples.data.BrixDataSelectViewModule_;

@BrixComponent(presenter = DataSelectProxy.class)
@Component(
    modules = {
        BrixDataSelectProxyModule_.class,
        BrixDataSelectViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DataSelectComponent
    extends IsBrixComponent, HasPresenterProvider<DataSelectProxyProvider> {

  ComponentProvider<DataSelectComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DataSelectComponent newInstance() {
          return DaggerDataSelectComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
