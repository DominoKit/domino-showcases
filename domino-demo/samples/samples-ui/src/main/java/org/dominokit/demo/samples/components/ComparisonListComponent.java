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
import org.dominokit.demo.samples.presenters.blueprints.BrixComparisonListPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ComparisonListPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ComparisonListPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixComparisonListViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ComparisonListPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixComparisonListPresenterModule_.class,
        BrixComparisonListViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ComparisonListComponent
    extends IsBrixComponent, HasPresenterProvider<ComparisonListPresenterProvider> {

  ComponentProvider<ComparisonListComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ComparisonListComponent newInstance() {
          return DaggerComparisonListComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
