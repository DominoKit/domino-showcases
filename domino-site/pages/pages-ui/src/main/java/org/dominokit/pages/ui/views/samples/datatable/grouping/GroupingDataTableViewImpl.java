package org.dominokit.pages.ui.views.samples.datatable.grouping;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.grouping.*;

@UiView
public class GroupingDataTableViewImpl extends SampleViewImpl {
    @Inject
    public GroupingDataTableViewImpl() {
        register(DemoSample.of("datatable-grouping", GroupingDataTableSample.class, LazyProvider.of(GroupingDataTableSample::create)));
    }
}