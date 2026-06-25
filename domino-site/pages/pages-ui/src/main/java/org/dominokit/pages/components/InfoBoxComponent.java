package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixInfoBoxProxyModule_;
import org.dominokit.pages.presenters.samples.components.InfoBoxProxy;
import org.dominokit.pages.presenters.samples.components.InfoBoxProxyProvider;
import org.dominokit.pages.ui.views.samples.components.infobox.BrixInfoBoxViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = InfoBoxProxy.class)
@Component(
    modules = {
        BrixInfoBoxProxyModule_.class,
        BrixInfoBoxViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface InfoBoxComponent
    extends IsBrixComponent, HasPresenterProvider<InfoBoxProxyProvider> {

  ComponentProvider<InfoBoxComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected InfoBoxComponent newInstance() {
          return DaggerInfoBoxComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
