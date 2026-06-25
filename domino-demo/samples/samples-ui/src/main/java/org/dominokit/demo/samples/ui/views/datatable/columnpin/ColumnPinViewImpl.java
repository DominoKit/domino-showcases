package org.dominokit.demo.samples.ui.views.datatable.columnpin;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.columnpin.ColumnPinView;
    import org.dominokit.showcases.samples.datatable.columnpin.ColumnPinSample;

    @UiView
    public class ColumnPinViewImpl extends SamplePageView<ColumnPinView.ColumnPinUiHandlers>
        implements ColumnPinView {

      @Inject
      public ColumnPinViewImpl() {
        super("Column Pin Plugin", "Column Pin Plugin examples rendered from the shared demo-samples module.");
addSample(ColumnPinSample.class, ColumnPinSample::create);
        initPage();
      }
    }
