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
import org.dominokit.demo.samples.presenters.blueprints.BrixDocumentLibraryPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.DocumentLibraryPresenter;
import org.dominokit.demo.samples.presenters.blueprints.DocumentLibraryPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixDocumentLibraryViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DocumentLibraryPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDocumentLibraryPresenterModule_.class,
        BrixDocumentLibraryViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DocumentLibraryComponent
    extends IsBrixComponent, HasPresenterProvider<DocumentLibraryPresenterProvider> {

  ComponentProvider<DocumentLibraryComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DocumentLibraryComponent newInstance() {
          return DaggerDocumentLibraryComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
