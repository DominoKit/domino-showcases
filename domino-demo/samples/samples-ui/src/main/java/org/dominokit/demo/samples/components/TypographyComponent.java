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
import org.dominokit.demo.samples.presenters.typography.BrixTypographyPresenterModule_;
import org.dominokit.demo.samples.presenters.typography.TypographyPresenter;
import org.dominokit.demo.samples.presenters.typography.TypographyPresenterProvider;
import org.dominokit.demo.samples.ui.views.typography.BrixTypographyViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TypographyPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTypographyPresenterModule_.class,
        BrixTypographyViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TypographyComponent
    extends IsBrixComponent, HasPresenterProvider<TypographyPresenterProvider> {

  ComponentProvider<TypographyComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TypographyComponent newInstance() {
          return DaggerTypographyComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
