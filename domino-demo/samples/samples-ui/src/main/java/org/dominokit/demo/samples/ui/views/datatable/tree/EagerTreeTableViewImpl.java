package org.dominokit.demo.samples.ui.views.datatable.tree;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.datatable.tree.EagerTreeTableView;
        import org.dominokit.showcases.samples.datatable.tree.EagerTreeTableFullSpanSample;
import org.dominokit.showcases.samples.datatable.tree.EagerTreeTableColumnsSample;

        @UiView
        public class EagerTreeTableViewImpl extends SamplePageView<EagerTreeTableView.EagerTreeTableUiHandlers>
            implements EagerTreeTableView {

          @Inject
          public EagerTreeTableViewImpl() {
            super("Eager Tree Plugin", "Eager Tree Plugin examples rendered from the shared demo-samples module.");
    addSample(EagerTreeTableFullSpanSample.class, EagerTreeTableFullSpanSample::create);
    addSample(EagerTreeTableColumnsSample.class, EagerTreeTableColumnsSample::create);
            initPage();
          }
        }
