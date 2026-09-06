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
import org.dominokit.demo.samples.presenters.blueprints.BrixRichContentEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.RichContentEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.RichContentEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixRichContentEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RichContentEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRichContentEditorPresenterModule_.class,
        BrixRichContentEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RichContentEditorComponent
    extends IsBrixComponent, HasPresenterProvider<RichContentEditorPresenterProvider> {

  ComponentProvider<RichContentEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RichContentEditorComponent newInstance() {
          return DaggerRichContentEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
