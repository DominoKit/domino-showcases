package org.dominokit.demo.samples.ui.views.animations;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.animations.AnimationsView;
    import org.dominokit.showcases.samples.animations.AnimationsBasicSample;

    @UiView
    public class AnimationsViewImpl extends SamplePageView<AnimationsView.AnimationsUiHandlers>
        implements AnimationsView {

      @Inject
      public AnimationsViewImpl() {
        super("Animations", "Animations examples rendered from the shared demo-samples module.");
addSample(AnimationsBasicSample.class, AnimationsBasicSample::create);
        initPage();
      }
    }
