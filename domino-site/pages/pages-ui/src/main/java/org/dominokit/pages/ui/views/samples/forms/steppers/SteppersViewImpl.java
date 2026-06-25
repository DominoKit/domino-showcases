package org.dominokit.pages.ui.views.samples.forms.steppers;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.steppers.*;

@UiView
public class SteppersViewImpl extends SampleViewImpl {
    @Inject
    public SteppersViewImpl() {
        register(DemoSample.of("stepper-track-horizontal", HorizontalTrackSample.class, LazyProvider.of(HorizontalTrackSample::create)));
//        register(DemoSample.of("stepper-track-vertical", VerticalTrackSample.class, LazyProvider.of(VerticalTrackSample::create)));
//        register(DemoSample.of("stepper-horizontal", HorizontalStepperSample.class, LazyProvider.of(HorizontalStepperSample::create)));
//        register(DemoSample.of("stepper-vertical", VerticalStepperSample.class, LazyProvider.of(VerticalStepperSample::create)));
    }
}