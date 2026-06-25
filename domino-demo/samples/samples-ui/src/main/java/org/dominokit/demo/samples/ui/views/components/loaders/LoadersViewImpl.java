package org.dominokit.demo.samples.ui.views.components.loaders;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.components.loaders.LoadersView;
    import org.dominokit.showcases.samples.components.loaders.LoadersBasicSample;

    @UiView
    public class LoadersViewImpl extends SamplePageView<LoadersView.LoadersUiHandlers>
        implements LoadersView {

      @Inject
      public LoadersViewImpl() {
        super("Loaders", "Loaders examples rendered from the shared demo-samples module.");
addSample(LoadersBasicSample.class, LoadersBasicSample::create);
        initPage();
      }
    }
