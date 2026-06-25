package org.dominokit.demo.samples.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.demo.samples.presenters.datatable.BrixPluginsMixPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.PluginsMixPresenter;
import org.dominokit.demo.samples.presenters.datatable.PluginsMixPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.mix.BrixPluginsMixViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = PluginsMixPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixPluginsMixPresenterModule_.class,
        BrixPluginsMixViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PluginsMixComponent
    extends IsBrixComponent, HasPresenterProvider<PluginsMixPresenterProvider> {

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
