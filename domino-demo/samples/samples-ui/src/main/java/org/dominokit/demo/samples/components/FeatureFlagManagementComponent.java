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
import org.dominokit.demo.samples.presenters.blueprints.BrixFeatureFlagManagementPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.FeatureFlagManagementPresenter;
import org.dominokit.demo.samples.presenters.blueprints.FeatureFlagManagementPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixFeatureFlagManagementViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FeatureFlagManagementPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFeatureFlagManagementPresenterModule_.class,
        BrixFeatureFlagManagementViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FeatureFlagManagementComponent
    extends IsBrixComponent, HasPresenterProvider<FeatureFlagManagementPresenterProvider> {

  ComponentProvider<FeatureFlagManagementComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FeatureFlagManagementComponent newInstance() {
          return DaggerFeatureFlagManagementComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
