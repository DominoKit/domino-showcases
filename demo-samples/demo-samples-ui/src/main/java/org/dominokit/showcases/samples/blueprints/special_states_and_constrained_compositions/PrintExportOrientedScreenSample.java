package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class PrintExportOrientedScreenSample {

  private PrintExportOrientedScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Print/export-oriented screen",
        "Layout: Screen prioritizes a stable document-like hierarchy, print controls, and export metadata over interactive chrome. Interaction: Users preview, print, download, or select output options. Variants: Invoice, report, certificate, or audit evidence.",
        BlueprintSampleKind.STATE,
        "Screen prioritizes a stable document-like hierarchy, print controls, and export metadata over interactive chrome.", "Users preview, print, download, or select output options.");
  }
}
