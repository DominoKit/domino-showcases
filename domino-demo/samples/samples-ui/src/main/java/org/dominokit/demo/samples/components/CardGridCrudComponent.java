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
import org.dominokit.demo.samples.presenters.blueprints.BrixCardGridCrudPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.CardGridCrudPresenter;
import org.dominokit.demo.samples.presenters.blueprints.CardGridCrudPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixCardGridCrudViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CardGridCrudPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCardGridCrudPresenterModule_.class,
        BrixCardGridCrudViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CardGridCrudComponent
    extends IsBrixComponent, HasPresenterProvider<CardGridCrudPresenterProvider> {

  ComponentProvider<CardGridCrudComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CardGridCrudComponent newInstance() {
          return DaggerCardGridCrudComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
