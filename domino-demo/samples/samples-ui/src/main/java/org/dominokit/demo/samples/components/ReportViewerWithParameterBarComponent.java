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
import org.dominokit.demo.samples.presenters.blueprints.BrixReportViewerWithParameterBarPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ReportViewerWithParameterBarPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ReportViewerWithParameterBarPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixReportViewerWithParameterBarViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ReportViewerWithParameterBarPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixReportViewerWithParameterBarPresenterModule_.class,
        BrixReportViewerWithParameterBarViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ReportViewerWithParameterBarComponent
    extends IsBrixComponent, HasPresenterProvider<ReportViewerWithParameterBarPresenterProvider> {

  ComponentProvider<ReportViewerWithParameterBarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ReportViewerWithParameterBarComponent newInstance() {
          return DaggerReportViewerWithParameterBarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
