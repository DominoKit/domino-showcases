package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixRowSelectionProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.RowSelectionProxy;
import org.dominokit.pages.presenters.samples.datatable.RowSelectionProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.selection.BrixRowSelectionViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = RowSelectionProxy.class)
@Component(
    modules = {
        BrixRowSelectionProxyModule_.class,
        BrixRowSelectionViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RowSelectionComponent
    extends IsBrixComponent, HasPresenterProvider<RowSelectionProxyProvider> {

  ComponentProvider<RowSelectionComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RowSelectionComponent newInstance() {
          return DaggerRowSelectionComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
