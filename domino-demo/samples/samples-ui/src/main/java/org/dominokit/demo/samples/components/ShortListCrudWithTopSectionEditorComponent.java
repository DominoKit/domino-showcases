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
import org.dominokit.demo.samples.presenters.blueprints.BrixShortListCrudWithTopSectionEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ShortListCrudWithTopSectionEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ShortListCrudWithTopSectionEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixShortListCrudWithTopSectionEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ShortListCrudWithTopSectionEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixShortListCrudWithTopSectionEditorPresenterModule_.class,
        BrixShortListCrudWithTopSectionEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ShortListCrudWithTopSectionEditorComponent
    extends IsBrixComponent, HasPresenterProvider<ShortListCrudWithTopSectionEditorPresenterProvider> {

  ComponentProvider<ShortListCrudWithTopSectionEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ShortListCrudWithTopSectionEditorComponent newInstance() {
          return DaggerShortListCrudWithTopSectionEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
