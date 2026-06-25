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
import org.dominokit.demo.samples.presenters.components.BrixDragAndDropPresenterModule_;
import org.dominokit.demo.samples.presenters.components.DragAndDropPresenter;
import org.dominokit.demo.samples.presenters.components.DragAndDropPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.dnd.BrixDragAndDropViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DragAndDropPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDragAndDropPresenterModule_.class,
        BrixDragAndDropViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DragAndDropComponent
    extends IsBrixComponent, HasPresenterProvider<DragAndDropPresenterProvider> {

  ComponentProvider<DragAndDropComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DragAndDropComponent newInstance() {
          return DaggerDragAndDropComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
