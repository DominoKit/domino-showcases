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
import org.dominokit.demo.samples.presenters.blueprints.BrixReportBuilderPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ReportBuilderPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ReportBuilderPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixReportBuilderViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ReportBuilderPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixReportBuilderPresenterModule_.class,
        BrixReportBuilderViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ReportBuilderComponent
    extends IsBrixComponent, HasPresenterProvider<ReportBuilderPresenterProvider> {

  ComponentProvider<ReportBuilderComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ReportBuilderComponent newInstance() {
          return DaggerReportBuilderComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
