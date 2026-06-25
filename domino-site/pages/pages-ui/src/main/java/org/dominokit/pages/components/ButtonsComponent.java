package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixButtonsProxyModule_;
import org.dominokit.pages.presenters.samples.components.ButtonsProxy;
import org.dominokit.pages.presenters.samples.components.ButtonsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.buttons.BrixButtonsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ButtonsProxy.class)
@Component(
    modules = {
        BrixButtonsProxyModule_.class,
        BrixButtonsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ButtonsComponent
    extends IsBrixComponent, HasPresenterProvider<ButtonsProxyProvider> {

  ComponentProvider<ButtonsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ButtonsComponent newInstance() {
          return DaggerButtonsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
