package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixRowMenuProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.RowMenuProxy;
import org.dominokit.pages.presenters.samples.datatable.RowMenuProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.menu.BrixRowMenuViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = RowMenuProxy.class)
@Component(
    modules = {
        BrixRowMenuProxyModule_.class,
        BrixRowMenuViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RowMenuComponent
    extends IsBrixComponent, HasPresenterProvider<RowMenuProxyProvider> {

  ComponentProvider<RowMenuComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RowMenuComponent newInstance() {
          return DaggerRowMenuComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
