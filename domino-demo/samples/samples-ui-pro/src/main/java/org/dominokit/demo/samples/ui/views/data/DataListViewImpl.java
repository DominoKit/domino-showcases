package org.dominokit.demo.samples.ui.views.data;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.data.DataListView;
import org.dominokit.showcases.samples.data.DataListSample;

@UiView
public class DataListViewImpl extends SamplePageView<DataListView.DataListUiHandlers>
    implements DataListView {

  private final DataListSample dataListSample;

  @Inject
  public DataListViewImpl() {
    super("Data list", "Virtualized list examples shared between the demo and the docs site.");
    this.dataListSample = DataListSample.create();
    root.appendChild(dataListSample);
    initPage();
  }
}
