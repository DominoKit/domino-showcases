package org.dominokit.demo.samples.ui.views.components.infobox;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.infobox.InfoBoxView;
        import org.dominokit.showcases.samples.components.infobox.BasicInfoBoxSample;
import org.dominokit.showcases.samples.components.infobox.HoverInfoBoxSample;
import org.dominokit.showcases.samples.components.infobox.RightAlignedInfoBoxSample;

        @UiView
        public class InfoBoxViewImpl extends SamplePageView<InfoBoxView.InfoBoxUiHandlers>
            implements InfoBoxView {

          @Inject
          public InfoBoxViewImpl() {
            super("Info Box", "Info Box examples rendered from the shared demo-samples module.");
    addSample(BasicInfoBoxSample.class, BasicInfoBoxSample::create);
    addSample(HoverInfoBoxSample.class, HoverInfoBoxSample::create);
    addSample(RightAlignedInfoBoxSample.class, RightAlignedInfoBoxSample::create);
            initPage();
          }
        }
