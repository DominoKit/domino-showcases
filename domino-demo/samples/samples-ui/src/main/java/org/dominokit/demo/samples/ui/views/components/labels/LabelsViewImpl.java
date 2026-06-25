package org.dominokit.demo.samples.ui.views.components.labels;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.components.labels.LabelsView;
    import org.dominokit.showcases.samples.components.labels.LabelsBasicSample;

    @UiView
    public class LabelsViewImpl extends SamplePageView<LabelsView.LabelsUiHandlers>
        implements LabelsView {

      @Inject
      public LabelsViewImpl() {
        super("Labels", "Labels examples rendered from the shared demo-samples module.");
addSample(LabelsBasicSample.class, LabelsBasicSample::create);
        initPage();
      }
    }
