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
import org.dominokit.demo.samples.presenters.components.BrixButtonsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.ButtonsPresenter;
import org.dominokit.demo.samples.presenters.components.ButtonsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.buttons.BrixButtonsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ButtonsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixButtonsPresenterModule_.class,
        BrixButtonsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ButtonsComponent
    extends IsBrixComponent, HasPresenterProvider<ButtonsPresenterProvider> {

  ComponentProvider<ButtonsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ButtonsComponent newInstance() {
          return DaggerButtonsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
