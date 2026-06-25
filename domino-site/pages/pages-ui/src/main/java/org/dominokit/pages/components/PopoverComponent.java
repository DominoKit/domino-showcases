package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixPopoverProxyModule_;
import org.dominokit.pages.presenters.samples.components.PopoverProxy;
import org.dominokit.pages.presenters.samples.components.PopoverProxyProvider;
import org.dominokit.pages.ui.views.samples.components.popover.BrixPopoverViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = PopoverProxy.class)
@Component(
    modules = {
        BrixPopoverProxyModule_.class,
        BrixPopoverViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PopoverComponent
    extends IsBrixComponent, HasPresenterProvider<PopoverProxyProvider> {

  ComponentProvider<PopoverComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PopoverComponent newInstance() {
          return DaggerPopoverComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
