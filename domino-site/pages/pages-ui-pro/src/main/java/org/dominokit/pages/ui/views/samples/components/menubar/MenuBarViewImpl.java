package org.dominokit.pages.ui.views.samples.components.menubar;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.menubar.*;

@UiView
public class MenuBarViewImpl extends SampleViewImpl {
    @Inject
    public MenuBarViewImpl() {
        register(DemoSample.of("menubar-basic", BasicMenuBarSample.class, LazyProvider.of(BasicMenuBarSample::create)));
        register(DemoSample.of("menubar-background", MenuBarBackgroundSample.class, LazyProvider.of(MenuBarBackgroundSample::create)));
        register(DemoSample.of("menubar-addons", MenuBarAddonsSample.class, LazyProvider.of(MenuBarAddonsSample::create)));
    }
}