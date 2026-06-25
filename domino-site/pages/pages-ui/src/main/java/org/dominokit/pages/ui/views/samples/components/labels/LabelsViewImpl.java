package org.dominokit.pages.ui.views.samples.components.labels;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.labels.*;

@UiView
public class LabelsViewImpl extends SampleViewImpl {
    @Inject
    public LabelsViewImpl() {
        register(DemoSample.of("labels-basic", LabelsBasicSample.class, LazyProvider.of(LabelsBasicSample::create)));
    }
}