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
import org.dominokit.demo.samples.presenters.blueprints.BrixMultiRecordComparisonWorkspacePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.MultiRecordComparisonWorkspacePresenter;
import org.dominokit.demo.samples.presenters.blueprints.MultiRecordComparisonWorkspacePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces.BrixMultiRecordComparisonWorkspaceViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MultiRecordComparisonWorkspacePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMultiRecordComparisonWorkspacePresenterModule_.class,
        BrixMultiRecordComparisonWorkspaceViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MultiRecordComparisonWorkspaceComponent
    extends IsBrixComponent, HasPresenterProvider<MultiRecordComparisonWorkspacePresenterProvider> {

  ComponentProvider<MultiRecordComparisonWorkspaceComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MultiRecordComparisonWorkspaceComponent newInstance() {
          return DaggerMultiRecordComparisonWorkspaceComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
