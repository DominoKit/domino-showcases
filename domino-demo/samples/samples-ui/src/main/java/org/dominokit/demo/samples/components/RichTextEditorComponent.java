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
import org.dominokit.demo.samples.presenters.components.BrixRichTextEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.components.RichTextEditorPresenter;
import org.dominokit.demo.samples.presenters.components.RichTextEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.richtext.BrixRichTextEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RichTextEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRichTextEditorPresenterModule_.class,
        BrixRichTextEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RichTextEditorComponent
    extends IsBrixComponent, HasPresenterProvider<RichTextEditorPresenterProvider> {

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
