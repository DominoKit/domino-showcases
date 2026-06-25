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
import org.dominokit.demo.samples.presenters.components.BrixTooltipsPopoverPresenterModule_;
import org.dominokit.demo.samples.presenters.components.TooltipsPopoverPresenter;
import org.dominokit.demo.samples.presenters.components.TooltipsPopoverPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.popover.BrixTooltipsPopoverViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TooltipsPopoverPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTooltipsPopoverPresenterModule_.class,
        BrixTooltipsPopoverViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TooltipsPopoverComponent
    extends IsBrixComponent, HasPresenterProvider<TooltipsPopoverPresenterProvider> {

  ComponentProvider<TooltipsPopoverComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TooltipsPopoverComponent newInstance() {
          return DaggerTooltipsPopoverComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
