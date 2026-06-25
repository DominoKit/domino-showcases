package org.dominokit.pages.ui.views.samples.animations;

import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;

import javax.inject.Inject;
import org.dominokit.showcases.samples.animations.*;

@UiView
public class AnimationsViewImpl extends SampleViewImpl {
    @Inject
    public AnimationsViewImpl() {
        register(DemoSample.of("animations-basic", AnimationsBasicSample.class, LazyProvider.of(AnimationsBasicSample::create)));
    }
}