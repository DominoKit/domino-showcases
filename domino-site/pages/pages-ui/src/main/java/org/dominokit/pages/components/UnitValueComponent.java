package org.dominokit.pages.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.pages.presenters.samples.components.BrixUnitValueProxyModule_;
import org.dominokit.pages.presenters.samples.components.UnitValueProxy;
import org.dominokit.pages.presenters.samples.components.UnitValueProxyProvider;
import org.dominokit.pages.ui.views.samples.components.unitvalue.BrixUnitValueViewModule_;

@BrixComponent(presenter = UnitValueProxy.class)
@Component(
    modules = {
        BrixUnitValueProxyModule_.class,
        BrixUnitValueViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface UnitValueComponent extends IsBrixComponent, HasPresenterProvider<UnitValueProxyProvider> {

  ComponentProvider<UnitValueComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected UnitValueComponent newInstance() {
          return DaggerUnitValueComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
