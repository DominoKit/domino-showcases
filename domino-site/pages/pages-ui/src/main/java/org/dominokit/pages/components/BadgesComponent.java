package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixBadgesProxyModule_;
import org.dominokit.pages.presenters.samples.components.BadgesProxy;
import org.dominokit.pages.presenters.samples.components.BadgesProxyProvider;
import org.dominokit.pages.ui.views.samples.components.badges.BrixBadgesViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = BadgesProxy.class)
@Component(
    modules = {
        BrixBadgesProxyModule_.class,
        BrixBadgesViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BadgesComponent
    extends IsBrixComponent, HasPresenterProvider<BadgesProxyProvider> {

  ComponentProvider<BadgesComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected BadgesComponent newInstance() {
          return DaggerBadgesComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
