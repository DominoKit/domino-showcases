package org.dominokit.pages.components;

import org.dominokit.pages.presenters.BrixPagesProxyModule_;
import org.dominokit.pages.presenters.PagesProxy;
import org.dominokit.pages.presenters.PagesProxyProvider;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.pages.ui.views.BrixPagesViewModule_;

@BrixComponent(presenter = PagesProxy.class)
@Component(
    modules = {
        BrixPagesProxyModule_.class,
        BrixPagesViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PagesProxyComponent
    extends IsBrixComponent, HasPresenterProvider<PagesProxyProvider> {

  ComponentProvider<PagesProxyComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PagesProxyComponent newInstance() {
          return DaggerPagesProxyComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
