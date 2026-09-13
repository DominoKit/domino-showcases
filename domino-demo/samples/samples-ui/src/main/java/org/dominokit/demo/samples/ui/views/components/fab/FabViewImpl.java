package org.dominokit.demo.samples.ui.views.components.fab;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.components.SampleCodeCard;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.components.fab.FabView;
import org.dominokit.showcases.samples.components.fab.FabSample;

@UiView
public class FabViewImpl extends SamplePageView<FabView.FabUiHandlers> implements FabView {

  @Inject
  public FabViewImpl() {
    super("Floating action buttons", "Single-button and expandable floating action button examples.");
    root.appendChild(FabSample.create()).appendChild(SampleCodeCard.create(FabSample.class));
    initPage();
  }
}
