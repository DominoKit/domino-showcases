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
import org.dominokit.demo.samples.presenters.components.BrixCardsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.CardsPresenter;
import org.dominokit.demo.samples.presenters.components.CardsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.cards.BrixCardsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CardsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCardsPresenterModule_.class,
        BrixCardsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CardsComponent
    extends IsBrixComponent, HasPresenterProvider<CardsPresenterProvider> {

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
