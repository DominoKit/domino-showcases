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
import org.dominokit.demo.samples.presenters.datatable.BrixColumnResizePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.ColumnResizePresenter;
import org.dominokit.demo.samples.presenters.datatable.ColumnResizePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.columnresize.BrixColumnResizeViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ColumnResizePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixColumnResizePresenterModule_.class,
        BrixColumnResizeViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColumnResizeComponent
    extends IsBrixComponent, HasPresenterProvider<ColumnResizePresenterProvider> {

  ComponentProvider<ColumnResizeComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColumnResizeComponent newInstance() {
          return DaggerColumnResizeComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
