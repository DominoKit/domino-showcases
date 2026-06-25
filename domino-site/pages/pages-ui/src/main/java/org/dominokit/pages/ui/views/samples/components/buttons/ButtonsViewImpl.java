package org.dominokit.pages.ui.views.samples.components.buttons;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.buttons.ButtonsBasicSample;
import org.dominokit.showcases.samples.components.buttons.ButtonsDropDownSample;
import org.dominokit.showcases.samples.components.buttons.ButtonsGroupsSample;
import org.dominokit.showcases.samples.components.buttons.ButtonsSizeSample;

@UiView
public class ButtonsViewImpl extends SampleViewImpl {
    @Inject
    public ButtonsViewImpl() {
        register(DemoSample.of("buttons-basic", ButtonsBasicSample.class, LazyProvider.of(ButtonsBasicSample::create)));
        register(DemoSample.of("buttons-sizes", ButtonsSizeSample.class, LazyProvider.of(ButtonsSizeSample::create)));
        register(DemoSample.of("buttons-groups", ButtonsGroupsSample.class, LazyProvider.of(ButtonsGroupsSample::create)));
        register(DemoSample.of("buttons-split-drop", ButtonsDropDownSample.class, LazyProvider.of(ButtonsDropDownSample::create)));
    }
}
