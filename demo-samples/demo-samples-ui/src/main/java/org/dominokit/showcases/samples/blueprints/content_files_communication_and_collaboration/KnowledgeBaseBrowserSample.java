package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class KnowledgeBaseBrowserSample {

  private KnowledgeBaseBrowserSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Knowledge base browser",
        "Layout: Category navigation, search, article list, and reading pane. Interaction: Users search, browse categories, bookmark, rate, report outdated content, and follow related articles. Variants: Public help center, internal knowledge base, or contextual help drawer.",
        BlueprintSampleKind.CONTENT,
        "Category navigation, search, article list, and reading pane.", "Users search, browse categories, bookmark, rate, report outdated content, and follow related articles.");
  }
}
