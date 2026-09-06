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
import org.dominokit.demo.samples.presenters.blueprints.BrixSearchListAndCrudScreensPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SearchListAndCrudScreensPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SearchListAndCrudScreensPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixSearchListAndCrudScreensViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SearchListAndCrudScreensPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixSearchListAndCrudScreensPresenterModule_.class,
      BrixSearchListAndCrudScreensViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface SearchListAndCrudScreensComponent
    extends IsBrixComponent, HasPresenterProvider<SearchListAndCrudScreensPresenterProvider> {

  ComponentProvider<SearchListAndCrudScreensComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SearchListAndCrudScreensComponent newInstance() {
          return DaggerSearchListAndCrudScreensComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
