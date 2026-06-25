package org.dominokit.pages.ui.views.samples.data;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.pages.views.DataListView;
import org.dominokit.showcases.samples.data.DataListSample;

@UiView
public class DataListViewImpl extends BrixView<HTMLDivElement, DataListView.DataListUiHandlers>
    implements DataListView {

  private final DataListSample dataListSample;

  @Inject
  public DataListViewImpl() {
    this.dataListSample = DataListSample.create();
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return dataListSample.element();
  }
}
