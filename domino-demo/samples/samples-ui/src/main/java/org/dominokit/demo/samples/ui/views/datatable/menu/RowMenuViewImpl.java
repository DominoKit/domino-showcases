package org.dominokit.demo.samples.ui.views.datatable.menu;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.menu.RowMenuView;
    import org.dominokit.showcases.samples.datatable.menu.RowMenuSample;

    @UiView
    public class RowMenuViewImpl extends SamplePageView<RowMenuView.RowMenuUiHandlers>
        implements RowMenuView {

      @Inject
      public RowMenuViewImpl() {
        super("Row Menu Plugin", "Row Menu Plugin examples rendered from the shared demo-samples module.");
addSample(RowMenuSample.class, RowMenuSample::create);
        initPage();
      }
    }
