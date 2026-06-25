package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.forms.BrixFileUploadProxyModule_;
import org.dominokit.pages.presenters.samples.forms.FileUploadProxy;
import org.dominokit.pages.presenters.samples.forms.FileUploadProxyProvider;
import org.dominokit.pages.ui.views.samples.forms.input.BrixFileUploadViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = FileUploadProxy.class)
@Component(
    modules = {
        BrixFileUploadProxyModule_.class,
        BrixFileUploadViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FileUploadComponent
    extends IsBrixComponent, HasPresenterProvider<FileUploadProxyProvider> {

  ComponentProvider<FileUploadComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FileUploadComponent newInstance() {
          return DaggerFileUploadComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
