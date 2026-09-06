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
import org.dominokit.demo.samples.presenters.blueprints.BrixAdministrationIdentityAndSecurityPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.AdministrationIdentityAndSecurityPresenter;
import org.dominokit.demo.samples.presenters.blueprints.AdministrationIdentityAndSecurityPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixAdministrationIdentityAndSecurityViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AdministrationIdentityAndSecurityPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixAdministrationIdentityAndSecurityPresenterModule_.class,
      BrixAdministrationIdentityAndSecurityViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface AdministrationIdentityAndSecurityComponent
    extends IsBrixComponent, HasPresenterProvider<AdministrationIdentityAndSecurityPresenterProvider> {

  ComponentProvider<AdministrationIdentityAndSecurityComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AdministrationIdentityAndSecurityComponent newInstance() {
          return DaggerAdministrationIdentityAndSecurityComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
