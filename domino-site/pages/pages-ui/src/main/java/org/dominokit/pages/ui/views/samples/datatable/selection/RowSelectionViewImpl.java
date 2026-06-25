package org.dominokit.pages.ui.views.samples.datatable.selection;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.selection.*;

@UiView
public class RowSelectionViewImpl extends SampleViewImpl {
    @Inject
    public RowSelectionViewImpl() {
        register(DemoSample.of("datatable-selection-single", SingleRowSelectionSample.class, LazyProvider.of(SingleRowSelectionSample::create)));
        register(DemoSample.of("datatable-selection-multi", MultiRowSelectionSample.class, LazyProvider.of(MultiRowSelectionSample::create)));
    }
}