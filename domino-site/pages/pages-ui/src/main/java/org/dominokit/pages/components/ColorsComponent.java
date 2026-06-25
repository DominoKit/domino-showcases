package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.colors.BrixColorsProxyModule_;
import org.dominokit.pages.presenters.samples.colors.ColorsProxy;
import org.dominokit.pages.presenters.samples.colors.ColorsProxyProvider;
import org.dominokit.pages.ui.views.samples.colors.BrixColorsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ColorsProxy.class)
@Component(
    modules = {
        BrixColorsProxyModule_.class,
        BrixColorsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColorsComponent
    extends IsBrixComponent, HasPresenterProvider<ColorsProxyProvider> {

  ComponentProvider<ColorsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColorsComponent newInstance() {
          return DaggerColorsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
