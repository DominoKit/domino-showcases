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
import org.dominokit.demo.samples.presenters.blueprints.BrixDataQualityScorecardPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.DataQualityScorecardPresenter;
import org.dominokit.demo.samples.presenters.blueprints.DataQualityScorecardPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixDataQualityScorecardViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DataQualityScorecardPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDataQualityScorecardPresenterModule_.class,
        BrixDataQualityScorecardViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DataQualityScorecardComponent
    extends IsBrixComponent, HasPresenterProvider<DataQualityScorecardPresenterProvider> {

  ComponentProvider<DataQualityScorecardComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DataQualityScorecardComponent newInstance() {
          return DaggerDataQualityScorecardComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
