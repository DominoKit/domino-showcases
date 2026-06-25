package org.dominokit.demo.samples.ui.views.components.preloaders;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.preloaders.PreLoadersView;
        import org.dominokit.showcases.samples.components.preloaders.BasicPreLoadersSample;
import org.dominokit.showcases.samples.components.preloaders.ColoredPreLoadersSample;

        @UiView
        public class PreLoadersViewImpl extends SamplePageView<PreLoadersView.PreLoadersUiHandlers>
            implements PreLoadersView {

          @Inject
          public PreLoadersViewImpl() {
            super("Preloaders", "Preloaders examples rendered from the shared demo-samples module.");
    addSample(BasicPreLoadersSample.class, BasicPreLoadersSample::create);
    addSample(ColoredPreLoadersSample.class, ColoredPreLoadersSample::create);
            initPage();
          }
        }
