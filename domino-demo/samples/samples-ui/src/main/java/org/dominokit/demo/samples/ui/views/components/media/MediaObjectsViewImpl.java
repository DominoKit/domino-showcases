package org.dominokit.demo.samples.ui.views.components.media;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.media.MediaObjectsView;
        import org.dominokit.showcases.samples.components.media.MediaObjectsBasicSample;
import org.dominokit.showcases.samples.components.media.MediaObjectsAlignmentSample;

        @UiView
        public class MediaObjectsViewImpl extends SamplePageView<MediaObjectsView.MediaObjectsUiHandlers>
            implements MediaObjectsView {

          @Inject
          public MediaObjectsViewImpl() {
            super("Media Objects", "Media Objects examples rendered from the shared demo-samples module.");
    addSample(MediaObjectsBasicSample.class, MediaObjectsBasicSample::create);
    addSample(MediaObjectsAlignmentSample.class, MediaObjectsAlignmentSample::create);
            initPage();
          }
        }
