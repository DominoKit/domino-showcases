package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixSelectProxyModule_;
import org.dominokit.pages.presenters.samples.forms.SelectProxy;
import org.dominokit.pages.presenters.samples.forms.SelectProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.select.BrixSelectViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = SelectProxy.class)
@Component(
    modules = {
        BrixSelectProxyModule_.class,
        BrixSelectViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SelectComponent
    extends IsBrixComponent, HasPresenterProvider<SelectProxyProvider> {

  ComponentProvider<SelectComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SelectComponent newInstance() {
          return DaggerSelectComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
