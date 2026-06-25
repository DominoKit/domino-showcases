package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixTreeProxyModule_;
import org.dominokit.pages.presenters.samples.components.TreeProxy;
import org.dominokit.pages.presenters.samples.components.TreeProxyProvider;
import org.dominokit.pages.ui.views.samples.components.tree.BrixTreeViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TreeProxy.class)
@Component(
    modules = {
        BrixTreeProxyModule_.class,
        BrixTreeViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TreeComponent
    extends IsBrixComponent, HasPresenterProvider<TreeProxyProvider> {

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
