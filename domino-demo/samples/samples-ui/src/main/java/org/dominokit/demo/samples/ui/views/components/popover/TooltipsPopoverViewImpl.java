package org.dominokit.demo.samples.ui.views.components.popover;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.popover.TooltipsPopoverView;
        import org.dominokit.showcases.samples.components.popover.TooltipSample;
import org.dominokit.showcases.samples.components.popover.PopoverSample;

        @UiView
        public class TooltipsPopoverViewImpl extends SamplePageView<TooltipsPopoverView.TooltipsPopoverUiHandlers>
            implements TooltipsPopoverView {

          @Inject
          public TooltipsPopoverViewImpl() {
            super("Tooltips & Popover", "Tooltips & Popover examples rendered from the shared demo-samples module.");
    addSample(TooltipSample.class, TooltipSample::create);
    addSample(PopoverSample.class, PopoverSample::create);
            initPage();
          }
        }
