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
import org.dominokit.demo.samples.presenters.components.BrixProgressBarsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.ProgressBarsPresenter;
import org.dominokit.demo.samples.presenters.components.ProgressBarsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.progress.BrixProgressBarsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ProgressBarsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixProgressBarsPresenterModule_.class,
        BrixProgressBarsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ProgressBarsComponent
    extends IsBrixComponent, HasPresenterProvider<ProgressBarsPresenterProvider> {

  ComponentProvider<ProgressBarsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ProgressBarsComponent newInstance() {
          return DaggerProgressBarsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
