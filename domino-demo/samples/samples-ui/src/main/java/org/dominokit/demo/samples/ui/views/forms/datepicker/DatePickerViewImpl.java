package org.dominokit.demo.samples.ui.views.forms.datepicker;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.datepicker.DatePickerView;
        import org.dominokit.showcases.samples.forms.datepicker.InlinedDatePickerSample;
import org.dominokit.showcases.samples.forms.datepicker.DatePickerHeaderSample;
import org.dominokit.showcases.samples.forms.datepicker.DatePickerFooterSample;
import org.dominokit.showcases.samples.forms.datepicker.DropDownDatePickerSample;
import org.dominokit.showcases.samples.forms.datepicker.DateBoxSample;

        @UiView
        public class DatePickerViewImpl extends SamplePageView<DatePickerView.DatePickerUiHandlers>
            implements DatePickerView {

          @Inject
          public DatePickerViewImpl() {
            super("Date Picker", "Date Picker examples rendered from the shared demo-samples module.");
    addSample(InlinedDatePickerSample.class, InlinedDatePickerSample::create);
    addSample(DatePickerHeaderSample.class, DatePickerHeaderSample::create);
    addSample(DatePickerFooterSample.class, DatePickerFooterSample::create);
    addSample(DropDownDatePickerSample.class, DropDownDatePickerSample::create);
    addSample(DateBoxSample.class, DateBoxSample::create);
            initPage();
          }
        }
