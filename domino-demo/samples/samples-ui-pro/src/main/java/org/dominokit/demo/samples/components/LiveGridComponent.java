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
import org.dominokit.demo.samples.presenters.datatable.BrixLiveGridPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.LiveGridPresenter;
import org.dominokit.demo.samples.presenters.datatable.LiveGridPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.livegrid.BrixLiveGridViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = LiveGridPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixLiveGridPresenterModule_.class,
        BrixLiveGridViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LiveGridComponent
    extends IsBrixComponent, HasPresenterProvider<LiveGridPresenterProvider> {

  ComponentProvider<LiveGridComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LiveGridComponent newInstance() {
          return DaggerLiveGridComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
