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
import org.dominokit.demo.samples.presenters.datatable.BrixRowSelectionPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.RowSelectionPresenter;
import org.dominokit.demo.samples.presenters.datatable.RowSelectionPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.selection.BrixRowSelectionViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RowSelectionPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRowSelectionPresenterModule_.class,
        BrixRowSelectionViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RowSelectionComponent
    extends IsBrixComponent, HasPresenterProvider<RowSelectionPresenterProvider> {

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
