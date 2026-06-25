package org.dominokit.pages.ui.views.samples.datatable.tree;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.tree.*;

@UiView
public class LazyTreeTableViewImpl extends SampleViewImpl {
    @Inject
    public LazyTreeTableViewImpl() {
        register(DemoSample.of("datatable-tree-lazy-full", LazyTreeTableFullSpanSample.class, LazyProvider.of(LazyTreeTableFullSpanSample::create)));
        register(DemoSample.of("datatable-tree-lazy-columns", LazyTreeTableColumnsSample.class, LazyProvider.of(LazyTreeTableColumnsSample::create)));
        register(DemoSample.of("datatable-tree-lazy-large", LazyTreeTableLargeDataSetSample.class, LazyProvider.of(LazyTreeTableLargeDataSetSample::create)));
    }
}