package org.dominokit.demo.samples.ui.views.datatable.grouping;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.grouping.GroupingDataTableView;
    import org.dominokit.showcases.samples.datatable.grouping.GroupingDataTableSample;

    @UiView
    public class GroupingDataTableViewImpl extends SamplePageView<GroupingDataTableView.GroupingDataTableUiHandlers>
        implements GroupingDataTableView {

      @Inject
      public GroupingDataTableViewImpl() {
        super("Grouping Plugin", "Grouping Plugin examples rendered from the shared demo-samples module.");
addSample(GroupingDataTableSample.class, GroupingDataTableSample::create);
        initPage();
      }
    }
