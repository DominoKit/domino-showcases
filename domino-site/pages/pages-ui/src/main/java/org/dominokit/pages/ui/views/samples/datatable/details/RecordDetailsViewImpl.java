package org.dominokit.pages.ui.views.samples.datatable.details;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.details.*;
import org.dominokit.showcases.samples.datatable.RecordDetailsSample;

@UiView
public class RecordDetailsViewImpl extends SampleViewImpl {
    @Inject
    public RecordDetailsViewImpl() {
        register(DemoSample.of("datatable-record-details", RecordDetailsSample.class, LazyProvider.of(RecordDetailsSample::create)));
    }
}
