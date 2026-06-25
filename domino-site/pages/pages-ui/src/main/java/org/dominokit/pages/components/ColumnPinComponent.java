package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixColumnPinProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.ColumnPinProxy;
import org.dominokit.pages.presenters.samples.datatable.ColumnPinProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.columnpin.BrixColumnPinViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ColumnPinProxy.class)
@Component(
    modules = {
        BrixColumnPinProxyModule_.class,
        BrixColumnPinViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColumnPinComponent
    extends IsBrixComponent, HasPresenterProvider<ColumnPinProxyProvider> {

  ComponentProvider<ColumnPinComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColumnPinComponent newInstance() {
          return DaggerColumnPinComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
