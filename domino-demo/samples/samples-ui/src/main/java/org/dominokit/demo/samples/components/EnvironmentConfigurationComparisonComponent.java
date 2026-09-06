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
import org.dominokit.demo.samples.presenters.blueprints.BrixEnvironmentConfigurationComparisonPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.EnvironmentConfigurationComparisonPresenter;
import org.dominokit.demo.samples.presenters.blueprints.EnvironmentConfigurationComparisonPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixEnvironmentConfigurationComparisonViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = EnvironmentConfigurationComparisonPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixEnvironmentConfigurationComparisonPresenterModule_.class,
        BrixEnvironmentConfigurationComparisonViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface EnvironmentConfigurationComparisonComponent
    extends IsBrixComponent, HasPresenterProvider<EnvironmentConfigurationComparisonPresenterProvider> {

  ComponentProvider<EnvironmentConfigurationComparisonComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EnvironmentConfigurationComparisonComponent newInstance() {
          return DaggerEnvironmentConfigurationComparisonComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
