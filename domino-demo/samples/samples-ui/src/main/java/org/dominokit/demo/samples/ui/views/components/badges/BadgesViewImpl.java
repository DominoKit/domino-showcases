package org.dominokit.demo.samples.ui.views.components.badges;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.badges.BadgesView;
        import org.dominokit.showcases.samples.components.badges.BadgesButtonsSample;
import org.dominokit.showcases.samples.components.badges.BadgesIconsSample;
import org.dominokit.showcases.samples.components.badges.BadgesListsSample;

        @UiView
        public class BadgesViewImpl extends SamplePageView<BadgesView.BadgesUiHandlers>
            implements BadgesView {

          @Inject
          public BadgesViewImpl() {
            super("Badges", "Badges examples rendered from the shared demo-samples module.");
    addSample(BadgesButtonsSample.class, BadgesButtonsSample::create);
    addSample(BadgesIconsSample.class, BadgesIconsSample::create);
    addSample(BadgesListsSample.class, BadgesListsSample::create);
            initPage();
          }
        }
