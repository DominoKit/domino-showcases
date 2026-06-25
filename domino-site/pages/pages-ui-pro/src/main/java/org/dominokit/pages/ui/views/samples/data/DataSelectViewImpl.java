package org.dominokit.pages.ui.views.samples.data;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.pages.views.DataSelectView;
import org.dominokit.showcases.samples.data.DataSelectSample;

@UiView
public class DataSelectViewImpl extends BrixView<HTMLDivElement, DataSelectView.DataSelectUiHandlers>
    implements DataSelectView {

  private final DataSelectSample dataSelectSample;

  @Inject
  public DataSelectViewImpl() {
    this.dataSelectSample = DataSelectSample.create();
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return dataSelectSample.element();
  }
}
