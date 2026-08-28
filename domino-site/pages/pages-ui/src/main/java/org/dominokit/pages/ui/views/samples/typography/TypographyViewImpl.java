package org.dominokit.pages.ui.views.samples.typography;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.typography.*;

@UiView
public class TypographyViewImpl extends SampleViewImpl {
    @Inject
    public TypographyViewImpl() {
        register(DemoSample.of("typography-lead", TypographyLeadSample.class, LazyProvider.of(TypographyLeadSample::create)));
        register(DemoSample.of("typography-heading", TypographyHeadingSample.class, LazyProvider.of(TypographyHeadingSample::create)));
        register(DemoSample.of("typography-styles", TypographyStylesSample.class, LazyProvider.of(TypographyStylesSample::create)));
        register(DemoSample.of("typography-blockquotes", TypographyBlockquotesSample.class, LazyProvider.of(TypographyBlockquotesSample::create)));
        register(DemoSample.of("typography-lists", TypographyListsSample.class, LazyProvider.of(TypographyListsSample::create)));
        register(DemoSample.of("typography-font-size", TypographyFontSizeSample.class, LazyProvider.of(TypographyFontSizeSample::create)));
        register(DemoSample.of("typography-font-theming", FontThemingSample.class, LazyProvider.of(FontThemingSample::create)));
    }
}
