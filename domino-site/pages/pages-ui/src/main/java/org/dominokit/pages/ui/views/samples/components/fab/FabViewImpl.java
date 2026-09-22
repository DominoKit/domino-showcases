package org.dominokit.pages.ui.views.samples.components.fab;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.fab.FabSample;

@UiView
public class FabViewImpl extends SampleViewImpl {

  @Inject
  public FabViewImpl() {
    register(DemoSample.of("fab-overview", FabSample.class, LazyProvider.of(FabSample::create)));
  }
}
