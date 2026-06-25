package org.dominokit.demo.samples.ui.views.forms.basic;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.basic.BasicFormElementsView;
        import org.dominokit.showcases.samples.forms.input.BasicFormsInputSample;
import org.dominokit.showcases.samples.forms.input.BasicFormsTextAreaSample;
import org.dominokit.showcases.samples.forms.input.BasicFormsCheckboxSample;
import org.dominokit.showcases.samples.forms.input.BasicFormsRadioSample;
import org.dominokit.showcases.samples.forms.input.BasicFormsSwitchSample;
import org.dominokit.showcases.samples.forms.select.BasicFormsSelectSample;

        @UiView
        public class BasicFormElementsViewImpl extends SamplePageView<BasicFormElementsView.BasicFormElementsUiHandlers>
            implements BasicFormElementsView {

          @Inject
          public BasicFormElementsViewImpl() {
            super("Basic Form Elements", "Basic Form Elements examples rendered from the shared demo-samples module.");
    addSample(BasicFormsInputSample.class, BasicFormsInputSample::create);
    addSample(BasicFormsTextAreaSample.class, BasicFormsTextAreaSample::create);
    addSample(BasicFormsCheckboxSample.class, BasicFormsCheckboxSample::create);
    addSample(BasicFormsRadioSample.class, BasicFormsRadioSample::create);
    addSample(BasicFormsSwitchSample.class, BasicFormsSwitchSample::create);
    addSample(BasicFormsSelectSample.class, BasicFormsSelectSample::create);
            initPage();
          }
        }
