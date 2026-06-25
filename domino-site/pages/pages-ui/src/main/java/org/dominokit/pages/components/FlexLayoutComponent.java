package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.layouts.BrixFlexLayoutProxyModule_;
import org.dominokit.pages.presenters.samples.layouts.FlexLayoutProxy;
import org.dominokit.pages.presenters.samples.layouts.FlexLayoutProxyProvider;
import org.dominokit.pages.ui.views.samples.layouts.flex.BrixFlexLayoutViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = FlexLayoutProxy.class)
@Component(
    modules = {
        BrixFlexLayoutProxyModule_.class,
        BrixFlexLayoutViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FlexLayoutComponent
    extends IsBrixComponent, HasPresenterProvider<FlexLayoutProxyProvider> {

  ComponentProvider<FlexLayoutComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FlexLayoutComponent newInstance() {
          return DaggerFlexLayoutComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
