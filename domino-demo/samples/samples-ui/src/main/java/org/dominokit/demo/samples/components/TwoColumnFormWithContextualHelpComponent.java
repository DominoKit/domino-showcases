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
import org.dominokit.demo.samples.presenters.blueprints.BrixTwoColumnFormWithContextualHelpPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.TwoColumnFormWithContextualHelpPresenter;
import org.dominokit.demo.samples.presenters.blueprints.TwoColumnFormWithContextualHelpPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows.BrixTwoColumnFormWithContextualHelpViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TwoColumnFormWithContextualHelpPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTwoColumnFormWithContextualHelpPresenterModule_.class,
        BrixTwoColumnFormWithContextualHelpViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TwoColumnFormWithContextualHelpComponent
    extends IsBrixComponent, HasPresenterProvider<TwoColumnFormWithContextualHelpPresenterProvider> {

  ComponentProvider<TwoColumnFormWithContextualHelpComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TwoColumnFormWithContextualHelpComponent newInstance() {
          return DaggerTwoColumnFormWithContextualHelpComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
