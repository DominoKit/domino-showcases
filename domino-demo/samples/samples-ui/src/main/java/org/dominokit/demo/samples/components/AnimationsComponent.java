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
import org.dominokit.demo.samples.presenters.animations.BrixAnimationsPresenterModule_;
import org.dominokit.demo.samples.presenters.animations.AnimationsPresenter;
import org.dominokit.demo.samples.presenters.animations.AnimationsPresenterProvider;
import org.dominokit.demo.samples.ui.views.animations.BrixAnimationsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AnimationsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAnimationsPresenterModule_.class,
        BrixAnimationsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AnimationsComponent
    extends IsBrixComponent, HasPresenterProvider<AnimationsPresenterProvider> {

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
