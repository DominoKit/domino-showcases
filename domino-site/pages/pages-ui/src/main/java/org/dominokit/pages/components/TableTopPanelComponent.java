package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixTableTopPanelProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.TableTopPanelProxy;
import org.dominokit.pages.presenters.samples.datatable.TableTopPanelProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.top.BrixTableTopPanelViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TableTopPanelProxy.class)
@Component(
    modules = {
        BrixTableTopPanelProxyModule_.class,
        BrixTableTopPanelViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableTopPanelComponent
    extends IsBrixComponent, HasPresenterProvider<TableTopPanelProxyProvider> {

  ComponentProvider<TableTopPanelComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableTopPanelComponent newInstance() {
          return DaggerTableTopPanelComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
