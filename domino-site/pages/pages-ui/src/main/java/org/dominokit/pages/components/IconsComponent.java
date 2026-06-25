package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.icons.BrixIconsProxyModule_;
import org.dominokit.pages.presenters.samples.icons.IconsProxy;
import org.dominokit.pages.presenters.samples.icons.IconsProxyProvider;
import org.dominokit.pages.ui.views.samples.icons.BrixIconsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = IconsProxy.class)
@Component(
    modules = {
        BrixIconsProxyModule_.class,
        BrixIconsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface IconsComponent
    extends IsBrixComponent, HasPresenterProvider<IconsProxyProvider> {

  ComponentProvider<IconsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected IconsComponent newInstance() {
          return DaggerIconsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
