package org.dominokit.demo.samples.ui.views.components.sliders;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.components.sliders.RangeSlidersView;
    import org.dominokit.showcases.samples.components.sliders.BasicRangeSlidersSample;

    @UiView
    public class RangeSlidersViewImpl extends SamplePageView<RangeSlidersView.RangeSlidersUiHandlers>
        implements RangeSlidersView {

      @Inject
      public RangeSlidersViewImpl() {
        super("Range Slider", "Range Slider examples rendered from the shared demo-samples module.");
addSample(BasicRangeSlidersSample.class, BasicRangeSlidersSample::create);
        initPage();
      }
    }
