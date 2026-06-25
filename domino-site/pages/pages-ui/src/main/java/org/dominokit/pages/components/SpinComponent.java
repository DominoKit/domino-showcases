package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixSpinProxyModule_;
import org.dominokit.pages.presenters.samples.components.SpinProxy;
import org.dominokit.pages.presenters.samples.components.SpinProxyProvider;
import org.dominokit.pages.ui.views.samples.components.spin.BrixSpinViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = SpinProxy.class)
@Component(
    modules = {
        BrixSpinProxyModule_.class,
        BrixSpinViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SpinComponent
    extends IsBrixComponent, HasPresenterProvider<SpinProxyProvider> {

  ComponentProvider<SpinComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SpinComponent newInstance() {
          return DaggerSpinComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
