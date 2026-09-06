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
import org.dominokit.demo.samples.presenters.blueprints.BrixAdHocPivotAnalysisPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.AdHocPivotAnalysisPresenter;
import org.dominokit.demo.samples.presenters.blueprints.AdHocPivotAnalysisPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixAdHocPivotAnalysisViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AdHocPivotAnalysisPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAdHocPivotAnalysisPresenterModule_.class,
        BrixAdHocPivotAnalysisViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AdHocPivotAnalysisComponent
    extends IsBrixComponent, HasPresenterProvider<AdHocPivotAnalysisPresenterProvider> {

  ComponentProvider<AdHocPivotAnalysisComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AdHocPivotAnalysisComponent newInstance() {
          return DaggerAdHocPivotAnalysisComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
