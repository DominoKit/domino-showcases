package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixPluginsMixProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.PluginsMixProxy;
import org.dominokit.pages.presenters.samples.datatable.PluginsMixProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.mix.BrixPluginMixViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = PluginsMixProxy.class)
@Component(
    modules = {
        BrixPluginsMixProxyModule_.class,
        BrixPluginMixViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PluginsMixComponent
    extends IsBrixComponent, HasPresenterProvider<PluginsMixProxyProvider> {

  ComponentProvider<PluginsMixComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PluginsMixComponent newInstance() {
          return DaggerPluginsMixComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
