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
import org.dominokit.demo.samples.presenters.blueprints.BrixRecordSplitViewWithPreviewAndEditModesPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.RecordSplitViewWithPreviewAndEditModesPresenter;
import org.dominokit.demo.samples.presenters.blueprints.RecordSplitViewWithPreviewAndEditModesPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces.BrixRecordSplitViewWithPreviewAndEditModesViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RecordSplitViewWithPreviewAndEditModesPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRecordSplitViewWithPreviewAndEditModesPresenterModule_.class,
        BrixRecordSplitViewWithPreviewAndEditModesViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RecordSplitViewWithPreviewAndEditModesComponent
    extends IsBrixComponent, HasPresenterProvider<RecordSplitViewWithPreviewAndEditModesPresenterProvider> {

  ComponentProvider<RecordSplitViewWithPreviewAndEditModesComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RecordSplitViewWithPreviewAndEditModesComponent newInstance() {
          return DaggerRecordSplitViewWithPreviewAndEditModesComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
