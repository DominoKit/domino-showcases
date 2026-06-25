package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixGroupingDataTableProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.GroupingDataTableProxy;
import org.dominokit.pages.presenters.samples.datatable.GroupingDataTableProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.grouping.BrixGroupingDataTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = GroupingDataTableProxy.class)
@Component(
    modules = {
        BrixGroupingDataTableProxyModule_.class,
        BrixGroupingDataTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface GroupingDataTableComponent
    extends IsBrixComponent, HasPresenterProvider<GroupingDataTableProxyProvider> {

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
