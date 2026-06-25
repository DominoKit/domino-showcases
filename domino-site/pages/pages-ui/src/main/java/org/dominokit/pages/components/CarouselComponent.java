package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixCarouselProxyModule_;
import org.dominokit.pages.presenters.samples.components.CarouselProxy;
import org.dominokit.pages.presenters.samples.components.CarouselProxyProvider;
import org.dominokit.pages.ui.views.samples.components.carousel.BrixCarouselViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = CarouselProxy.class)
@Component(
    modules = {
        BrixCarouselProxyModule_.class,
        BrixCarouselViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CarouselComponent
    extends IsBrixComponent, HasPresenterProvider<CarouselProxyProvider> {

  ComponentProvider<CarouselComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CarouselComponent newInstance() {
          return DaggerCarouselComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
