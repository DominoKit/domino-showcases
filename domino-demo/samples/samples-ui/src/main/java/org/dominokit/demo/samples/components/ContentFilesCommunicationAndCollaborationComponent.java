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
import org.dominokit.demo.samples.presenters.blueprints.BrixContentFilesCommunicationAndCollaborationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ContentFilesCommunicationAndCollaborationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ContentFilesCommunicationAndCollaborationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixContentFilesCommunicationAndCollaborationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ContentFilesCommunicationAndCollaborationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixContentFilesCommunicationAndCollaborationPresenterModule_.class,
      BrixContentFilesCommunicationAndCollaborationViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface ContentFilesCommunicationAndCollaborationComponent
    extends IsBrixComponent, HasPresenterProvider<ContentFilesCommunicationAndCollaborationPresenterProvider> {

  ComponentProvider<ContentFilesCommunicationAndCollaborationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ContentFilesCommunicationAndCollaborationComponent newInstance() {
          return DaggerContentFilesCommunicationAndCollaborationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
