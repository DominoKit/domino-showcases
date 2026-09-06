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
import org.dominokit.demo.samples.presenters.blueprints.BrixCommentsAndCollaborationPanelPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.CommentsAndCollaborationPanelPresenter;
import org.dominokit.demo.samples.presenters.blueprints.CommentsAndCollaborationPanelPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixCommentsAndCollaborationPanelViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CommentsAndCollaborationPanelPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCommentsAndCollaborationPanelPresenterModule_.class,
        BrixCommentsAndCollaborationPanelViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CommentsAndCollaborationPanelComponent
    extends IsBrixComponent, HasPresenterProvider<CommentsAndCollaborationPanelPresenterProvider> {

  ComponentProvider<CommentsAndCollaborationPanelComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CommentsAndCollaborationPanelComponent newInstance() {
          return DaggerCommentsAndCollaborationPanelComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
