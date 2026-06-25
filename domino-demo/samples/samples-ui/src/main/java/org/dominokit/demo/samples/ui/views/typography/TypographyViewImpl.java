package org.dominokit.demo.samples.ui.views.typography;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.typography.TypographyView;
        import org.dominokit.showcases.samples.typography.TypographyLeadSample;
import org.dominokit.showcases.samples.typography.TypographyHeadingSample;
import org.dominokit.showcases.samples.typography.TypographyStylesSample;
import org.dominokit.showcases.samples.typography.TypographyBlockquotesSample;
import org.dominokit.showcases.samples.typography.TypographyListsSample;
import org.dominokit.showcases.samples.typography.TypographyFontSizeSample;

        @UiView
        public class TypographyViewImpl extends SamplePageView<TypographyView.TypographyUiHandlers>
            implements TypographyView {

          @Inject
          public TypographyViewImpl() {
            super("Typography", "Typography examples rendered from the shared demo-samples module.");
    addSample(TypographyLeadSample.class, TypographyLeadSample::create);
    addSample(TypographyHeadingSample.class, TypographyHeadingSample::create);
    addSample(TypographyStylesSample.class, TypographyStylesSample::create);
    addSample(TypographyBlockquotesSample.class, TypographyBlockquotesSample::create);
    addSample(TypographyListsSample.class, TypographyListsSample::create);
    addSample(TypographyFontSizeSample.class, TypographyFontSizeSample::create);
            initPage();
          }
        }
