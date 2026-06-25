package org.dominokit.demo.samples.ui.views.datatable.fixed;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.fixed.FixedDataTableView;
    import org.dominokit.showcases.samples.datatable.fixed.FixedDataTableSample;

    @UiView
    public class FixedDataTableViewImpl extends SamplePageView<FixedDataTableView.FixedDataTableUiHandlers>
        implements FixedDataTableView {

      @Inject
      public FixedDataTableViewImpl() {
        super("Fixed Table", "Fixed Table examples rendered from the shared demo-samples module.");
addSample(FixedDataTableSample.class, FixedDataTableSample::create);
        initPage();
      }
    }
