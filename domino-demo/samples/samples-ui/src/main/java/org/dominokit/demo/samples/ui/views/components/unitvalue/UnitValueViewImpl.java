package org.dominokit.demo.samples.ui.views.components.unitvalue;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.components.unitvalue.UnitValueView;
import org.dominokit.showcases.samples.components.unitvalue.UnitValueSample;

@UiView
public class UnitValueViewImpl extends SamplePageView<UnitValueView.UnitValueUiHandlers>
    implements UnitValueView {

  @Inject
  public UnitValueViewImpl() {
    super(
        "Unit value",
        "Display pre-formatted values with optional units, symbols, titles, descriptions, and layouts.");
    addSample(UnitValueSample.class, UnitValueSample::create);
    initPage();
  }
}
