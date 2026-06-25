package org.dominokit.pages.ui.views.samples.datatable.tree;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.tree.*;

@UiView
public class EagerTreeTableViewImpl extends SampleViewImpl {
    @Inject
    public EagerTreeTableViewImpl() {
        register(DemoSample.of("datatable-tree-eager-full", EagerTreeTableFullSpanSample.class, LazyProvider.of(EagerTreeTableFullSpanSample::create)));
        register(DemoSample.of("datatable-tree-eager-columns", EagerTreeTableColumnsSample.class, LazyProvider.of(EagerTreeTableColumnsSample::create)));
    }
}