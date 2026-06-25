package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixCardsProxyModule_;
import org.dominokit.pages.presenters.samples.components.CardsProxy;
import org.dominokit.pages.presenters.samples.components.CardsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.cards.BrixCardsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = CardsProxy.class)
@Component(
    modules = {
        BrixCardsProxyModule_.class,
        BrixCardsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CardsComponent
    extends IsBrixComponent, HasPresenterProvider<CardsProxyProvider> {

  ComponentProvider<CardsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CardsComponent newInstance() {
          return DaggerCardsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
