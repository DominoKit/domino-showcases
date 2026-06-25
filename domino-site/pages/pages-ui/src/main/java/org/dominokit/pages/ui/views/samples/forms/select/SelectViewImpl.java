package org.dominokit.pages.ui.views.samples.forms.select;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.select.*;

@UiView
public class SelectViewImpl extends SampleViewImpl {
    @Inject
    public SelectViewImpl() {
        register(DemoSample.of("select-sample", BasicFormsSelectSample.class, LazyProvider.of(BasicFormsSelectSample::create)));
    }
}