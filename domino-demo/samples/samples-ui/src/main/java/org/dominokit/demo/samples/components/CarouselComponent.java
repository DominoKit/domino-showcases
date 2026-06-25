package org.dominokit.demo.samples.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.demo.samples.presenters.components.BrixCarouselPresenterModule_;
import org.dominokit.demo.samples.presenters.components.CarouselPresenter;
import org.dominokit.demo.samples.presenters.components.CarouselPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.carousel.BrixCarouselViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CarouselPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCarouselPresenterModule_.class,
        BrixCarouselViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CarouselComponent
    extends IsBrixComponent, HasPresenterProvider<CarouselPresenterProvider> {

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
