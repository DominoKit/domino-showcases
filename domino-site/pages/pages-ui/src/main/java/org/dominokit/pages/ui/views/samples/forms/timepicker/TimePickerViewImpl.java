package org.dominokit.pages.ui.views.samples.forms.timepicker;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.timepicker.*;

@UiView
public class TimePickerViewImpl extends SampleViewImpl {
    @Inject
    public TimePickerViewImpl() {
        register(DemoSample.of("time-picker-inlined", InlinedTimePickerSample.class, LazyProvider.of(InlinedTimePickerSample::create)));
        register(DemoSample.of("time-picker-header", TimePickerHeaderSample.class, LazyProvider.of(TimePickerHeaderSample::create)));
        register(DemoSample.of("time-picker-footer", TimePickerFooterSample.class, LazyProvider.of(TimePickerFooterSample::create)));
        register(DemoSample.of("time-picker-dropdown", DropDownTimePickerSample.class, LazyProvider.of(DropDownTimePickerSample::create)));
        register(DemoSample.of("time-picker-datebox", TimeBoxSample.class, LazyProvider.of(TimeBoxSample::create)));
    }
}