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
import org.dominokit.demo.samples.presenters.components.BrixBoardsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.BoardsPresenter;
import org.dominokit.demo.samples.presenters.components.BoardsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.boards.BrixBoardsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = BoardsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixBoardsPresenterModule_.class,
        BrixBoardsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BoardsComponent
    extends IsBrixComponent, HasPresenterProvider<BoardsPresenterProvider> {

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
