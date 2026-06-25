package org.dominokit.pages.ui.views.samples.components.menu;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.menu.*;

@UiView
public class MenuViewImpl extends SampleViewImpl {
    @Inject
    public MenuViewImpl() {
        register(DemoSample.of("menu-basic", BasicMenuSample.class, LazyProvider.of(BasicMenuSample::create)));
        register(DemoSample.of("menu-header", MenuHeadersSample.class, LazyProvider.of(MenuHeadersSample::create)));
        register(DemoSample.of("menu-search", MenuSearchSample.class, LazyProvider.of(MenuSearchSample::create)));
        register(DemoSample.of("menu-custom", CustomItemSample.class, LazyProvider.of(CustomItemSample::create)));
        register(DemoSample.of("menu-features", MenuFeaturesSample.class, LazyProvider.of(MenuFeaturesSample::create)));
        register(DemoSample.of("menu-embed", MenuEmbedSample.class, LazyProvider.of(MenuEmbedSample::create)));
        register(DemoSample.of("menu-dropdown", DropdownMenuSample.class, LazyProvider.of(DropdownMenuSample::create)));
        register(DemoSample.of("menu-context", ContextMenuSample.class, LazyProvider.of(ContextMenuSample::create)));
        register(DemoSample.of("menu-nested", NestedMenuSample.class, LazyProvider.of(NestedMenuSample::create)));
    }
}