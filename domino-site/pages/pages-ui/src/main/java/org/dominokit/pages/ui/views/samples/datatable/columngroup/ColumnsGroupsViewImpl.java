package org.dominokit.pages.ui.views.samples.datatable.columngroup;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.columngroup.*;

@UiView
public class ColumnsGroupsViewImpl extends SampleViewImpl {
    @Inject
    public ColumnsGroupsViewImpl() {
        register(DemoSample.of("datatable-column-group", ColumnGroupsSample.class, LazyProvider.of(ColumnGroupsSample::create)));
        register(DemoSample.of("datatable-column-group-advanced", ColumnGroupsAdvancedSample.class, LazyProvider.of(ColumnGroupsAdvancedSample::create)));
    }
}