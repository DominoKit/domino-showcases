package org.dominokit.demo.samples.ui.views.datatable.sortsearch;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.sortsearch.TableSortAndSearchView;
    import org.dominokit.showcases.samples.datatable.sortsearch.TableSortAndSearchSample;

    @UiView
    public class TableSortAndSearchViewImpl extends SamplePageView<TableSortAndSearchView.TableSortAndSearchUiHandlers>
        implements TableSortAndSearchView {

      @Inject
      public TableSortAndSearchViewImpl() {
        super("Sort and Search Plugin", "Sort and Search Plugin examples rendered from the shared demo-samples module.");
addSample(TableSortAndSearchSample.class, TableSortAndSearchSample::create);
        initPage();
      }
    }
