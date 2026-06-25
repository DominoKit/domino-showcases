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
import org.dominokit.demo.samples.presenters.datatable.BrixRecordDetailsPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.RecordDetailsPresenter;
import org.dominokit.demo.samples.presenters.datatable.RecordDetailsPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.details.BrixRecordDetailsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RecordDetailsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRecordDetailsPresenterModule_.class,
        BrixRecordDetailsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RecordDetailsComponent
    extends IsBrixComponent, HasPresenterProvider<RecordDetailsPresenterProvider> {

  ComponentProvider<RecordDetailsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RecordDetailsComponent newInstance() {
          return DaggerRecordDetailsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
