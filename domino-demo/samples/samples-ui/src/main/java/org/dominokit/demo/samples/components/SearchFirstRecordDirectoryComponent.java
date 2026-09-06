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
import org.dominokit.demo.samples.presenters.blueprints.BrixSearchFirstRecordDirectoryPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SearchFirstRecordDirectoryPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SearchFirstRecordDirectoryPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixSearchFirstRecordDirectoryViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SearchFirstRecordDirectoryPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSearchFirstRecordDirectoryPresenterModule_.class,
        BrixSearchFirstRecordDirectoryViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SearchFirstRecordDirectoryComponent
    extends IsBrixComponent, HasPresenterProvider<SearchFirstRecordDirectoryPresenterProvider> {

  ComponentProvider<SearchFirstRecordDirectoryComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SearchFirstRecordDirectoryComponent newInstance() {
          return DaggerSearchFirstRecordDirectoryComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
