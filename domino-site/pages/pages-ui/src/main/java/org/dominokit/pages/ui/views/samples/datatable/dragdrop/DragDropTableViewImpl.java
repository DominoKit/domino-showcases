package org.dominokit.pages.ui.views.samples.datatable.dragdrop;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.dragdrop.*;

@UiView
public class DragDropTableViewImpl extends SampleViewImpl {
    @Inject
    public DragDropTableViewImpl() {
        register(DemoSample.of("datatable-drag-drop-same", DragDropSameTableSample.class, LazyProvider.of(DragDropSameTableSample::create)));
        register(DemoSample.of("datatable-drag-drop-different", DragDropDifferentTableSample.class, LazyProvider.of(DragDropDifferentTableSample::create)));
    }
}