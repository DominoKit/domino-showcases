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
import org.dominokit.demo.samples.presenters.blueprints.BrixVersionedDocumentEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.VersionedDocumentEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.VersionedDocumentEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixVersionedDocumentEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = VersionedDocumentEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixVersionedDocumentEditorPresenterModule_.class,
        BrixVersionedDocumentEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface VersionedDocumentEditorComponent
    extends IsBrixComponent, HasPresenterProvider<VersionedDocumentEditorPresenterProvider> {

  ComponentProvider<VersionedDocumentEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected VersionedDocumentEditorComponent newInstance() {
          return DaggerVersionedDocumentEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
