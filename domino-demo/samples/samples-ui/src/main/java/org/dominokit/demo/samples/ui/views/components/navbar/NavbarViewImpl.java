package org.dominokit.demo.samples.ui.views.components.navbar;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.navbar.NavbarView;
        import org.dominokit.showcases.samples.components.navbar.SimpleNavBarSample;
import org.dominokit.showcases.samples.components.navbar.NavBarAddonsSample;
import org.dominokit.showcases.samples.components.navbar.NavBarBodySample;

        @UiView
        public class NavbarViewImpl extends SamplePageView<NavbarView.NavbarUiHandlers>
            implements NavbarView {

          @Inject
          public NavbarViewImpl() {
            super("Navigation Bar", "Navigation Bar examples rendered from the shared demo-samples module.");
    addSample(SimpleNavBarSample.class, SimpleNavBarSample::create);
    addSample(NavBarAddonsSample.class, NavBarAddonsSample::create);
    addSample(NavBarBodySample.class, NavBarBodySample::create);
            initPage();
          }
        }
