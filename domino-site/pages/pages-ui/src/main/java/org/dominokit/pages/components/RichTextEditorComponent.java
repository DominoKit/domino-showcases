package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixRichTextEditorProxyModule_;
import org.dominokit.pages.presenters.samples.components.RichTextEditorProxy;
import org.dominokit.pages.presenters.samples.components.RichTextEditorProxyProvider;
import org.dominokit.pages.ui.views.samples.components.richtext.BrixRichTextEditorViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = RichTextEditorProxy.class)
@Component(
    modules = {
        BrixRichTextEditorProxyModule_.class,
        BrixRichTextEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RichTextEditorComponent
    extends IsBrixComponent, HasPresenterProvider<RichTextEditorProxyProvider> {

  ComponentProvider<RichTextEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RichTextEditorComponent newInstance() {
          return DaggerRichTextEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
