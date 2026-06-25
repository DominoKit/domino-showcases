package org.dominokit.demo.samples.ui.views.components.waves;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.components.waves.WavesView;
    import org.dominokit.showcases.samples.components.waves.WavesSample;

    @UiView
    public class WavesViewImpl extends SamplePageView<WavesView.WavesUiHandlers>
        implements WavesView {

      @Inject
      public WavesViewImpl() {
        super("Waves", "Waves examples rendered from the shared demo-samples module.");
addSample(WavesSample.class, WavesSample::create);
        initPage();
      }
    }
