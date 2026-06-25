package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixProgressBarsProxyModule_;
import org.dominokit.pages.presenters.samples.components.ProgressBarsProxy;
import org.dominokit.pages.presenters.samples.components.ProgressBarsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.progress.BrixProgressBarsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ProgressBarsProxy.class)
@Component(
    modules = {
        BrixProgressBarsProxyModule_.class,
        BrixProgressBarsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ProgressBarsComponent
    extends IsBrixComponent, HasPresenterProvider<ProgressBarsProxyProvider> {

  ComponentProvider<ProgressBarsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ProgressBarsComponent newInstance() {
          return DaggerProgressBarsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
