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
import org.dominokit.demo.samples.presenters.components.BrixTreePresenterModule_;
import org.dominokit.demo.samples.presenters.components.TreePresenter;
import org.dominokit.demo.samples.presenters.components.TreePresenterProvider;
import org.dominokit.demo.samples.ui.views.components.tree.BrixTreeViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TreePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTreePresenterModule_.class,
        BrixTreeViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TreeComponent
    extends IsBrixComponent, HasPresenterProvider<TreePresenterProvider> {

  ComponentProvider<TreeComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TreeComponent newInstance() {
          return DaggerTreeComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
