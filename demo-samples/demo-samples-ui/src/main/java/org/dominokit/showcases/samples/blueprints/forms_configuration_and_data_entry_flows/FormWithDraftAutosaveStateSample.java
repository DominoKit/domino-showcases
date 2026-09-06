package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class FormWithDraftAutosaveStateSample {

  private FormWithDraftAutosaveStateSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Form with draft/autosave state",
        "Layout: Standard form plus visible draft status, last-saved time, and recovery controls. Interaction: Users edit continuously, recover a draft, manually save, or discard it. Variants: Local draft, server draft, multi-user draft, or offline-capable form.",
        BlueprintSampleKind.FORM,
        "Standard form plus visible draft status, last-saved time, and recovery controls.", "Users edit continuously, recover a draft, manually save, or discard it.");
  }
}
