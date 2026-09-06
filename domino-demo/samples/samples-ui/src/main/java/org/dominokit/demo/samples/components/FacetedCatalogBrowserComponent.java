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
import org.dominokit.demo.samples.presenters.blueprints.BrixFacetedCatalogBrowserPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.FacetedCatalogBrowserPresenter;
import org.dominokit.demo.samples.presenters.blueprints.FacetedCatalogBrowserPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixFacetedCatalogBrowserViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FacetedCatalogBrowserPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFacetedCatalogBrowserPresenterModule_.class,
        BrixFacetedCatalogBrowserViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FacetedCatalogBrowserComponent
    extends IsBrixComponent, HasPresenterProvider<FacetedCatalogBrowserPresenterProvider> {

  ComponentProvider<FacetedCatalogBrowserComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FacetedCatalogBrowserComponent newInstance() {
          return DaggerFacetedCatalogBrowserComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
