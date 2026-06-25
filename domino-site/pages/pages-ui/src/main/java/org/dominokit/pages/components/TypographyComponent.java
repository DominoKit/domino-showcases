package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.typography.BrixTypographyProxyModule_;
import org.dominokit.pages.presenters.samples.typography.TypographyProxy;
import org.dominokit.pages.presenters.samples.typography.TypographyProxyProvider;
import org.dominokit.pages.ui.views.samples.typography.BrixTypographyViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TypographyProxy.class)
@Component(
    modules = {
        BrixTypographyProxyModule_.class,
        BrixTypographyViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TypographyComponent
    extends IsBrixComponent, HasPresenterProvider<TypographyProxyProvider> {

  ComponentProvider<TypographyComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TypographyComponent newInstance() {
          return DaggerTypographyComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
