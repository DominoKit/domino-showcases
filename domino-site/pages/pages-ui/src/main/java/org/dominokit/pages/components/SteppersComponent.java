package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixSteppersProxyModule_;
import org.dominokit.pages.presenters.samples.forms.SteppersProxy;
import org.dominokit.pages.presenters.samples.forms.SteppersProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.steppers.BrixSteppersViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = SteppersProxy.class)
@Component(
    modules = {
        BrixSteppersProxyModule_.class,
        BrixSteppersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SteppersComponent
    extends IsBrixComponent, HasPresenterProvider<SteppersProxyProvider> {

  ComponentProvider<SteppersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SteppersComponent newInstance() {
          return DaggerSteppersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
