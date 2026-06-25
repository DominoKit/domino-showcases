package org.dominokit.demo.samples.ui.views.forms.input;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.input.InputMaskView;
        import org.dominokit.showcases.samples.forms.input.StringMaskSample;
import org.dominokit.showcases.samples.forms.input.MaskBoxSample;
import org.dominokit.showcases.samples.forms.input.InputMaskSample;

        @UiView
        public class InputMaskViewImpl extends SamplePageView<InputMaskView.InputMaskUiHandlers>
            implements InputMaskView {

          @Inject
          public InputMaskViewImpl() {
            super("Input Mask", "Input Mask examples rendered from the shared demo-samples module.");
    addSample(StringMaskSample.class, StringMaskSample::create);
    addSample(MaskBoxSample.class, MaskBoxSample::create);
    addSample(InputMaskSample.class, InputMaskSample::create);
            initPage();
          }
        }
