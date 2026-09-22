package org.dominokit.pages.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.pages.presenters.samples.components.BrixPageHeaderProxyModule_;
import org.dominokit.pages.presenters.samples.components.PageHeaderProxy;
import org.dominokit.pages.presenters.samples.components.PageHeaderProxyProvider;
import org.dominokit.pages.ui.views.samples.components.pageheader.BrixPageHeaderViewModule_;

@BrixComponent(presenter = PageHeaderProxy.class)
@Component(
    modules = {
        BrixPageHeaderProxyModule_.class,
        BrixPageHeaderViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PageHeaderComponent
    extends IsBrixComponent, HasPresenterProvider<PageHeaderProxyProvider> {

  ComponentProvider<PageHeaderComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PageHeaderComponent newInstance() {
          return DaggerPageHeaderComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
