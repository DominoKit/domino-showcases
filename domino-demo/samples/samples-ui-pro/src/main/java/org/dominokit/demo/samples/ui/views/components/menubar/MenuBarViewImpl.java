package org.dominokit.demo.samples.ui.views.components.menubar;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.menubar.MenuBarView;
        import org.dominokit.showcases.samples.components.menubar.BasicMenuBarSample;
import org.dominokit.showcases.samples.components.menubar.MenuBarBackgroundSample;
import org.dominokit.showcases.samples.components.menubar.MenuBarAddonsSample;

        @UiView
        public class MenuBarViewImpl extends SamplePageView<MenuBarView.MenuBarUiHandlers>
            implements MenuBarView {

          @Inject
          public MenuBarViewImpl() {
            super("Menu Bar", "Menu Bar examples rendered from the shared demo-samples module.");
    addSample(BasicMenuBarSample.class, BasicMenuBarSample::create);
    addSample(MenuBarBackgroundSample.class, MenuBarBackgroundSample::create);
    addSample(MenuBarAddonsSample.class, MenuBarAddonsSample::create);
            initPage();
          }
        }
