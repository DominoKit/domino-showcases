package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ImportBackedDataEntryFormSample {

  private ImportBackedDataEntryFormSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Import-backed data-entry form",
        "Layout: Manual entry form is paired with upload/import controls and a preview of parsed values. Interaction: Users upload, map, validate, correct, and commit imported data. Variants: CSV, spreadsheet, pasted rows, or API payload preview.",
        BlueprintSampleKind.FORM,
        "Manual entry form is paired with upload/import controls and a preview of parsed values.", "Users upload, map, validate, correct, and commit imported data.");
  }
}
