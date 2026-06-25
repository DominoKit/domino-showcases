package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixMediaObjectsProxyModule_;
import org.dominokit.pages.presenters.samples.components.MediaObjectsProxy;
import org.dominokit.pages.presenters.samples.components.MediaObjectsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.media.BrixMediaObjectsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = MediaObjectsProxy.class)
@Component(
    modules = {
        BrixMediaObjectsProxyModule_.class,
        BrixMediaObjectsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MediaObjectsComponent
    extends IsBrixComponent, HasPresenterProvider<MediaObjectsProxyProvider> {

  ComponentProvider<MediaObjectsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MediaObjectsComponent newInstance() {
          return DaggerMediaObjectsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
