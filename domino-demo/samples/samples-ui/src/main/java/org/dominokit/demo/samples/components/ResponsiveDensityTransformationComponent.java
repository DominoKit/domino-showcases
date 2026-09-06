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
import org.dominokit.demo.samples.presenters.blueprints.BrixResponsiveDensityTransformationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ResponsiveDensityTransformationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ResponsiveDensityTransformationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixResponsiveDensityTransformationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ResponsiveDensityTransformationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixResponsiveDensityTransformationPresenterModule_.class,
        BrixResponsiveDensityTransformationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ResponsiveDensityTransformationComponent
    extends IsBrixComponent, HasPresenterProvider<ResponsiveDensityTransformationPresenterProvider> {

  ComponentProvider<ResponsiveDensityTransformationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ResponsiveDensityTransformationComponent newInstance() {
          return DaggerResponsiveDensityTransformationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
