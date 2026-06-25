package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixTableRowMarkerProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.TableRowMarkerProxy;
import org.dominokit.pages.presenters.samples.datatable.TableRowMarkerProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.marker.BrixTableRowMarkerViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TableRowMarkerProxy.class)
@Component(
    modules = {
        BrixTableRowMarkerProxyModule_.class,
        BrixTableRowMarkerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableRowMarkerComponent
    extends IsBrixComponent, HasPresenterProvider<TableRowMarkerProxyProvider> {

  ComponentProvider<TableRowMarkerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableRowMarkerComponent newInstance() {
          return DaggerTableRowMarkerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
