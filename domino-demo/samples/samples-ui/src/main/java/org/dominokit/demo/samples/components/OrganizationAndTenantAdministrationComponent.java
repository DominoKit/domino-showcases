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
import org.dominokit.demo.samples.presenters.blueprints.BrixOrganizationAndTenantAdministrationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.OrganizationAndTenantAdministrationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.OrganizationAndTenantAdministrationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixOrganizationAndTenantAdministrationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = OrganizationAndTenantAdministrationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixOrganizationAndTenantAdministrationPresenterModule_.class,
        BrixOrganizationAndTenantAdministrationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface OrganizationAndTenantAdministrationComponent
    extends IsBrixComponent, HasPresenterProvider<OrganizationAndTenantAdministrationPresenterProvider> {

  ComponentProvider<OrganizationAndTenantAdministrationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected OrganizationAndTenantAdministrationComponent newInstance() {
          return DaggerOrganizationAndTenantAdministrationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
