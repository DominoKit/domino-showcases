package org.dominokit.pages.ui.views.samples.helpers.dynamiccss;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.helpers.dynamiccss.DynamicCssColorSample;
import org.dominokit.showcases.samples.helpers.dynamiccss.DynamicCssLayoutSample;

@UiView
public class DynamicCssViewImpl extends SampleViewImpl {

  @Inject
  public DynamicCssViewImpl() {
    register(
        DemoSample.of(
            "dynamic-css-layout",
            DynamicCssLayoutSample.class,
            LazyProvider.of(DynamicCssLayoutSample::create)));
    register(
        DemoSample.of(
            "dynamic-css-colors",
            DynamicCssColorSample.class,
            LazyProvider.of(DynamicCssColorSample::create)));
  }
}
