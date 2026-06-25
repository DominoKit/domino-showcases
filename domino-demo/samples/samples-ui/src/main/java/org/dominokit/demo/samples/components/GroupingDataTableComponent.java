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
import org.dominokit.demo.samples.presenters.datatable.BrixGroupingDataTablePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.GroupingDataTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.GroupingDataTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.grouping.BrixGroupingDataTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = GroupingDataTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixGroupingDataTablePresenterModule_.class,
        BrixGroupingDataTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface GroupingDataTableComponent
    extends IsBrixComponent, HasPresenterProvider<GroupingDataTablePresenterProvider> {

  ComponentProvider<GroupingDataTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected GroupingDataTableComponent newInstance() {
          return DaggerGroupingDataTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
