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
import org.dominokit.demo.samples.presenters.blueprints.BrixListWithSavedFiltersAndViewsPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ListWithSavedFiltersAndViewsPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ListWithSavedFiltersAndViewsPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixListWithSavedFiltersAndViewsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ListWithSavedFiltersAndViewsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixListWithSavedFiltersAndViewsPresenterModule_.class,
        BrixListWithSavedFiltersAndViewsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ListWithSavedFiltersAndViewsComponent
    extends IsBrixComponent, HasPresenterProvider<ListWithSavedFiltersAndViewsPresenterProvider> {

  ComponentProvider<ListWithSavedFiltersAndViewsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ListWithSavedFiltersAndViewsComponent newInstance() {
          return DaggerListWithSavedFiltersAndViewsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
