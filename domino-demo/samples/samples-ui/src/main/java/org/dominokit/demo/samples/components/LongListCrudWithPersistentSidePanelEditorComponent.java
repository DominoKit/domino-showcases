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
import org.dominokit.demo.samples.presenters.blueprints.BrixLongListCrudWithPersistentSidePanelEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.LongListCrudWithPersistentSidePanelEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.LongListCrudWithPersistentSidePanelEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixLongListCrudWithPersistentSidePanelEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = LongListCrudWithPersistentSidePanelEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixLongListCrudWithPersistentSidePanelEditorPresenterModule_.class,
        BrixLongListCrudWithPersistentSidePanelEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LongListCrudWithPersistentSidePanelEditorComponent
    extends IsBrixComponent, HasPresenterProvider<LongListCrudWithPersistentSidePanelEditorPresenterProvider> {

  ComponentProvider<LongListCrudWithPersistentSidePanelEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LongListCrudWithPersistentSidePanelEditorComponent newInstance() {
          return DaggerLongListCrudWithPersistentSidePanelEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
