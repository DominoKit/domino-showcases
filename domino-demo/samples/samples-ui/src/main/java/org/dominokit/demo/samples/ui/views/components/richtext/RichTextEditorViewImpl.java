package org.dominokit.demo.samples.ui.views.components.richtext;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.components.richtext.RichTextEditorView;
import org.dominokit.showcases.samples.components.richtext.RichTextEditorSample;

@UiView
public class RichTextEditorViewImpl
    extends SamplePageView<RichTextEditorView.RichTextEditorUiHandlers>
    implements RichTextEditorView {

  @Inject
  public RichTextEditorViewImpl() {
    super(
        "Rich Text Editor",
        "Rich Text Editor examples rendered from the shared demo-samples module.");
    addSample("Basic rich text editor", RichTextEditorSample.class, RichTextEditorSample::create);
    initPage();
  }
}
