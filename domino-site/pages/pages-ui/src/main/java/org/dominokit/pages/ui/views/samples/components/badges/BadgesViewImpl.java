package org.dominokit.pages.ui.views.samples.components.badges;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.badges.*;

@UiView
public class BadgesViewImpl extends SampleViewImpl {
    @Inject
    public BadgesViewImpl() {
        register(DemoSample.of("badges-buttons", BadgesButtonsSample.class, LazyProvider.of(BadgesButtonsSample::create)));
        register(DemoSample.of("badges-icons", BadgesIconsSample.class, LazyProvider.of(BadgesIconsSample::create)));
        register(DemoSample.of("badges-lists", BadgesListsSample.class, LazyProvider.of(BadgesListsSample::create)));
    }
}