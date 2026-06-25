package org.dominokit.demo.samples.ui.views.datatable.emptystate;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.emptystate.EmptyStateTableView;
    import org.dominokit.showcases.samples.datatable.emptystate.EmptyStateTableSample;

    @UiView
    public class EmptyStateTableViewImpl extends SamplePageView<EmptyStateTableView.EmptyStateTableUiHandlers>
        implements EmptyStateTableView {

      @Inject
      public EmptyStateTableViewImpl() {
        super("Empty State", "Empty State examples rendered from the shared demo-samples module.");
addSample(EmptyStateTableSample.class, EmptyStateTableSample::create);
        initPage();
      }
    }
