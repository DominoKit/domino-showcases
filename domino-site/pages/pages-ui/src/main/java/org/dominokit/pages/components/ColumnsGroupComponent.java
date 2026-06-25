package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixColumnsGroupProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.ColumnsGroupProxy;
import org.dominokit.pages.presenters.samples.datatable.ColumnsGroupProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.columngroup.BrixColumnsGroupsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ColumnsGroupProxy.class)
@Component(
    modules = {
        BrixColumnsGroupProxyModule_.class,
        BrixColumnsGroupsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColumnsGroupComponent
    extends IsBrixComponent, HasPresenterProvider<ColumnsGroupProxyProvider> {

  ComponentProvider<ColumnsGroupComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColumnsGroupComponent newInstance() {
          return DaggerColumnsGroupComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
