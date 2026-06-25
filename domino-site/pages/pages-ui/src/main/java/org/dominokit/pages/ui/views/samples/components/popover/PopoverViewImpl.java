package org.dominokit.pages.ui.views.samples.components.popover;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.popover.*;

@UiView
public class PopoverViewImpl extends SampleViewImpl {
    @Inject
    public PopoverViewImpl() {
        register(DemoSample.of("popovers-tooltip", TooltipSample.class, LazyProvider.of(TooltipSample::create)));
        register(DemoSample.of("popovers-popover", PopoverSample.class, LazyProvider.of(PopoverSample::create)));
    }
}