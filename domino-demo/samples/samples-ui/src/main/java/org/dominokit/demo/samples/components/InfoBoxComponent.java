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
import org.dominokit.demo.samples.presenters.components.BrixInfoBoxPresenterModule_;
import org.dominokit.demo.samples.presenters.components.InfoBoxPresenter;
import org.dominokit.demo.samples.presenters.components.InfoBoxPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.infobox.BrixInfoBoxViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = InfoBoxPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixInfoBoxPresenterModule_.class,
        BrixInfoBoxViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface InfoBoxComponent
    extends IsBrixComponent, HasPresenterProvider<InfoBoxPresenterProvider> {

  ComponentProvider<InfoBoxComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected InfoBoxComponent newInstance() {
          return DaggerInfoBoxComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
