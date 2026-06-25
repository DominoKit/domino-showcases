package org.dominokit.demo.samples.ui.views.datatable.summary;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.summary.TableSummaryView;
    import org.dominokit.showcases.samples.datatable.summary.TableSummarySample;

    @UiView
    public class TableSummaryViewImpl extends SamplePageView<TableSummaryView.TableSummaryUiHandlers>
        implements TableSummaryView {

      @Inject
      public TableSummaryViewImpl() {
        super("Summary Plugin", "Summary Plugin examples rendered from the shared demo-samples module.");
addSample(TableSummarySample.class, TableSummarySample::create);
        initPage();
      }
    }
