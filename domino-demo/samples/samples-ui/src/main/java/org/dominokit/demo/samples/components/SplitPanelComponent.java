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
import org.dominokit.demo.samples.presenters.layouts.BrixSplitPanelPresenterModule_;
import org.dominokit.demo.samples.presenters.layouts.SplitPanelPresenter;
import org.dominokit.demo.samples.presenters.layouts.SplitPanelPresenterProvider;
import org.dominokit.demo.samples.ui.views.layouts.split.BrixSplitPanelViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SplitPanelPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSplitPanelPresenterModule_.class,
        BrixSplitPanelViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SplitPanelComponent
    extends IsBrixComponent, HasPresenterProvider<SplitPanelPresenterProvider> {

  ComponentProvider<SplitPanelComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SplitPanelComponent newInstance() {
          return DaggerSplitPanelComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
