package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixTableHeaderBarProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.TableHeaderBarProxy;
import org.dominokit.pages.presenters.samples.datatable.TableHeaderBarProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.header.BrixTableHeaderViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TableHeaderBarProxy.class)
@Component(
    modules = {
        BrixTableHeaderBarProxyModule_.class,
        BrixTableHeaderViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableHeaderBarComponent
    extends IsBrixComponent, HasPresenterProvider<TableHeaderBarProxyProvider> {

  ComponentProvider<TableHeaderBarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableHeaderBarComponent newInstance() {
          return DaggerTableHeaderBarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
