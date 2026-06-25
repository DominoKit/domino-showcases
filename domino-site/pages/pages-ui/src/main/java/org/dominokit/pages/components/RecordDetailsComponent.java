package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixRecordDetailsProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.RecordDetailsProxy;
import org.dominokit.pages.presenters.samples.datatable.RecordDetailsProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.details.BrixRecordDetailsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = RecordDetailsProxy.class)
@Component(
    modules = {
        BrixRecordDetailsProxyModule_.class,
        BrixRecordDetailsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RecordDetailsComponent
    extends IsBrixComponent, HasPresenterProvider<RecordDetailsProxyProvider> {

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
