package org.dominokit.demo.samples.ui.views.datatable.columnresize;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.columnresize.ColumnResizeView;
    import org.dominokit.showcases.samples.datatable.columnresize.ColumnResizeSample;

    @UiView
    public class ColumnResizeViewImpl extends SamplePageView<ColumnResizeView.ColumnResizeUiHandlers>
        implements ColumnResizeView {

      @Inject
      public ColumnResizeViewImpl() {
        super("Column Resize Plugin", "Column Resize Plugin examples rendered from the shared demo-samples module.");
addSample(ColumnResizeSample.class, ColumnResizeSample::create);
        initPage();
      }
    }
