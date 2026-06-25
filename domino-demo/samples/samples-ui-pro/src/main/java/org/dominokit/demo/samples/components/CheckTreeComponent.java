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
import org.dominokit.demo.samples.presenters.components.BrixCheckTreePresenterModule_;
import org.dominokit.demo.samples.presenters.components.CheckTreePresenter;
import org.dominokit.demo.samples.presenters.components.CheckTreePresenterProvider;
import org.dominokit.demo.samples.ui.views.components.tree.BrixCheckTreeViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CheckTreePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCheckTreePresenterModule_.class,
        BrixCheckTreeViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CheckTreeComponent
    extends IsBrixComponent, HasPresenterProvider<CheckTreePresenterProvider> {

  ComponentProvider<CheckTreeComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CheckTreeComponent newInstance() {
          return DaggerCheckTreeComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
