package org.dominokit.pages.ui.views.samples.forms.input;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.input.*;

@UiView
public class RadioViewImpl extends SampleViewImpl {
    @Inject
    public RadioViewImpl() {
        register(DemoSample.of("radio-sample", BasicFormsRadioSample.class, LazyProvider.of(BasicFormsRadioSample::create)));
    }
}