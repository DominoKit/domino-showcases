package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RepeatableCollectionFormSample {

  private RepeatableCollectionFormSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Repeatable collection form",
        "Layout: One parent form contains repeatable child rows/cards or nested subforms. Interaction: Users add, remove, reorder, and validate child entries before saving the parent. Variants: Line items, addresses, contacts, or rule clauses.",
        BlueprintSampleKind.FORM,
        "One parent form contains repeatable child rows/cards or nested subforms.", "Users add, remove, reorder, and validate child entries before saving the parent.");
  }
}
