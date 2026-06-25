package org.dominokit.demo.samples.ui.views.forms.timepicker;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.timepicker.TimePickerView;
        import org.dominokit.showcases.samples.forms.timepicker.InlinedTimePickerSample;
import org.dominokit.showcases.samples.forms.timepicker.TimePickerHeaderSample;
import org.dominokit.showcases.samples.forms.timepicker.TimePickerFooterSample;
import org.dominokit.showcases.samples.forms.timepicker.DropDownTimePickerSample;
import org.dominokit.showcases.samples.forms.timepicker.TimeBoxSample;

        @UiView
        public class TimePickerViewImpl extends SamplePageView<TimePickerView.TimePickerUiHandlers>
            implements TimePickerView {

          @Inject
          public TimePickerViewImpl() {
            super("Time Picker", "Time Picker examples rendered from the shared demo-samples module.");
    addSample(InlinedTimePickerSample.class, InlinedTimePickerSample::create);
    addSample(TimePickerHeaderSample.class, TimePickerHeaderSample::create);
    addSample(TimePickerFooterSample.class, TimePickerFooterSample::create);
    addSample(DropDownTimePickerSample.class, DropDownTimePickerSample::create);
    addSample(TimeBoxSample.class, TimeBoxSample::create);
            initPage();
          }
        }
