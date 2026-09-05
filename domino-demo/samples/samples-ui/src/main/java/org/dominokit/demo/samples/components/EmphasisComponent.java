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
import org.dominokit.demo.samples.presenters.emphasis.BrixEmphasisPresenterModule_;
import org.dominokit.demo.samples.presenters.emphasis.EmphasisPresenter;
import org.dominokit.demo.samples.presenters.emphasis.EmphasisPresenterProvider;
import org.dominokit.demo.samples.ui.views.emphasis.BrixEmphasisViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = EmphasisPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixEmphasisPresenterModule_.class,
      BrixEmphasisViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface EmphasisComponent
    extends IsBrixComponent, HasPresenterProvider<EmphasisPresenterProvider> {

  ComponentProvider<EmphasisComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EmphasisComponent newInstance() {
          return DaggerEmphasisComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
