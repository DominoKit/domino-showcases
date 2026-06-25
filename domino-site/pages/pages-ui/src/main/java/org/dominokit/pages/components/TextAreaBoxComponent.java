package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixTextAreaBoxProxyModule_;
import org.dominokit.pages.presenters.samples.forms.TextAreaBoxProxy;
import org.dominokit.pages.presenters.samples.forms.TextAreaBoxProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.input.BrixTextAreaBoxViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TextAreaBoxProxy.class)
@Component(
    modules = {
        BrixTextAreaBoxProxyModule_.class,
        BrixTextAreaBoxViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TextAreaBoxComponent
    extends IsBrixComponent, HasPresenterProvider<TextAreaBoxProxyProvider> {

  ComponentProvider<TextAreaBoxComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TextAreaBoxComponent newInstance() {
          return DaggerTextAreaBoxComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
