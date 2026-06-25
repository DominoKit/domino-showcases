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
import org.dominokit.demo.samples.presenters.colors.BrixColorsPresenterModule_;
import org.dominokit.demo.samples.presenters.colors.ColorsPresenter;
import org.dominokit.demo.samples.presenters.colors.ColorsPresenterProvider;
import org.dominokit.demo.samples.ui.views.colors.BrixColorsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ColorsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixColorsPresenterModule_.class,
        BrixColorsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColorsComponent
    extends IsBrixComponent, HasPresenterProvider<ColorsPresenterProvider> {

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
