package org.dominokit.pages.ui.views.samples.components.lists;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.lists.*;

@UiView
public class ListsViewImpl extends SampleViewImpl {
    @Inject
    public ListsViewImpl() {
        register(DemoSample.of("lists-single-select", SingleSelectListsSample.class, LazyProvider.of(SingleSelectListsSample::create)));
        register(DemoSample.of("lists-multi-select", MultiSelectListsSample.class, LazyProvider.of(MultiSelectListsSample::create)));
    }
}