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
import org.dominokit.demo.samples.presenters.layouts.BrixAppLayoutPresenterModule_;
import org.dominokit.demo.samples.presenters.layouts.AppLayoutPresenter;
import org.dominokit.demo.samples.presenters.layouts.AppLayoutPresenterProvider;
import org.dominokit.demo.samples.ui.views.layouts.applayout.BrixAppLayoutViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AppLayoutPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAppLayoutPresenterModule_.class,
        BrixAppLayoutViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AppLayoutComponent
    extends IsBrixComponent, HasPresenterProvider<AppLayoutPresenterProvider> {

  ComponentProvider<AppLayoutComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AppLayoutComponent newInstance() {
          return DaggerAppLayoutComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
