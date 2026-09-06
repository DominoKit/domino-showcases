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
import org.dominokit.demo.samples.presenters.blueprints.BrixListWithRowExpansionPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ListWithRowExpansionPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ListWithRowExpansionPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixListWithRowExpansionViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ListWithRowExpansionPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixListWithRowExpansionPresenterModule_.class,
        BrixListWithRowExpansionViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ListWithRowExpansionComponent
    extends IsBrixComponent, HasPresenterProvider<ListWithRowExpansionPresenterProvider> {

  ComponentProvider<ListWithRowExpansionComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ListWithRowExpansionComponent newInstance() {
          return DaggerListWithRowExpansionComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
