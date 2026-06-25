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
import org.dominokit.demo.samples.presenters.components.BrixLabelsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.LabelsPresenter;
import org.dominokit.demo.samples.presenters.components.LabelsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.labels.BrixLabelsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = LabelsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixLabelsPresenterModule_.class,
        BrixLabelsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LabelsComponent
    extends IsBrixComponent, HasPresenterProvider<LabelsPresenterProvider> {

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
