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
import org.dominokit.demo.samples.presenters.blueprints.BrixMasterDetailWithPersistentRecordListPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.MasterDetailWithPersistentRecordListPresenter;
import org.dominokit.demo.samples.presenters.blueprints.MasterDetailWithPersistentRecordListPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces.BrixMasterDetailWithPersistentRecordListViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MasterDetailWithPersistentRecordListPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMasterDetailWithPersistentRecordListPresenterModule_.class,
        BrixMasterDetailWithPersistentRecordListViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MasterDetailWithPersistentRecordListComponent
    extends IsBrixComponent, HasPresenterProvider<MasterDetailWithPersistentRecordListPresenterProvider> {

  ComponentProvider<MasterDetailWithPersistentRecordListComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MasterDetailWithPersistentRecordListComponent newInstance() {
          return DaggerMasterDetailWithPersistentRecordListComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
