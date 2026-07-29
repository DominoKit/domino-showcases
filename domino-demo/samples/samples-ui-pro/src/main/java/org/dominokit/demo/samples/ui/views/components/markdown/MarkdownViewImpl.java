package org.dominokit.demo.samples.ui.views.components.markdown;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.components.markdown.MarkdownView;
import org.dominokit.showcases.samples.components.markdown.MarkdownBindingSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownClassStylingSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownEditorSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownPlaygroundSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownPreviewSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownSplitEditorSample;

@UiView
public class MarkdownViewImpl extends SamplePageView<MarkdownView.MarkdownUiHandlers>
    implements MarkdownView {

  @Inject
  public MarkdownViewImpl() {
    super("Markdown", "Markdown examples rendered from the shared demo-samples module.");
    addSample(MarkdownEditorSample.class, MarkdownEditorSample::create);
    addSample(MarkdownPreviewSample.class, MarkdownPreviewSample::create);
    addSample(MarkdownSplitEditorSample.class, MarkdownSplitEditorSample::create);
    addSample(MarkdownBindingSample.class, MarkdownBindingSample::create);
    addSample(MarkdownPlaygroundSample.class, MarkdownPlaygroundSample::create);
    addSample(MarkdownClassStylingSample.class, MarkdownClassStylingSample::create);
    initPage();
  }
}
