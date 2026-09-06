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
import org.dominokit.demo.samples.presenters.blueprints.BrixDashboardWithCommentaryAndAnnotationsPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.DashboardWithCommentaryAndAnnotationsPresenter;
import org.dominokit.demo.samples.presenters.blueprints.DashboardWithCommentaryAndAnnotationsPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens.BrixDashboardWithCommentaryAndAnnotationsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DashboardWithCommentaryAndAnnotationsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDashboardWithCommentaryAndAnnotationsPresenterModule_.class,
        BrixDashboardWithCommentaryAndAnnotationsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DashboardWithCommentaryAndAnnotationsComponent
    extends IsBrixComponent, HasPresenterProvider<DashboardWithCommentaryAndAnnotationsPresenterProvider> {

  ComponentProvider<DashboardWithCommentaryAndAnnotationsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DashboardWithCommentaryAndAnnotationsComponent newInstance() {
          return DaggerDashboardWithCommentaryAndAnnotationsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
