package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.animations.BrixAnimationsProxyModule_;
import org.dominokit.pages.presenters.samples.animations.AnimationsProxy;
import org.dominokit.pages.presenters.samples.animations.AnimationsProxyProvider;
import org.dominokit.pages.ui.views.samples.animations.BrixAnimationsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = AnimationsProxy.class)
@Component(
    modules = {
        BrixAnimationsProxyModule_.class,
        BrixAnimationsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AnimationsComponent
    extends IsBrixComponent, HasPresenterProvider<AnimationsProxyProvider> {

  ComponentProvider<AnimationsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AnimationsComponent newInstance() {
          return DaggerAnimationsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
