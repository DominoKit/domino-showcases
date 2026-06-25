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
import org.dominokit.demo.samples.presenters.forms.BrixInputMaskPresenterModule_;
import org.dominokit.demo.samples.presenters.forms.InputMaskPresenter;
import org.dominokit.demo.samples.presenters.forms.InputMaskPresenterProvider;
import org.dominokit.demo.samples.ui.views.forms.input.BrixInputMaskViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = InputMaskPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixInputMaskPresenterModule_.class,
        BrixInputMaskViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface InputMaskComponent
    extends IsBrixComponent, HasPresenterProvider<InputMaskPresenterProvider> {

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
