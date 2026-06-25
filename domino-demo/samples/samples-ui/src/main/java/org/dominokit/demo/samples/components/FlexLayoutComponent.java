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
import org.dominokit.demo.samples.presenters.layouts.BrixFlexLayoutPresenterModule_;
import org.dominokit.demo.samples.presenters.layouts.FlexLayoutPresenter;
import org.dominokit.demo.samples.presenters.layouts.FlexLayoutPresenterProvider;
import org.dominokit.demo.samples.ui.views.layouts.flex.BrixFlexLayoutViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FlexLayoutPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFlexLayoutPresenterModule_.class,
        BrixFlexLayoutViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FlexLayoutComponent
    extends IsBrixComponent, HasPresenterProvider<FlexLayoutPresenterProvider> {

  ComponentProvider<FlexLayoutComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FlexLayoutComponent newInstance() {
          return DaggerFlexLayoutComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
