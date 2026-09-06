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
import org.dominokit.demo.samples.presenters.blueprints.BrixSpecialStatesAndConstrainedCompositionsPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SpecialStatesAndConstrainedCompositionsPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SpecialStatesAndConstrainedCompositionsPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixSpecialStatesAndConstrainedCompositionsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SpecialStatesAndConstrainedCompositionsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixSpecialStatesAndConstrainedCompositionsPresenterModule_.class,
      BrixSpecialStatesAndConstrainedCompositionsViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface SpecialStatesAndConstrainedCompositionsComponent
    extends IsBrixComponent, HasPresenterProvider<SpecialStatesAndConstrainedCompositionsPresenterProvider> {

  ComponentProvider<SpecialStatesAndConstrainedCompositionsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SpecialStatesAndConstrainedCompositionsComponent newInstance() {
          return DaggerSpecialStatesAndConstrainedCompositionsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
