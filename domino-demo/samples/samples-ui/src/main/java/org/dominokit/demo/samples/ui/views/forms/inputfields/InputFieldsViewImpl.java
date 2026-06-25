package org.dominokit.demo.samples.ui.views.forms.inputfields;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.inputfields.InputFieldsView;
        import org.dominokit.showcases.samples.forms.input.BasicFormsInputSample;
import org.dominokit.showcases.samples.forms.input.BasicFormsTextAreaSample;

        @UiView
        public class InputFieldsViewImpl extends SamplePageView<InputFieldsView.InputFieldsUiHandlers>
            implements InputFieldsView {

          @Inject
          public InputFieldsViewImpl() {
            super("Input Fields", "Input Fields examples rendered from the shared demo-samples module.");
    addSample(BasicFormsInputSample.class, BasicFormsInputSample::create);
    addSample(BasicFormsTextAreaSample.class, BasicFormsTextAreaSample::create);
            initPage();
          }
        }
