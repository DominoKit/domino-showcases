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
import org.dominokit.demo.samples.presenters.blueprints.BrixApiKeyAndIntegrationManagementPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ApiKeyAndIntegrationManagementPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ApiKeyAndIntegrationManagementPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixApiKeyAndIntegrationManagementViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ApiKeyAndIntegrationManagementPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixApiKeyAndIntegrationManagementPresenterModule_.class,
        BrixApiKeyAndIntegrationManagementViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ApiKeyAndIntegrationManagementComponent
    extends IsBrixComponent, HasPresenterProvider<ApiKeyAndIntegrationManagementPresenterProvider> {

  ComponentProvider<ApiKeyAndIntegrationManagementComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ApiKeyAndIntegrationManagementComponent newInstance() {
          return DaggerApiKeyAndIntegrationManagementComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
