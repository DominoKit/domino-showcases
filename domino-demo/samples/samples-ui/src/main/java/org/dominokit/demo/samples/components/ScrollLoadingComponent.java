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
import org.dominokit.demo.samples.presenters.datatable.BrixScrollLoadingPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.ScrollLoadingPresenter;
import org.dominokit.demo.samples.presenters.datatable.ScrollLoadingPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.scroll.BrixScrollLoadingViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ScrollLoadingPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixScrollLoadingPresenterModule_.class,
        BrixScrollLoadingViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ScrollLoadingComponent
    extends IsBrixComponent, HasPresenterProvider<ScrollLoadingPresenterProvider> {

  ComponentProvider<ScrollLoadingComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ScrollLoadingComponent newInstance() {
          return DaggerScrollLoadingComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
