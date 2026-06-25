package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixColumnResizeProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.ColumnResizeProxy;
import org.dominokit.pages.presenters.samples.datatable.ColumnResizeProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.columnresize.BrixColumnResizeViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ColumnResizeProxy.class)
@Component(
    modules = {
        BrixColumnResizeProxyModule_.class,
        BrixColumnResizeViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColumnResizeComponent
    extends IsBrixComponent, HasPresenterProvider<ColumnResizeProxyProvider> {

  ComponentProvider<ColumnResizeComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColumnResizeComponent newInstance() {
          return DaggerColumnResizeComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
