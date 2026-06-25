package org.dominokit.demo.samples.ui.views.datatable.mix;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.mix.PluginsMixView;
    import org.dominokit.showcases.samples.datatable.mix.PluginsMixSample;

    @UiView
    public class PluginsMixViewImpl extends SamplePageView<PluginsMixView.PluginsMixUiHandlers>
        implements PluginsMixView {

      @Inject
      public PluginsMixViewImpl() {
        super("Plugins Mix", "Plugins Mix examples rendered from the shared demo-samples module.");
addSample(PluginsMixSample.class, PluginsMixSample::create);
        initPage();
      }
    }
