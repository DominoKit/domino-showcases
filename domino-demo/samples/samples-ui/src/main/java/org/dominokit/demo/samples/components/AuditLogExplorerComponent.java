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
import org.dominokit.demo.samples.presenters.blueprints.BrixAuditLogExplorerPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.AuditLogExplorerPresenter;
import org.dominokit.demo.samples.presenters.blueprints.AuditLogExplorerPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixAuditLogExplorerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AuditLogExplorerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAuditLogExplorerPresenterModule_.class,
        BrixAuditLogExplorerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AuditLogExplorerComponent
    extends IsBrixComponent, HasPresenterProvider<AuditLogExplorerPresenterProvider> {

  ComponentProvider<AuditLogExplorerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AuditLogExplorerComponent newInstance() {
          return DaggerAuditLogExplorerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
