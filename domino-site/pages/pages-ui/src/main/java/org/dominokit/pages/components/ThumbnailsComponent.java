package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixThumbnailsProxyModule_;
import org.dominokit.pages.presenters.samples.components.ThumbnailsProxy;
import org.dominokit.pages.presenters.samples.components.ThumbnailsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.thumbnails.BrixThumbnailsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ThumbnailsProxy.class)
@Component(
    modules = {
        BrixThumbnailsProxyModule_.class,
        BrixThumbnailsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ThumbnailsComponent
    extends IsBrixComponent, HasPresenterProvider<ThumbnailsProxyProvider> {

  ComponentProvider<ThumbnailsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ThumbnailsComponent newInstance() {
          return DaggerThumbnailsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
