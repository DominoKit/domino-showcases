package org.dominokit.pages.ui.views.samples.components.navbar;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.navbar.*;

@UiView
public class NavbarViewImpl extends SampleViewImpl {
    @Inject
    public NavbarViewImpl() {
        register(DemoSample.of("navbar-simple", SimpleNavBarSample.class, LazyProvider.of(SimpleNavBarSample::create)));
        register(DemoSample.of("navbar-addons", NavBarAddonsSample.class, LazyProvider.of(NavBarAddonsSample::create)));
        register(DemoSample.of("navbar-body", NavBarBodySample.class, LazyProvider.of(NavBarBodySample::create)));
    }
}