package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixTextBoxProxyModule_;
import org.dominokit.pages.presenters.samples.forms.TextBoxProxy;
import org.dominokit.pages.presenters.samples.forms.TextBoxProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.input.BrixTextBoxViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TextBoxProxy.class)
@Component(
    modules = {
        BrixTextBoxProxyModule_.class,
        BrixTextBoxViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TextBoxComponent
    extends IsBrixComponent, HasPresenterProvider<TextBoxProxyProvider> {

  ComponentProvider<TextBoxComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TextBoxComponent newInstance() {
          return DaggerTextBoxComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
