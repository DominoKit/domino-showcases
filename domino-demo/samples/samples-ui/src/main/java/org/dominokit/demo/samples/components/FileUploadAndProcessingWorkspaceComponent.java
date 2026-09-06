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
import org.dominokit.demo.samples.presenters.blueprints.BrixFileUploadAndProcessingWorkspacePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.FileUploadAndProcessingWorkspacePresenter;
import org.dominokit.demo.samples.presenters.blueprints.FileUploadAndProcessingWorkspacePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration.BrixFileUploadAndProcessingWorkspaceViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FileUploadAndProcessingWorkspacePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFileUploadAndProcessingWorkspacePresenterModule_.class,
        BrixFileUploadAndProcessingWorkspaceViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FileUploadAndProcessingWorkspaceComponent
    extends IsBrixComponent, HasPresenterProvider<FileUploadAndProcessingWorkspacePresenterProvider> {

  ComponentProvider<FileUploadAndProcessingWorkspaceComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FileUploadAndProcessingWorkspaceComponent newInstance() {
          return DaggerFileUploadAndProcessingWorkspaceComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
