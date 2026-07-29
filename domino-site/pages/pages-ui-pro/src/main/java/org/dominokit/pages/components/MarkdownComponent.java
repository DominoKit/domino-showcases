package org.dominokit.pages.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.pages.presenters.samples.components.BrixMarkdownProxyModule_;
import org.dominokit.pages.presenters.samples.components.MarkdownProxy;
import org.dominokit.pages.presenters.samples.components.MarkdownProxyProvider;
import org.dominokit.pages.ui.views.samples.components.markdown.BrixMarkdownViewModule_;

@BrixComponent(presenter = MarkdownProxy.class)
@Component(
    modules = {
        BrixMarkdownProxyModule_.class,
        BrixMarkdownViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MarkdownComponent
    extends IsBrixComponent, HasPresenterProvider<MarkdownProxyProvider> {

  ComponentProvider<MarkdownComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MarkdownComponent newInstance() {
          return DaggerMarkdownComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
