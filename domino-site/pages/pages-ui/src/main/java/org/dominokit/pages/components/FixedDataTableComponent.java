package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixFixedDataTableProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.FixedDataTableProxy;
import org.dominokit.pages.presenters.samples.datatable.FixedDataTableProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.fixed.BrixFixedDataTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = FixedDataTableProxy.class)
@Component(
    modules = {
        BrixFixedDataTableProxyModule_.class,
        BrixFixedDataTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FixedDataTableComponent
    extends IsBrixComponent, HasPresenterProvider<FixedDataTableProxyProvider> {

  ComponentProvider<FixedDataTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FixedDataTableComponent newInstance() {
          return DaggerFixedDataTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
