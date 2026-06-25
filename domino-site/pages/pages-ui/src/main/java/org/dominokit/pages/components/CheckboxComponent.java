package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixCheckboxProxyModule_;
import org.dominokit.pages.presenters.samples.forms.CheckboxProxy;
import org.dominokit.pages.presenters.samples.forms.CheckboxProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.input.BrixCheckBoxViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = CheckboxProxy.class)
@Component(
    modules = {
        BrixCheckboxProxyModule_.class,
        BrixCheckBoxViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CheckboxComponent
    extends IsBrixComponent, HasPresenterProvider<CheckboxProxyProvider> {

  ComponentProvider<CheckboxComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CheckboxComponent newInstance() {
          return DaggerCheckboxComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
