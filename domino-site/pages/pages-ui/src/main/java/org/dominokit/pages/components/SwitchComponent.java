package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixSwitchProxyModule_;
import org.dominokit.pages.presenters.samples.forms.SwitchProxy;
import org.dominokit.pages.presenters.samples.forms.SwitchProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.input.BrixSwitchViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = SwitchProxy.class)
@Component(
    modules = {
        BrixSwitchProxyModule_.class,
        BrixSwitchViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SwitchComponent
    extends IsBrixComponent, HasPresenterProvider<SwitchProxyProvider> {

  ComponentProvider<SwitchComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SwitchComponent newInstance() {
          return DaggerSwitchComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
