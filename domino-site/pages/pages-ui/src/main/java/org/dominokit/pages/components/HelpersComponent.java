package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.helpers.BrixHelpersProxyModule_;
import org.dominokit.pages.presenters.samples.helpers.HelpersProxy;
import org.dominokit.pages.presenters.samples.helpers.HelpersProxyProvider;
import org.dominokit.pages.ui.views.samples.helpers.BrixHelpersViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = HelpersProxy.class)
@Component(
    modules = {
        BrixHelpersProxyModule_.class,
        BrixHelpersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface HelpersComponent
    extends IsBrixComponent, HasPresenterProvider<HelpersProxyProvider> {

  ComponentProvider<HelpersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected HelpersComponent newInstance() {
          return DaggerHelpersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
