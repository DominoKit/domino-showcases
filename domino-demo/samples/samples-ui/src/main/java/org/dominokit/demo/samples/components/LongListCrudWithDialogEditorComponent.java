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
import org.dominokit.demo.samples.presenters.blueprints.BrixLongListCrudWithDialogEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.LongListCrudWithDialogEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.LongListCrudWithDialogEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixLongListCrudWithDialogEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = LongListCrudWithDialogEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixLongListCrudWithDialogEditorPresenterModule_.class,
        BrixLongListCrudWithDialogEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LongListCrudWithDialogEditorComponent
    extends IsBrixComponent, HasPresenterProvider<LongListCrudWithDialogEditorPresenterProvider> {

  ComponentProvider<LongListCrudWithDialogEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LongListCrudWithDialogEditorComponent newInstance() {
          return DaggerLongListCrudWithDialogEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
