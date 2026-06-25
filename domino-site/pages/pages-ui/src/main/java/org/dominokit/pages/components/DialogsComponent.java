package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixDialogsProxyModule_;
import org.dominokit.pages.presenters.samples.components.DialogsProxy;
import org.dominokit.pages.presenters.samples.components.DialogsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.dialogs.BrixDialogsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = DialogsProxy.class)
@Component(
    modules = {
        BrixDialogsProxyModule_.class,
        BrixDialogsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DialogsComponent
    extends IsBrixComponent, HasPresenterProvider<DialogsProxyProvider> {

  ComponentProvider<DialogsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DialogsComponent newInstance() {
          return DaggerDialogsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
