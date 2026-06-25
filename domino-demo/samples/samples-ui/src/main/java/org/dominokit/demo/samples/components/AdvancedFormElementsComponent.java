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
import org.dominokit.demo.samples.presenters.forms.BrixAdvancedFormElementsPresenterModule_;
import org.dominokit.demo.samples.presenters.forms.AdvancedFormElementsPresenter;
import org.dominokit.demo.samples.presenters.forms.AdvancedFormElementsPresenterProvider;
import org.dominokit.demo.samples.ui.views.forms.advanced.BrixAdvancedFormElementsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AdvancedFormElementsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAdvancedFormElementsPresenterModule_.class,
        BrixAdvancedFormElementsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AdvancedFormElementsComponent
    extends IsBrixComponent, HasPresenterProvider<AdvancedFormElementsPresenterProvider> {

  ComponentProvider<AdvancedFormElementsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AdvancedFormElementsComponent newInstance() {
          return DaggerAdvancedFormElementsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
