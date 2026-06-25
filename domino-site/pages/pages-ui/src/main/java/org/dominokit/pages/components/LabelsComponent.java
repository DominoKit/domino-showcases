package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixLabelsProxyModule_;
import org.dominokit.pages.presenters.samples.components.LabelsProxy;
import org.dominokit.pages.presenters.samples.components.LabelsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.labels.BrixLabelsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = LabelsProxy.class)
@Component(
    modules = {
        BrixLabelsProxyModule_.class,
        BrixLabelsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LabelsComponent
    extends IsBrixComponent, HasPresenterProvider<LabelsProxyProvider> {

  ComponentProvider<LabelsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LabelsComponent newInstance() {
          return DaggerLabelsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
