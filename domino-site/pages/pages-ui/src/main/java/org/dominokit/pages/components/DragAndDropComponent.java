package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixDragAndDropProxyModule_;
import org.dominokit.pages.presenters.samples.components.DragAndDropProxy;
import org.dominokit.pages.presenters.samples.components.DragAndDropProxyProvider;
import org.dominokit.pages.ui.views.samples.components.dnd.BrixDragAndDropViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = DragAndDropProxy.class)
@Component(
    modules = {
        BrixDragAndDropProxyModule_.class,
        BrixDragAndDropViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DragAndDropComponent
    extends IsBrixComponent, HasPresenterProvider<DragAndDropProxyProvider> {

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
