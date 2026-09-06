package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RichContentEditorSample {

  private RichContentEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Rich content editor",
        "Layout: Editor canvas with formatting toolbar, metadata panel, preview, and publish controls. Interaction: Users draft, format, insert media, preview, autosave, and publish or schedule content. Variants: Knowledge article, email template, announcement, or policy document.",
        BlueprintSampleKind.CONTENT,
        "Editor canvas with formatting toolbar, metadata panel, preview, and publish controls.", "Users draft, format, insert media, preview, autosave, and publish or schedule content.");
  }
}
