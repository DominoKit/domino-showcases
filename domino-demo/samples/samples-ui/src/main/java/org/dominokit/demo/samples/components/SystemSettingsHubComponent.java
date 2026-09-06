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
import org.dominokit.demo.samples.presenters.blueprints.BrixSystemSettingsHubPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SystemSettingsHubPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SystemSettingsHubPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixSystemSettingsHubViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SystemSettingsHubPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSystemSettingsHubPresenterModule_.class,
        BrixSystemSettingsHubViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SystemSettingsHubComponent
    extends IsBrixComponent, HasPresenterProvider<SystemSettingsHubPresenterProvider> {

  ComponentProvider<SystemSettingsHubComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SystemSettingsHubComponent newInstance() {
          return DaggerSystemSettingsHubComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
