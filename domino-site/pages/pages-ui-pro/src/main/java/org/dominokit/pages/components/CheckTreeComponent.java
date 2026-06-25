package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixCheckTreeProxyModule_;
import org.dominokit.pages.presenters.samples.components.CheckTreeProxy;
import org.dominokit.pages.presenters.samples.components.CheckTreeProxyProvider;
import org.dominokit.pages.ui.views.samples.components.tree.BrixCheckTreeViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = CheckTreeProxy.class)
@Component(
    modules = {
        BrixCheckTreeProxyModule_.class,
        BrixCheckTreeViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CheckTreeComponent
    extends IsBrixComponent, HasPresenterProvider<CheckTreeProxyProvider> {

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
