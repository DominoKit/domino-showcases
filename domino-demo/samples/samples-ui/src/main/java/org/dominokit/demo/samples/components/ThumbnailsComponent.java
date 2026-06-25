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
import org.dominokit.demo.samples.presenters.components.BrixThumbnailsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.ThumbnailsPresenter;
import org.dominokit.demo.samples.presenters.components.ThumbnailsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.thumbnails.BrixThumbnailsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ThumbnailsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixThumbnailsPresenterModule_.class,
        BrixThumbnailsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ThumbnailsComponent
    extends IsBrixComponent, HasPresenterProvider<ThumbnailsPresenterProvider> {

  ComponentProvider<ThumbnailsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ThumbnailsComponent newInstance() {
          return DaggerThumbnailsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
