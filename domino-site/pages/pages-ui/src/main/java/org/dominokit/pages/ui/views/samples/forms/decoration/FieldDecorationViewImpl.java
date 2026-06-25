package org.dominokit.pages.ui.views.samples.forms.decoration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.decoration.*;

@UiView
public class FieldDecorationViewImpl extends SampleViewImpl {
    @Inject
    public FieldDecorationViewImpl() {
        register(DemoSample.of("field-decoration-helper", FieldDecorationHelperTextSample.class, LazyProvider.of(FieldDecorationHelperTextSample::create)));
        register(DemoSample.of("field-decoration-addons", FieldDecorationAddOnsSample.class, LazyProvider.of(FieldDecorationAddOnsSample::create)));
        register(DemoSample.of("field-decoration-counter", FieldDecorationCounterSample.class, LazyProvider.of(FieldDecorationCounterSample::create)));
        register(DemoSample.of("field-decoration-validation", FieldDecorationValidationSample.class, LazyProvider.of(FieldDecorationValidationSample::create)));
    }
}