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
import org.dominokit.demo.samples.presenters.helpers.BrixHelpersPresenterModule_;
import org.dominokit.demo.samples.presenters.helpers.HelpersPresenter;
import org.dominokit.demo.samples.presenters.helpers.HelpersPresenterProvider;
import org.dominokit.demo.samples.ui.views.helpers.BrixHelpersViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = HelpersPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixHelpersPresenterModule_.class,
        BrixHelpersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface HelpersComponent
    extends IsBrixComponent, HasPresenterProvider<HelpersPresenterProvider> {

  ComponentProvider<HelpersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected HelpersComponent newInstance() {
          return DaggerHelpersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
