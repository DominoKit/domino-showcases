package org.dominokit.pages.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.pages.presenters.samples.BrixThemingProxyModule_;
import org.dominokit.pages.presenters.samples.ThemingProxy;
import org.dominokit.pages.presenters.samples.ThemingProxyProvider;
import org.dominokit.pages.ui.views.samples.theming.BrixThemingViewModule_;

@BrixComponent(presenter = ThemingProxy.class)
@Component(
    modules = {
        BrixThemingProxyModule_.class,
        BrixThemingViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ThemingComponent extends IsBrixComponent, HasPresenterProvider<ThemingProxyProvider> {

  ComponentProvider<ThemingComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ThemingComponent newInstance() {
          return DaggerThemingComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
