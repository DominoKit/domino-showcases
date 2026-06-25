package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixTimePickerProxyModule_;
import org.dominokit.pages.presenters.samples.forms.TimePickerProxy;
import org.dominokit.pages.presenters.samples.forms.TimePickerProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.timepicker.BrixTimePickerViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TimePickerProxy.class)
@Component(
    modules = {
        BrixTimePickerProxyModule_.class,
        BrixTimePickerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TimePickerComponent
    extends IsBrixComponent, HasPresenterProvider<TimePickerProxyProvider> {

  ComponentProvider<TimePickerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TimePickerComponent newInstance() {
          return DaggerTimePickerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
