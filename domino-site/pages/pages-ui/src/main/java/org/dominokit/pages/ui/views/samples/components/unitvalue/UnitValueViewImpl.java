package org.dominokit.pages.ui.views.samples.components.unitvalue;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.unitvalue.UnitValueSample;

@UiView
public class UnitValueViewImpl extends SampleViewImpl {

  @Inject
  public UnitValueViewImpl() {
    register(
        DemoSample.of(
            "unit-value-overview", UnitValueSample.class, LazyProvider.of(UnitValueSample::create)));
  }
}
