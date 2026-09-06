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
import org.dominokit.demo.samples.presenters.blueprints.BrixKpiDashboardWithResponsiveCardGridPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.KpiDashboardWithResponsiveCardGridPresenter;
import org.dominokit.demo.samples.presenters.blueprints.KpiDashboardWithResponsiveCardGridPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens.BrixKpiDashboardWithResponsiveCardGridViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = KpiDashboardWithResponsiveCardGridPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixKpiDashboardWithResponsiveCardGridPresenterModule_.class,
        BrixKpiDashboardWithResponsiveCardGridViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface KpiDashboardWithResponsiveCardGridComponent
    extends IsBrixComponent, HasPresenterProvider<KpiDashboardWithResponsiveCardGridPresenterProvider> {

  ComponentProvider<KpiDashboardWithResponsiveCardGridComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected KpiDashboardWithResponsiveCardGridComponent newInstance() {
          return DaggerKpiDashboardWithResponsiveCardGridComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
