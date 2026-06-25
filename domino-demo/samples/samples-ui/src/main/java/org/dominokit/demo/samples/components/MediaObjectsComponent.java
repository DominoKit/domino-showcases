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
import org.dominokit.demo.samples.presenters.components.BrixMediaObjectsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.MediaObjectsPresenter;
import org.dominokit.demo.samples.presenters.components.MediaObjectsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.media.BrixMediaObjectsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MediaObjectsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMediaObjectsPresenterModule_.class,
        BrixMediaObjectsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MediaObjectsComponent
    extends IsBrixComponent, HasPresenterProvider<MediaObjectsPresenterProvider> {

  ComponentProvider<MediaObjectsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MediaObjectsComponent newInstance() {
          return DaggerMediaObjectsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
