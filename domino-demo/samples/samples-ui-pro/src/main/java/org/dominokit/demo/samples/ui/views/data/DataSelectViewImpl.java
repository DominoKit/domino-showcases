package org.dominokit.demo.samples.ui.views.data;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.data.DataSelectView;
import org.dominokit.showcases.samples.data.DataSelectSample;

@UiView
public class DataSelectViewImpl extends SamplePageView<DataSelectView.DataSelectUiHandlers>
    implements DataSelectView {

  private final DataSelectSample dataSelectSample;

  @Inject
  public DataSelectViewImpl() {
    super("Data select", "Virtualized selection examples shared between the demo and the docs site.");
    this.dataSelectSample = DataSelectSample.create();
    root.appendChild(dataSelectSample);
    initPage();
  }
}
