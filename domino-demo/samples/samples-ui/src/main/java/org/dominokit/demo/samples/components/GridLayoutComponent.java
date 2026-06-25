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
import org.dominokit.demo.samples.presenters.layouts.BrixGridLayoutPresenterModule_;
import org.dominokit.demo.samples.presenters.layouts.GridLayoutPresenter;
import org.dominokit.demo.samples.presenters.layouts.GridLayoutPresenterProvider;
import org.dominokit.demo.samples.ui.views.layouts.gridlayout.BrixGridLayoutViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = GridLayoutPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixGridLayoutPresenterModule_.class,
        BrixGridLayoutViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface GridLayoutComponent
    extends IsBrixComponent, HasPresenterProvider<GridLayoutPresenterProvider> {

  ComponentProvider<GridLayoutComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected GridLayoutComponent newInstance() {
          return DaggerGridLayoutComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
