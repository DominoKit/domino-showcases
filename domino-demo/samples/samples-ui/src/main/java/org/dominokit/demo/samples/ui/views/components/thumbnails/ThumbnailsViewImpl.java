package org.dominokit.demo.samples.ui.views.components.thumbnails;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.thumbnails.ThumbnailsView;
        import org.dominokit.showcases.samples.components.thumbnails.BasicThumbnailsSample;
import org.dominokit.showcases.samples.components.thumbnails.ThumbnailsContentSample;
import org.dominokit.showcases.samples.components.thumbnails.ThumbnailsTitleSample;
import org.dominokit.showcases.samples.components.thumbnails.DetailedThumbnailsSample;

        @UiView
        public class ThumbnailsViewImpl extends SamplePageView<ThumbnailsView.ThumbnailsUiHandlers>
            implements ThumbnailsView {

          @Inject
          public ThumbnailsViewImpl() {
            super("Thumbnails", "Thumbnails examples rendered from the shared demo-samples module.");
    addSample(BasicThumbnailsSample.class, BasicThumbnailsSample::create);
    addSample(ThumbnailsContentSample.class, ThumbnailsContentSample::create);
    addSample(ThumbnailsTitleSample.class, ThumbnailsTitleSample::create);
    addSample(DetailedThumbnailsSample.class, DetailedThumbnailsSample::create);
            initPage();
          }
        }
