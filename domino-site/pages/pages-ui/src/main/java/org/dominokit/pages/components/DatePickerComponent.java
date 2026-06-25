package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixDatePickerProxyModule_;
import org.dominokit.pages.presenters.samples.forms.DatePickerProxy;
import org.dominokit.pages.presenters.samples.forms.DatePickerProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.datepicker.BrixDatePickerViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = DatePickerProxy.class)
@Component(
    modules = {
        BrixDatePickerProxyModule_.class,
        BrixDatePickerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DatePickerComponent
    extends IsBrixComponent, HasPresenterProvider<DatePickerProxyProvider> {

  ComponentProvider<DatePickerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DatePickerComponent newInstance() {
          return DaggerDatePickerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
