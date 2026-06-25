package org.dominokit.demo.samples.ui.views.datatable.marker;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.marker.TableRowMarkerView;
    import org.dominokit.showcases.samples.datatable.marker.TableRowMarkerSample;

    @UiView
    public class TableRowMarkerViewImpl extends SamplePageView<TableRowMarkerView.TableRowMarkerUiHandlers>
        implements TableRowMarkerView {

      @Inject
      public TableRowMarkerViewImpl() {
        super("Marker Plugin", "Marker Plugin examples rendered from the shared demo-samples module.");
addSample(TableRowMarkerSample.class, TableRowMarkerSample::create);
        initPage();
      }
    }
