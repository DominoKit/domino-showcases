package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class AdvancedSearchBuilderSample {

  private AdvancedSearchBuilderSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Advanced search builder",
        "Layout: Search-builder panel exposes field/operator/value rows above a result table. Interaction: Users add conditions, group them with AND/OR, save a search, preview results, and reset criteria. Variants: Basic/advanced toggle, visual query builder, or natural-language search paired with filters.",
        BlueprintSampleKind.CRUD,
        "Search-builder panel exposes field/operator/value rows above a result table.", "Users add conditions, group them with AND/OR, save a search, preview results, and reset criteria.");
  }
}
