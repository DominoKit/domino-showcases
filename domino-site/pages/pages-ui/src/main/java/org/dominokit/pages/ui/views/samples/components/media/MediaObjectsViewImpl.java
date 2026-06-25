package org.dominokit.pages.ui.views.samples.components.media;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.media.*;

@UiView
public class MediaObjectsViewImpl extends SampleViewImpl {
    @Inject
    public MediaObjectsViewImpl() {
        register(DemoSample.of("media-object-basic", MediaObjectsBasicSample.class, LazyProvider.of(MediaObjectsBasicSample::create)));
        register(DemoSample.of("media-object-alignment", MediaObjectsAlignmentSample.class, LazyProvider.of(MediaObjectsAlignmentSample::create)));
    }
}