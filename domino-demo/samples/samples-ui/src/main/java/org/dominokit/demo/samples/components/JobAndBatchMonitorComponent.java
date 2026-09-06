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
import org.dominokit.demo.samples.presenters.blueprints.BrixJobAndBatchMonitorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.JobAndBatchMonitorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.JobAndBatchMonitorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixJobAndBatchMonitorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = JobAndBatchMonitorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixJobAndBatchMonitorPresenterModule_.class,
        BrixJobAndBatchMonitorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface JobAndBatchMonitorComponent
    extends IsBrixComponent, HasPresenterProvider<JobAndBatchMonitorPresenterProvider> {

  ComponentProvider<JobAndBatchMonitorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected JobAndBatchMonitorComponent newInstance() {
          return DaggerJobAndBatchMonitorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
