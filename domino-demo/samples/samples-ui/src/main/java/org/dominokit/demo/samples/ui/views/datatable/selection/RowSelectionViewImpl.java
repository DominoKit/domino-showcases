package org.dominokit.demo.samples.ui.views.datatable.selection;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.datatable.selection.RowSelectionView;
        import org.dominokit.showcases.samples.datatable.selection.SingleRowSelectionSample;
import org.dominokit.showcases.samples.datatable.selection.MultiRowSelectionSample;

        @UiView
        public class RowSelectionViewImpl extends SamplePageView<RowSelectionView.RowSelectionUiHandlers>
            implements RowSelectionView {

          @Inject
          public RowSelectionViewImpl() {
            super("Selection Plugin", "Selection Plugin examples rendered from the shared demo-samples module.");
    addSample(SingleRowSelectionSample.class, SingleRowSelectionSample::create);
    addSample(MultiRowSelectionSample.class, MultiRowSelectionSample::create);
            initPage();
          }
        }
