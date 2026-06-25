package org.dominokit.pages.ui.views.samples.components.richtext;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.richtext.*;

@UiView
public class RichTextEditorViewImpl extends SampleViewImpl {
    @Inject
    public RichTextEditorViewImpl() {
        register(DemoSample.of("rich-text-editor-basic", RichTextEditorSample.class, LazyProvider.of(RichTextEditorSample::create)));
    }
}