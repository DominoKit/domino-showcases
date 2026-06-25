package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixDragDropTableProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.DragDropTableProxy;
import org.dominokit.pages.presenters.samples.datatable.DragDropTableProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.dragdrop.BrixDragDropTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = DragDropTableProxy.class)
@Component(
    modules = {
        BrixDragDropTableProxyModule_.class,
        BrixDragDropTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DragDropTableComponent
    extends IsBrixComponent, HasPresenterProvider<DragDropTableProxyProvider> {

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
