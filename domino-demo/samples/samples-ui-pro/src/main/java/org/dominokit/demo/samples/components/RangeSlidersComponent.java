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
import org.dominokit.demo.samples.presenters.components.BrixRangeSlidersPresenterModule_;
import org.dominokit.demo.samples.presenters.components.RangeSlidersPresenter;
import org.dominokit.demo.samples.presenters.components.RangeSlidersPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.sliders.BrixRangeSlidersViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RangeSlidersPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRangeSlidersPresenterModule_.class,
        BrixRangeSlidersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RangeSlidersComponent
    extends IsBrixComponent, HasPresenterProvider<RangeSlidersPresenterProvider> {

  ComponentProvider<RangeSlidersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RangeSlidersComponent newInstance() {
          return DaggerRangeSlidersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
