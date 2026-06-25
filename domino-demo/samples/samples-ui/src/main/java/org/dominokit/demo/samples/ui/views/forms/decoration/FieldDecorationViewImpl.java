package org.dominokit.demo.samples.ui.views.forms.decoration;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.decoration.FieldDecorationView;
        import org.dominokit.showcases.samples.forms.decoration.FieldDecorationHelperTextSample;
import org.dominokit.showcases.samples.forms.decoration.FieldDecorationAddOnsSample;
import org.dominokit.showcases.samples.forms.decoration.FieldDecorationCounterSample;
import org.dominokit.showcases.samples.forms.decoration.FieldDecorationValidationSample;

        @UiView
        public class FieldDecorationViewImpl extends SamplePageView<FieldDecorationView.FieldDecorationUiHandlers>
            implements FieldDecorationView {

          @Inject
          public FieldDecorationViewImpl() {
            super("Field Decoration", "Field Decoration examples rendered from the shared demo-samples module.");
    addSample(FieldDecorationHelperTextSample.class, FieldDecorationHelperTextSample::create);
    addSample(FieldDecorationAddOnsSample.class, FieldDecorationAddOnsSample::create);
    addSample(FieldDecorationCounterSample.class, FieldDecorationCounterSample::create);
    addSample(FieldDecorationValidationSample.class, FieldDecorationValidationSample::create);
            initPage();
          }
        }
