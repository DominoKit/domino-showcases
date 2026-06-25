package org.dominokit.pages.ui.views.samples.components.modals;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.modals.*;

@UiView
public class ModalsViewImpl extends SampleViewImpl {
    @Inject
    public ModalsViewImpl() {
        register(DemoSample.of("modals-basic", BasicModalsSample.class, LazyProvider.of(BasicModalsSample::create)));
        register(DemoSample.of("modals-sheet", SheetModalsSample.class, LazyProvider.of(SheetModalsSample::create)));
        register(DemoSample.of("modals-colored", ColoredModalsSample.class, LazyProvider.of(ColoredModalsSample::create)));
        register(DemoSample.of("modals-window", WindowModalsSample.class, LazyProvider.of(WindowModalsSample::create)));
    }
}