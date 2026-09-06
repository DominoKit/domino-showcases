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
import org.dominokit.demo.samples.presenters.blueprints.BrixAnnouncementAndBroadcastComposerPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.AnnouncementAndBroadcastComposerPresenter;
import org.dominokit.demo.samples.presenters.blueprints.AnnouncementAndBroadcastComposerPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixAnnouncementAndBroadcastComposerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AnnouncementAndBroadcastComposerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAnnouncementAndBroadcastComposerPresenterModule_.class,
        BrixAnnouncementAndBroadcastComposerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AnnouncementAndBroadcastComposerComponent
    extends IsBrixComponent, HasPresenterProvider<AnnouncementAndBroadcastComposerPresenterProvider> {

  ComponentProvider<AnnouncementAndBroadcastComposerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AnnouncementAndBroadcastComposerComponent newInstance() {
          return DaggerAnnouncementAndBroadcastComposerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
