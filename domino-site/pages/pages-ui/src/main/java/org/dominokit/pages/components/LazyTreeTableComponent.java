package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixLazyTreeTableProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.LazyTreeTableProxy;
import org.dominokit.pages.presenters.samples.datatable.LazyTreeTableProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.tree.BrixLazyTreeTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = LazyTreeTableProxy.class)
@Component(
    modules = {
        BrixLazyTreeTableProxyModule_.class,
        BrixLazyTreeTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LazyTreeTableComponent
    extends IsBrixComponent, HasPresenterProvider<LazyTreeTableProxyProvider> {

  ComponentProvider<LazyTreeTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LazyTreeTableComponent newInstance() {
          return DaggerLazyTreeTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
