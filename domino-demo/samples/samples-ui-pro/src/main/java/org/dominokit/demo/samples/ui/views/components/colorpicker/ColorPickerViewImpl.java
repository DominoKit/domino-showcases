package org.dominokit.demo.samples.ui.views.components.colorpicker;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.colorpicker.ColorPickerView;
        import org.dominokit.showcases.samples.components.colorpicker.BasicColorPickerSample;
import org.dominokit.showcases.samples.components.colorpicker.ColorPickerButtonSample;
import org.dominokit.showcases.samples.components.colorpicker.ColorPickerPopoverSample;

        @UiView
        public class ColorPickerViewImpl extends SamplePageView<ColorPickerView.ColorPickerUiHandlers>
            implements ColorPickerView {

          @Inject
          public ColorPickerViewImpl() {
            super("Color Picker", "Color Picker examples rendered from the shared demo-samples module.");
    addSample(BasicColorPickerSample.class, BasicColorPickerSample::create);
    addSample(ColorPickerButtonSample.class, ColorPickerButtonSample::create);
    addSample(ColorPickerPopoverSample.class, ColorPickerPopoverSample::create);
            initPage();
          }
        }
