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
import org.dominokit.demo.samples.presenters.blueprints.BrixKnowledgeBaseBrowserPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.KnowledgeBaseBrowserPresenter;
import org.dominokit.demo.samples.presenters.blueprints.KnowledgeBaseBrowserPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixKnowledgeBaseBrowserViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = KnowledgeBaseBrowserPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixKnowledgeBaseBrowserPresenterModule_.class,
        BrixKnowledgeBaseBrowserViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface KnowledgeBaseBrowserComponent
    extends IsBrixComponent, HasPresenterProvider<KnowledgeBaseBrowserPresenterProvider> {

  ComponentProvider<KnowledgeBaseBrowserComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected KnowledgeBaseBrowserComponent newInstance() {
          return DaggerKnowledgeBaseBrowserComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
