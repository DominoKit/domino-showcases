package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixEditableTableProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.EditableTableProxy;
import org.dominokit.pages.presenters.samples.datatable.EditableTableProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.editable.BrixEditableTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = EditableTableProxy.class)
@Component(
    modules = {
        BrixEditableTableProxyModule_.class,
        BrixEditableTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface EditableTableComponent
    extends IsBrixComponent, HasPresenterProvider<EditableTableProxyProvider> {

  ComponentProvider<EditableTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EditableTableComponent newInstance() {
          return DaggerEditableTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
