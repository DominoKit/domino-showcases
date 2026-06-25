package org.dominokit.demo.samples.ui.views.datatable.header;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.header.TableHeaderBarView;
    import org.dominokit.showcases.samples.datatable.header.TableHeaderBarSample;

    @UiView
    public class TableHeaderBarViewImpl extends SamplePageView<TableHeaderBarView.TableHeaderBarUiHandlers>
        implements TableHeaderBarView {

      @Inject
      public TableHeaderBarViewImpl() {
        super("Header Bar Plugin", "Header Bar Plugin examples rendered from the shared demo-samples module.");
addSample(TableHeaderBarSample.class, TableHeaderBarSample::create);
        initPage();
      }
    }
