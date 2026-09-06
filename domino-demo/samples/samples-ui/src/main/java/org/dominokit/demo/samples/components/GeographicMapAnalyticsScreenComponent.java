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
import org.dominokit.demo.samples.presenters.blueprints.BrixGeographicMapAnalyticsScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.GeographicMapAnalyticsScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.GeographicMapAnalyticsScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixGeographicMapAnalyticsScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = GeographicMapAnalyticsScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixGeographicMapAnalyticsScreenPresenterModule_.class,
        BrixGeographicMapAnalyticsScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface GeographicMapAnalyticsScreenComponent
    extends IsBrixComponent, HasPresenterProvider<GeographicMapAnalyticsScreenPresenterProvider> {

  ComponentProvider<GeographicMapAnalyticsScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected GeographicMapAnalyticsScreenComponent newInstance() {
          return DaggerGeographicMapAnalyticsScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
