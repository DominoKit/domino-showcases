package org.dominokit.pages.ui.views.samples.forms.datepicker;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.datepicker.*;

@UiView
public class DatePickerViewImpl extends SampleViewImpl {
    @Inject
    public DatePickerViewImpl() {
        register(DemoSample.of("date-picker-inlined", InlinedDatePickerSample.class, LazyProvider.of(InlinedDatePickerSample::create)));
        register(DemoSample.of("date-picker-header", DatePickerHeaderSample.class, LazyProvider.of(DatePickerHeaderSample::create)));
        register(DemoSample.of("date-picker-footer", DatePickerFooterSample.class, LazyProvider.of(DatePickerFooterSample::create)));
        register(DemoSample.of("date-picker-dropdown", DropDownDatePickerSample.class, LazyProvider.of(DropDownDatePickerSample::create)));
        register(DemoSample.of("date-picker-datebox", DateBoxSample.class, LazyProvider.of(DateBoxSample::create)));
    }
}