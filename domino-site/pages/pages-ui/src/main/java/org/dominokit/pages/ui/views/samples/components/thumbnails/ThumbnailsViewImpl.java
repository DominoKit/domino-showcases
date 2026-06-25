package org.dominokit.pages.ui.views.samples.components.thumbnails;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.thumbnails.*;

@UiView
public class ThumbnailsViewImpl extends SampleViewImpl {
    @Inject
    public ThumbnailsViewImpl() {
        register(DemoSample.of("thumbnails-basic", BasicThumbnailsSample.class, LazyProvider.of(BasicThumbnailsSample::create)));
        register(DemoSample.of("thumbnails-content", ThumbnailsContentSample.class, LazyProvider.of(ThumbnailsContentSample::create)));
        register(DemoSample.of("thumbnails-title", ThumbnailsTitleSample.class, LazyProvider.of(ThumbnailsTitleSample::create)));
        register(DemoSample.of("thumbnails-detailed", DetailedThumbnailsSample.class, LazyProvider.of(DetailedThumbnailsSample::create)));
    }
}