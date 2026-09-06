package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.RichContentEditorView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.RichContentEditorSample;

@UiView
public class RichContentEditorViewImpl extends BlueprintSamplePageView<RichContentEditorView.RichContentEditorUiHandlers>
    implements RichContentEditorView {

  @Inject
  public RichContentEditorViewImpl() {
    super("Rich content editor", "Layout: Editor canvas with formatting toolbar, metadata panel, preview, and publish controls. Interaction: Users draft, format, insert media, preview, autosave, and publish or schedule content. Variants: Knowledge article, email template, announcement, or policy document.");
    addSample("Rich content editor", "Layout: Editor canvas with formatting toolbar, metadata panel, preview, and publish controls. Interaction: Users draft, format, insert media, preview, autosave, and publish or schedule content. Variants: Knowledge article, email template, announcement, or policy document.", RichContentEditorSample.class, RichContentEditorSample::create);
    initPage();
  }
}
