package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixInputMaskProxyModule_;
import org.dominokit.pages.presenters.samples.forms.InputMaskProxy;
import org.dominokit.pages.presenters.samples.forms.InputMaskProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.input.BrixInputMaskViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = InputMaskProxy.class)
@Component(
    modules = {
        BrixInputMaskProxyModule_.class,
        BrixInputMaskViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface InputMaskComponent
    extends IsBrixComponent, HasPresenterProvider<InputMaskProxyProvider> {

  ComponentProvider<InputMaskComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected InputMaskComponent newInstance() {
          return DaggerInputMaskComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
