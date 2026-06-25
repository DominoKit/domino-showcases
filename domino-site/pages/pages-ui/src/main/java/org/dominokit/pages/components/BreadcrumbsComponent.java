package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixBreadcrumbsProxyModule_;
import org.dominokit.pages.presenters.samples.components.BreadcrumbsProxy;
import org.dominokit.pages.presenters.samples.components.BreadcrumbsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.breadcrumbs.BrixBreadcrumbsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = BreadcrumbsProxy.class)
@Component(
    modules = {
        BrixBreadcrumbsProxyModule_.class,
        BrixBreadcrumbsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BreadcrumbsComponent
    extends IsBrixComponent, HasPresenterProvider<BreadcrumbsProxyProvider> {

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
