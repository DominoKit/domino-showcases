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
import org.dominokit.demo.samples.presenters.blueprints.BrixAccessPolicyRuleEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.AccessPolicyRuleEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.AccessPolicyRuleEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity.BrixAccessPolicyRuleEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AccessPolicyRuleEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAccessPolicyRuleEditorPresenterModule_.class,
        BrixAccessPolicyRuleEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AccessPolicyRuleEditorComponent
    extends IsBrixComponent, HasPresenterProvider<AccessPolicyRuleEditorPresenterProvider> {

  ComponentProvider<AccessPolicyRuleEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AccessPolicyRuleEditorComponent newInstance() {
          return DaggerAccessPolicyRuleEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
