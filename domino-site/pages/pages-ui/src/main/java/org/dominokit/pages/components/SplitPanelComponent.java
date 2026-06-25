package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.layouts.BrixSplitPanelProxyModule_;
import org.dominokit.pages.presenters.samples.layouts.SplitPanelProxy;
import org.dominokit.pages.presenters.samples.layouts.SplitPanelProxyProvider;
import org.dominokit.pages.ui.views.samples.layouts.split.BrixSplitPanelViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = SplitPanelProxy.class)
@Component(
    modules = {
        BrixSplitPanelProxyModule_.class,
        BrixSplitPanelViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SplitPanelComponent
    extends IsBrixComponent, HasPresenterProvider<SplitPanelProxyProvider> {

  ComponentProvider<SplitPanelComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SplitPanelComponent newInstance() {
          return DaggerSplitPanelComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
