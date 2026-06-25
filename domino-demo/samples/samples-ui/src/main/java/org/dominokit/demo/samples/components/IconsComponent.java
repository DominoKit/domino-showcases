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
import org.dominokit.demo.samples.presenters.icons.BrixIconsPresenterModule_;
import org.dominokit.demo.samples.presenters.icons.IconsPresenter;
import org.dominokit.demo.samples.presenters.icons.IconsPresenterProvider;
import org.dominokit.demo.samples.ui.views.icons.BrixIconsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = IconsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixIconsPresenterModule_.class,
        BrixIconsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface IconsComponent extends IsBrixComponent, HasPresenterProvider<IconsPresenterProvider> {

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
