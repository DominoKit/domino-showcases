package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.PrintExportOrientedScreenView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.PrintExportOrientedScreenSample;

@UiView
public class PrintExportOrientedScreenViewImpl extends SamplePageView<PrintExportOrientedScreenView.PrintExportOrientedScreenUiHandlers>
    implements PrintExportOrientedScreenView {

  @Inject
  public PrintExportOrientedScreenViewImpl() {
    super("Print/export-oriented screen", "Layout: Screen prioritizes a stable document-like hierarchy, print controls, and export metadata over interactive chrome. Interaction: Users preview, print, download, or select output options. Variants: Invoice, report, certificate, or audit evidence.");
    addSample("Print/export-oriented screen", "Layout: Screen prioritizes a stable document-like hierarchy, print controls, and export metadata over interactive chrome. Interaction: Users preview, print, download, or select output options. Variants: Invoice, report, certificate, or audit evidence.", PrintExportOrientedScreenSample.class, PrintExportOrientedScreenSample::create);
    initPage();
  }
}
