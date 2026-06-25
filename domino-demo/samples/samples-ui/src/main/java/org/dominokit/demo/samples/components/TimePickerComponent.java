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
import org.dominokit.demo.samples.presenters.forms.BrixTimePickerPresenterModule_;
import org.dominokit.demo.samples.presenters.forms.TimePickerPresenter;
import org.dominokit.demo.samples.presenters.forms.TimePickerPresenterProvider;
import org.dominokit.demo.samples.ui.views.forms.timepicker.BrixTimePickerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TimePickerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTimePickerPresenterModule_.class,
        BrixTimePickerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TimePickerComponent
    extends IsBrixComponent, HasPresenterProvider<TimePickerPresenterProvider> {

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
