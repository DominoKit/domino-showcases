package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixBasicDataTableProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.presenters.samples.datatable.BasicDataTableProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.basic.BrixBasicDataTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = BasicDataTableProxy.class)
@Component(
    modules = {
        BrixBasicDataTableProxyModule_.class,
        BrixBasicDataTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BasicDataTableComponent
    extends IsBrixComponent, HasPresenterProvider<BasicDataTableProxyProvider> {

  ComponentProvider<BasicDataTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected BasicDataTableComponent newInstance() {
          return DaggerBasicDataTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
