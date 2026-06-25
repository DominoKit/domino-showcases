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
import org.dominokit.demo.samples.presenters.data.BrixDataListPresenterModule_;
import org.dominokit.demo.samples.presenters.data.DataListPresenter;
import org.dominokit.demo.samples.presenters.data.DataListPresenterProvider;
import org.dominokit.demo.samples.ui.views.data.BrixDataListViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DataListPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDataListPresenterModule_.class,
        BrixDataListViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DataListComponent
    extends IsBrixComponent, HasPresenterProvider<DataListPresenterProvider> {

  ComponentProvider<DataListComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DataListComponent newInstance() {
          return DaggerDataListComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
