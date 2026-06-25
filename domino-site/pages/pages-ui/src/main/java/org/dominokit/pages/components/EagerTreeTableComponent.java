package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixEagerTreeTableProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.EagerTreeTableProxy;
import org.dominokit.pages.presenters.samples.datatable.EagerTreeTableProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.tree.BrixEagerTreeTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = EagerTreeTableProxy.class)
@Component(
    modules = {
        BrixEagerTreeTableProxyModule_.class,
        BrixEagerTreeTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface EagerTreeTableComponent
    extends IsBrixComponent, HasPresenterProvider<EagerTreeTableProxyProvider> {

  ComponentProvider<EagerTreeTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EagerTreeTableComponent newInstance() {
          return DaggerEagerTreeTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
