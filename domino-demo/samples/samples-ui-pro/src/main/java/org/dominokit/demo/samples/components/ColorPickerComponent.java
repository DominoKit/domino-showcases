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
import org.dominokit.demo.samples.presenters.components.BrixColorPickerPresenterModule_;
import org.dominokit.demo.samples.presenters.components.ColorPickerPresenter;
import org.dominokit.demo.samples.presenters.components.ColorPickerPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.colorpicker.BrixColorPickerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ColorPickerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixColorPickerPresenterModule_.class,
        BrixColorPickerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColorPickerComponent
    extends IsBrixComponent, HasPresenterProvider<ColorPickerPresenterProvider> {

  ComponentProvider<ColorPickerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColorPickerComponent newInstance() {
          return DaggerColorPickerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
