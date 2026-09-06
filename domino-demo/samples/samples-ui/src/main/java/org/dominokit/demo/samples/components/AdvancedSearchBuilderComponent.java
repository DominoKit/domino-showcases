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
import org.dominokit.demo.samples.presenters.blueprints.BrixAdvancedSearchBuilderPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.AdvancedSearchBuilderPresenter;
import org.dominokit.demo.samples.presenters.blueprints.AdvancedSearchBuilderPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixAdvancedSearchBuilderViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AdvancedSearchBuilderPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAdvancedSearchBuilderPresenterModule_.class,
        BrixAdvancedSearchBuilderViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AdvancedSearchBuilderComponent
    extends IsBrixComponent, HasPresenterProvider<AdvancedSearchBuilderPresenterProvider> {

  ComponentProvider<AdvancedSearchBuilderComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AdvancedSearchBuilderComponent newInstance() {
          return DaggerAdvancedSearchBuilderComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
