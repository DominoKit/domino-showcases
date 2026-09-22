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
import org.dominokit.pages.presenters.samples.helpers.BrixDynamicCssProxyModule_;
import org.dominokit.pages.presenters.samples.helpers.DynamicCssProxy;
import org.dominokit.pages.presenters.samples.helpers.DynamicCssProxyProvider;
import org.dominokit.pages.ui.views.samples.helpers.dynamiccss.BrixDynamicCssViewModule_;

@BrixComponent(presenter = DynamicCssProxy.class)
@Component(
    modules = {
        BrixDynamicCssProxyModule_.class,
        BrixDynamicCssViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DynamicCssComponent extends IsBrixComponent, HasPresenterProvider<DynamicCssProxyProvider> {

  ComponentProvider<DynamicCssComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DynamicCssComponent newInstance() {
          return DaggerDynamicCssComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
