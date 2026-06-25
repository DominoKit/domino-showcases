package org.dominokit.pages.ui.views.samples.components.infobox;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.infobox.*;

@UiView
public class InfoBoxViewImpl extends SampleViewImpl {
    @Inject
    public InfoBoxViewImpl() {
        register(DemoSample.of("infobox-basic", BasicInfoBoxSample.class, LazyProvider.of(BasicInfoBoxSample::create)));
        register(DemoSample.of("infobox-hover", HoverInfoBoxSample.class, LazyProvider.of(HoverInfoBoxSample::create)));
        register(DemoSample.of("infobox-alignment", RightAlignedInfoBoxSample.class, LazyProvider.of(RightAlignedInfoBoxSample::create)));
    }
}