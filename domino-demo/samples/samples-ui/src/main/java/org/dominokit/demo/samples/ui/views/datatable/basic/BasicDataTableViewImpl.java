package org.dominokit.demo.samples.ui.views.datatable.basic;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.basic.BasicDataTableView;
    import org.dominokit.showcases.samples.datatable.basic.BasicDataTableSample;

    @UiView
    public class BasicDataTableViewImpl extends SamplePageView<BasicDataTableView.BasicDataTableUiHandlers>
        implements BasicDataTableView {

      @Inject
      public BasicDataTableViewImpl() {
        super("Basic Table", "Basic Table examples rendered from the shared demo-samples module.");
addSample(BasicDataTableSample.class, BasicDataTableSample::create);
        initPage();
      }
    }
