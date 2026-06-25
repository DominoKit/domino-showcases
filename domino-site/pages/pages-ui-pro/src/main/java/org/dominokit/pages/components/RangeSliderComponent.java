package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixRangeSliderProxyModule_;
import org.dominokit.pages.presenters.samples.components.RangeSliderProxy;
import org.dominokit.pages.presenters.samples.components.RangeSliderProxyProvider;
import org.dominokit.pages.ui.views.samples.components.sliders.BrixRangeSlidersViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = RangeSliderProxy.class)
@Component(
    modules = {
        BrixRangeSliderProxyModule_.class,
        BrixRangeSlidersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RangeSliderComponent
    extends IsBrixComponent, HasPresenterProvider<RangeSliderProxyProvider> {

  ComponentProvider<RangeSliderComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RangeSliderComponent newInstance() {
          return DaggerRangeSliderComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
