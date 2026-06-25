package org.dominokit.demo.samples.ui.views.datatable.details;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.details.RecordDetailsView;
import org.dominokit.showcases.samples.datatable.RecordDetailsSample;

    @UiView
    public class RecordDetailsViewImpl extends SamplePageView<RecordDetailsView.RecordDetailsUiHandlers>
        implements RecordDetailsView {

      @Inject
      public RecordDetailsViewImpl() {
        super("Record Details Plugin", "Record Details Plugin examples rendered from the shared demo-samples module.");
addSample(RecordDetailsSample.class, RecordDetailsSample::create);
        initPage();
      }
    }
