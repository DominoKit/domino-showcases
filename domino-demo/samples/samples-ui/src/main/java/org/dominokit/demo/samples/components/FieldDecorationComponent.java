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
import org.dominokit.demo.samples.presenters.forms.BrixFieldDecorationPresenterModule_;
import org.dominokit.demo.samples.presenters.forms.FieldDecorationPresenter;
import org.dominokit.demo.samples.presenters.forms.FieldDecorationPresenterProvider;
import org.dominokit.demo.samples.ui.views.forms.decoration.BrixFieldDecorationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FieldDecorationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFieldDecorationPresenterModule_.class,
        BrixFieldDecorationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FieldDecorationComponent
    extends IsBrixComponent, HasPresenterProvider<FieldDecorationPresenterProvider> {

  ComponentProvider<FieldDecorationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FieldDecorationComponent newInstance() {
          return DaggerFieldDecorationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
