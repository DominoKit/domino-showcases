package org.dominokit.pages.ui.views.samples.forms.input;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.input.*;

@UiView
public class CheckBoxViewImpl extends SampleViewImpl {
    @Inject
    public CheckBoxViewImpl() {
        register(DemoSample.of("check-box-sample", BasicFormsCheckboxSample.class, LazyProvider.of(BasicFormsCheckboxSample::create)));
    }
}