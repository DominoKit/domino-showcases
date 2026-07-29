package org.dominokit.pages.ui.views.samples.components.markdown;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.markdown.MarkdownBindingSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownClassStylingSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownEditorSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownPlaygroundSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownPreviewSample;
import org.dominokit.showcases.samples.components.markdown.MarkdownSplitEditorSample;

@UiView
public class MarkdownViewImpl extends SampleViewImpl {

    @Inject
    public MarkdownViewImpl() {
        register(DemoSample.of("markdown-editor", MarkdownEditorSample.class, LazyProvider.of(MarkdownEditorSample::create)));
        register(DemoSample.of("markdown-preview", MarkdownPreviewSample.class, LazyProvider.of(MarkdownPreviewSample::create)));
        register(DemoSample.of("markdown-split", MarkdownSplitEditorSample.class, LazyProvider.of(MarkdownSplitEditorSample::create)));
        register(DemoSample.of("markdown-binding", MarkdownBindingSample.class, LazyProvider.of(MarkdownBindingSample::create)));
        register(DemoSample.of("markdown-playground", MarkdownPlaygroundSample.class, LazyProvider.of(MarkdownPlaygroundSample::create)));
        register(DemoSample.of("markdown-class-styling", MarkdownClassStylingSample.class, LazyProvider.of(MarkdownClassStylingSample::create)));
    }
}
