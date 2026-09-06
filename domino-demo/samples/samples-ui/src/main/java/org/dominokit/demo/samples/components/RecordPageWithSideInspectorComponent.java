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
import org.dominokit.demo.samples.presenters.blueprints.BrixRecordPageWithSideInspectorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.RecordPageWithSideInspectorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.RecordPageWithSideInspectorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces.BrixRecordPageWithSideInspectorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RecordPageWithSideInspectorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRecordPageWithSideInspectorPresenterModule_.class,
        BrixRecordPageWithSideInspectorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RecordPageWithSideInspectorComponent
    extends IsBrixComponent, HasPresenterProvider<RecordPageWithSideInspectorPresenterProvider> {

  ComponentProvider<RecordPageWithSideInspectorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RecordPageWithSideInspectorComponent newInstance() {
          return DaggerRecordPageWithSideInspectorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
