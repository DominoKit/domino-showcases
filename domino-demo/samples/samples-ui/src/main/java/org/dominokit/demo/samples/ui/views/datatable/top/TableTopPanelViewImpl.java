package org.dominokit.demo.samples.ui.views.datatable.top;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.top.TableTopPanelView;
    import org.dominokit.showcases.samples.datatable.top.TableTopPanelSample;

    @UiView
    public class TableTopPanelViewImpl extends SamplePageView<TableTopPanelView.TableTopPanelUiHandlers>
        implements TableTopPanelView {

      @Inject
      public TableTopPanelViewImpl() {
        super("Top Panel Plugin", "Top Panel Plugin examples rendered from the shared demo-samples module.");
addSample(TableTopPanelSample.class, TableTopPanelSample::create);
        initPage();
      }
    }
