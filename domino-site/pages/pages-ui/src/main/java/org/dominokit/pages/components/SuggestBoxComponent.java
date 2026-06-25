package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixSuggestBoxProxyModule_;
import org.dominokit.pages.presenters.samples.forms.SuggestBoxProxy;
import org.dominokit.pages.presenters.samples.forms.SuggestBoxProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.suggest.BrixSuggestBoxViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = SuggestBoxProxy.class)
@Component(
    modules = {
        BrixSuggestBoxProxyModule_.class,
        BrixSuggestBoxViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SuggestBoxComponent
    extends IsBrixComponent, HasPresenterProvider<SuggestBoxProxyProvider> {

  ComponentProvider<SuggestBoxComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SuggestBoxComponent newInstance() {
          return DaggerSuggestBoxComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
