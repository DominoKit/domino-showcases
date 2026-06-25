package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixRadioProxyModule_;
import org.dominokit.pages.presenters.samples.forms.RadioProxy;
import org.dominokit.pages.presenters.samples.forms.RadioProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.input.BrixRadioViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = RadioProxy.class)
@Component(
    modules = {
        BrixRadioProxyModule_.class,
        BrixRadioViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RadioComponent
    extends IsBrixComponent, HasPresenterProvider<RadioProxyProvider> {

  ComponentProvider<RadioComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RadioComponent newInstance() {
          return DaggerRadioComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
