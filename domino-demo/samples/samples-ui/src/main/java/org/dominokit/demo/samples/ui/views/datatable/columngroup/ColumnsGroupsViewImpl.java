package org.dominokit.demo.samples.ui.views.datatable.columngroup;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.datatable.columngroup.ColumnsGroupsView;
        import org.dominokit.showcases.samples.datatable.columngroup.ColumnGroupsSample;
import org.dominokit.showcases.samples.datatable.columngroup.ColumnGroupsAdvancedSample;

        @UiView
        public class ColumnsGroupsViewImpl extends SamplePageView<ColumnsGroupsView.ColumnsGroupsUiHandlers>
            implements ColumnsGroupsView {

          @Inject
          public ColumnsGroupsViewImpl() {
            super("Column Groups", "Column Groups examples rendered from the shared demo-samples module.");
    addSample(ColumnGroupsSample.class, ColumnGroupsSample::create);
    addSample(ColumnGroupsAdvancedSample.class, ColumnGroupsAdvancedSample::create);
            initPage();
          }
        }
