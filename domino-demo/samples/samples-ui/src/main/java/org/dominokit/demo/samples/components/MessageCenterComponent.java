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
import org.dominokit.demo.samples.presenters.blueprints.BrixMessageCenterPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.MessageCenterPresenter;
import org.dominokit.demo.samples.presenters.blueprints.MessageCenterPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixMessageCenterViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MessageCenterPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMessageCenterPresenterModule_.class,
        BrixMessageCenterViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MessageCenterComponent
    extends IsBrixComponent, HasPresenterProvider<MessageCenterPresenterProvider> {

  ComponentProvider<MessageCenterComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MessageCenterComponent newInstance() {
          return DaggerMessageCenterComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
