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
import org.dominokit.demo.samples.presenters.datatable.BrixDragDropTablePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.DragDropTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.DragDropTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.dragdrop.BrixDragDropTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DragDropTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDragDropTablePresenterModule_.class,
        BrixDragDropTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DragDropTableComponent
    extends IsBrixComponent, HasPresenterProvider<DragDropTablePresenterProvider> {

  ComponentProvider<DragDropTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DragDropTableComponent newInstance() {
          return DaggerDragDropTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
