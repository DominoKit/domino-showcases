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
import org.dominokit.demo.samples.presenters.datatable.BrixColumnsGroupsPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.ColumnsGroupsPresenter;
import org.dominokit.demo.samples.presenters.datatable.ColumnsGroupsPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.columngroup.BrixColumnsGroupsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ColumnsGroupsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixColumnsGroupsPresenterModule_.class,
        BrixColumnsGroupsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColumnsGroupsComponent
    extends IsBrixComponent, HasPresenterProvider<ColumnsGroupsPresenterProvider> {

  ComponentProvider<ColumnsGroupsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColumnsGroupsComponent newInstance() {
          return DaggerColumnsGroupsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
