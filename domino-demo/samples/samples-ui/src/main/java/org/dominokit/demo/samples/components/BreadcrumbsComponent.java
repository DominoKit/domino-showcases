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
import org.dominokit.demo.samples.presenters.components.BrixBreadcrumbsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.BreadcrumbsPresenter;
import org.dominokit.demo.samples.presenters.components.BreadcrumbsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.breadcrumbs.BrixBreadcrumbsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = BreadcrumbsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixBreadcrumbsPresenterModule_.class,
        BrixBreadcrumbsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BreadcrumbsComponent
    extends IsBrixComponent, HasPresenterProvider<BreadcrumbsPresenterProvider> {

  ComponentProvider<BreadcrumbsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected BreadcrumbsComponent newInstance() {
          return DaggerBreadcrumbsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
