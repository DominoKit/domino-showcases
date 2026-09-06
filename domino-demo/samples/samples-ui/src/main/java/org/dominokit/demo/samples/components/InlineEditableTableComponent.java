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
import org.dominokit.demo.samples.presenters.blueprints.BrixInlineEditableTablePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.InlineEditableTablePresenter;
import org.dominokit.demo.samples.presenters.blueprints.InlineEditableTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixInlineEditableTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = InlineEditableTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixInlineEditableTablePresenterModule_.class,
        BrixInlineEditableTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface InlineEditableTableComponent
    extends IsBrixComponent, HasPresenterProvider<InlineEditableTablePresenterProvider> {

  ComponentProvider<InlineEditableTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected InlineEditableTableComponent newInstance() {
          return DaggerInlineEditableTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
