package org.dominokit.demo.samples.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.demo.samples.presenters.forms.BrixDatePickerPresenterModule_;
import org.dominokit.demo.samples.presenters.forms.DatePickerPresenter;
import org.dominokit.demo.samples.presenters.forms.DatePickerPresenterProvider;
import org.dominokit.demo.samples.ui.views.forms.datepicker.BrixDatePickerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DatePickerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDatePickerPresenterModule_.class,
        BrixDatePickerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DatePickerComponent
    extends IsBrixComponent, HasPresenterProvider<DatePickerPresenterProvider> {

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
