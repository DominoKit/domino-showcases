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
import org.dominokit.demo.samples.presenters.blueprints.BrixShortListCrudWithDialogEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ShortListCrudWithDialogEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ShortListCrudWithDialogEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixShortListCrudWithDialogEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ShortListCrudWithDialogEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixShortListCrudWithDialogEditorPresenterModule_.class,
        BrixShortListCrudWithDialogEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ShortListCrudWithDialogEditorComponent
    extends IsBrixComponent, HasPresenterProvider<ShortListCrudWithDialogEditorPresenterProvider> {

  ComponentProvider<ShortListCrudWithDialogEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ShortListCrudWithDialogEditorComponent newInstance() {
          return DaggerShortListCrudWithDialogEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
