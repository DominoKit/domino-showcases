package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixBoardsProxyModule_;
import org.dominokit.pages.presenters.samples.components.BoardsProxy;
import org.dominokit.pages.presenters.samples.components.BoardsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.boards.BrixBoardsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = BoardsProxy.class)
@Component(
    modules = {
        BrixBoardsProxyModule_.class,
        BrixBoardsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BoardsComponent
    extends IsBrixComponent, HasPresenterProvider<BoardsProxyProvider> {

  ComponentProvider<BoardsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected BoardsComponent newInstance() {
          return DaggerBoardsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
