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
import org.dominokit.demo.samples.presenters.blueprints.BrixScheduledReportManagementPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ScheduledReportManagementPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ScheduledReportManagementPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixScheduledReportManagementViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ScheduledReportManagementPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixScheduledReportManagementPresenterModule_.class,
        BrixScheduledReportManagementViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ScheduledReportManagementComponent
    extends IsBrixComponent, HasPresenterProvider<ScheduledReportManagementPresenterProvider> {

  ComponentProvider<ScheduledReportManagementComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ScheduledReportManagementComponent newInstance() {
          return DaggerScheduledReportManagementComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
