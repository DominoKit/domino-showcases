package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixFieldDecorationProxyModule_;
import org.dominokit.pages.presenters.samples.forms.FieldDecorationProxy;
import org.dominokit.pages.presenters.samples.forms.FieldDecorationProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.decoration.BrixFieldDecorationViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = FieldDecorationProxy.class)
@Component(
    modules = {
        BrixFieldDecorationProxyModule_.class,
        BrixFieldDecorationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FieldDecorationComponent
    extends IsBrixComponent, HasPresenterProvider<FieldDecorationProxyProvider> {

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
