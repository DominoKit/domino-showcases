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
import org.dominokit.demo.samples.presenters.blueprints.BrixUserDirectoryAndProfileAdministrationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.UserDirectoryAndProfileAdministrationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.UserDirectoryAndProfileAdministrationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixUserDirectoryAndProfileAdministrationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = UserDirectoryAndProfileAdministrationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixUserDirectoryAndProfileAdministrationPresenterModule_.class,
        BrixUserDirectoryAndProfileAdministrationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface UserDirectoryAndProfileAdministrationComponent
    extends IsBrixComponent, HasPresenterProvider<UserDirectoryAndProfileAdministrationPresenterProvider> {

  ComponentProvider<UserDirectoryAndProfileAdministrationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected UserDirectoryAndProfileAdministrationComponent newInstance() {
          return DaggerUserDirectoryAndProfileAdministrationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
