package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixTableSummaryProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.TableSummaryProxy;
import org.dominokit.pages.presenters.samples.datatable.TableSummaryProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.summary.BrixTableSummaryViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TableSummaryProxy.class)
@Component(
    modules = {
        BrixTableSummaryProxyModule_.class,
        BrixTableSummaryViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableSummaryComponent
    extends IsBrixComponent, HasPresenterProvider<TableSummaryProxyProvider> {

  ComponentProvider<TableSummaryComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableSummaryComponent newInstance() {
          return DaggerTableSummaryComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
