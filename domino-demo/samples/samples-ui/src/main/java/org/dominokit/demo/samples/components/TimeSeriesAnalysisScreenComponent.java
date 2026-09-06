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
import org.dominokit.demo.samples.presenters.blueprints.BrixTimeSeriesAnalysisScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.TimeSeriesAnalysisScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.TimeSeriesAnalysisScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixTimeSeriesAnalysisScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TimeSeriesAnalysisScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTimeSeriesAnalysisScreenPresenterModule_.class,
        BrixTimeSeriesAnalysisScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TimeSeriesAnalysisScreenComponent
    extends IsBrixComponent, HasPresenterProvider<TimeSeriesAnalysisScreenPresenterProvider> {

  ComponentProvider<TimeSeriesAnalysisScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TimeSeriesAnalysisScreenComponent newInstance() {
          return DaggerTimeSeriesAnalysisScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
