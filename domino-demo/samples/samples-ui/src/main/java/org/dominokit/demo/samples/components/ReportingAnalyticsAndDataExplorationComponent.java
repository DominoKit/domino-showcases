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
import org.dominokit.demo.samples.presenters.blueprints.BrixReportingAnalyticsAndDataExplorationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ReportingAnalyticsAndDataExplorationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ReportingAnalyticsAndDataExplorationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixReportingAnalyticsAndDataExplorationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ReportingAnalyticsAndDataExplorationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixReportingAnalyticsAndDataExplorationPresenterModule_.class,
      BrixReportingAnalyticsAndDataExplorationViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface ReportingAnalyticsAndDataExplorationComponent
    extends IsBrixComponent, HasPresenterProvider<ReportingAnalyticsAndDataExplorationPresenterProvider> {

  ComponentProvider<ReportingAnalyticsAndDataExplorationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ReportingAnalyticsAndDataExplorationComponent newInstance() {
          return DaggerReportingAnalyticsAndDataExplorationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
