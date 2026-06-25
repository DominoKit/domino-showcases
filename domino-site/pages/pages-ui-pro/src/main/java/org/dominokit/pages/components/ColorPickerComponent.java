package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixColorPickerProxyModule_;
import org.dominokit.pages.presenters.samples.components.ColorPickerProxy;
import org.dominokit.pages.presenters.samples.components.ColorPickerProxyProvider;
import org.dominokit.pages.ui.views.samples.components.colorpicker.BrixColorPickerViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ColorPickerProxy.class)
@Component(
    modules = {
        BrixColorPickerProxyModule_.class,
        BrixColorPickerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColorPickerComponent
    extends IsBrixComponent, HasPresenterProvider<ColorPickerProxyProvider> {

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
