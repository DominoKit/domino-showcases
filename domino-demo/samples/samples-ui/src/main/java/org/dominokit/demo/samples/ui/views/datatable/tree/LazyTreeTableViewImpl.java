package org.dominokit.demo.samples.ui.views.datatable.tree;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.datatable.tree.LazyTreeTableView;
        import org.dominokit.showcases.samples.datatable.tree.LazyTreeTableFullSpanSample;
import org.dominokit.showcases.samples.datatable.tree.LazyTreeTableColumnsSample;
import org.dominokit.showcases.samples.datatable.tree.LazyTreeTableLargeDataSetSample;

        @UiView
        public class LazyTreeTableViewImpl extends SamplePageView<LazyTreeTableView.LazyTreeTableUiHandlers>
            implements LazyTreeTableView {

          @Inject
          public LazyTreeTableViewImpl() {
            super("Lazy Tree Plugin", "Lazy Tree Plugin examples rendered from the shared demo-samples module.");
    addSample(LazyTreeTableFullSpanSample.class, LazyTreeTableFullSpanSample::create);
    addSample(LazyTreeTableColumnsSample.class, LazyTreeTableColumnsSample::create);
    addSample(LazyTreeTableLargeDataSetSample.class, LazyTreeTableLargeDataSetSample::create);
            initPage();
          }
        }
