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
import org.dominokit.demo.samples.presenters.blueprints.BrixSecurityEventResponseScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SecurityEventResponseScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SecurityEventResponseScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixSecurityEventResponseScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SecurityEventResponseScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSecurityEventResponseScreenPresenterModule_.class,
        BrixSecurityEventResponseScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SecurityEventResponseScreenComponent
    extends IsBrixComponent, HasPresenterProvider<SecurityEventResponseScreenPresenterProvider> {

  ComponentProvider<SecurityEventResponseScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SecurityEventResponseScreenComponent newInstance() {
          return DaggerSecurityEventResponseScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
