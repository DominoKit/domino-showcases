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
import org.dominokit.demo.samples.presenters.blueprints.BrixRecordPageWithActivityTimelinePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.RecordPageWithActivityTimelinePresenter;
import org.dominokit.demo.samples.presenters.blueprints.RecordPageWithActivityTimelinePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces.BrixRecordPageWithActivityTimelineViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RecordPageWithActivityTimelinePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRecordPageWithActivityTimelinePresenterModule_.class,
        BrixRecordPageWithActivityTimelineViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RecordPageWithActivityTimelineComponent
    extends IsBrixComponent, HasPresenterProvider<RecordPageWithActivityTimelinePresenterProvider> {

  ComponentProvider<RecordPageWithActivityTimelineComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RecordPageWithActivityTimelineComponent newInstance() {
          return DaggerRecordPageWithActivityTimelineComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
