package org.dominokit.demo.samples.ui.views.datatable.dragdrop;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.datatable.dragdrop.DragDropTableView;
        import org.dominokit.showcases.samples.datatable.dragdrop.DragDropSameTableSample;
import org.dominokit.showcases.samples.datatable.dragdrop.DragDropDifferentTableSample;

        @UiView
        public class DragDropTableViewImpl extends SamplePageView<DragDropTableView.DragDropTableUiHandlers>
            implements DragDropTableView {

          @Inject
          public DragDropTableViewImpl() {
            super("Drag Drop Plugin", "Drag Drop Plugin examples rendered from the shared demo-samples module.");
    addSample(DragDropSameTableSample.class, DragDropSameTableSample::create);
    addSample(DragDropDifferentTableSample.class, DragDropDifferentTableSample::create);
            initPage();
          }
        }
