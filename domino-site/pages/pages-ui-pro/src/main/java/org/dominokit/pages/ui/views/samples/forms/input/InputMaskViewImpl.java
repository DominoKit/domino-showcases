package org.dominokit.pages.ui.views.samples.forms.input;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.input.*;

@UiView
public class InputMaskViewImpl extends SampleViewImpl {
    @Inject
    public InputMaskViewImpl() {
        register(DemoSample.of("string-mask-sample", StringMaskSample.class, LazyProvider.of(StringMaskSample::create)));
        register(DemoSample.of("mask-box-sample", MaskBoxSample.class, LazyProvider.of(MaskBoxSample::create)));
        register(DemoSample.of("input-mask-sample", InputMaskSample.class, LazyProvider.of(InputMaskSample::create)));
    }
}