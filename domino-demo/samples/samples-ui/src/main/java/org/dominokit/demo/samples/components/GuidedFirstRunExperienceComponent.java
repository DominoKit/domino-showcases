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
import org.dominokit.demo.samples.presenters.blueprints.BrixGuidedFirstRunExperiencePresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.GuidedFirstRunExperiencePresenter;
import org.dominokit.demo.samples.presenters.blueprints.GuidedFirstRunExperiencePresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixGuidedFirstRunExperienceViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = GuidedFirstRunExperiencePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixGuidedFirstRunExperiencePresenterModule_.class,
        BrixGuidedFirstRunExperienceViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface GuidedFirstRunExperienceComponent
    extends IsBrixComponent, HasPresenterProvider<GuidedFirstRunExperiencePresenterProvider> {

  ComponentProvider<GuidedFirstRunExperienceComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected GuidedFirstRunExperienceComponent newInstance() {
          return DaggerGuidedFirstRunExperienceComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
