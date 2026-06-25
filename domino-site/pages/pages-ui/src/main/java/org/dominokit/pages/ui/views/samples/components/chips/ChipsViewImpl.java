package org.dominokit.pages.ui.views.samples.components.chips;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.chips.*;

@UiView
public class ChipsViewImpl extends SampleViewImpl {
    @Inject
    public ChipsViewImpl() {
        register(DemoSample.of("chip-basic", BasicChipsSample.class, LazyProvider.of(BasicChipsSample::create)));
        register(DemoSample.of("chip-removable", RemovableChipsSample.class, LazyProvider.of(RemovableChipsSample::create)));
        register(DemoSample.of("chip-images", ChipsWithIconsAndImagesSample.class, LazyProvider.of(ChipsWithIconsAndImagesSample::create)));
        register(DemoSample.of("chip-letters", ChipsWithLettersSample.class, LazyProvider.of(ChipsWithLettersSample::create)));
        register(DemoSample.of("chip-selectable", SelectableChipsSample.class, LazyProvider.of(SelectableChipsSample::create)));
    }
}