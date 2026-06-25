package org.dominokit.demo.samples.ui.views.components.menu;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.menu.MenuView;
        import org.dominokit.showcases.samples.components.menu.BasicMenuSample;
import org.dominokit.showcases.samples.components.menu.MenuHeadersSample;
import org.dominokit.showcases.samples.components.menu.MenuSearchSample;
import org.dominokit.showcases.samples.components.menu.CustomItemSample;
import org.dominokit.showcases.samples.components.menu.MenuFeaturesSample;
import org.dominokit.showcases.samples.components.menu.MenuEmbedSample;
import org.dominokit.showcases.samples.components.menu.DropdownMenuSample;
import org.dominokit.showcases.samples.components.menu.ContextMenuSample;
import org.dominokit.showcases.samples.components.menu.NestedMenuSample;

        @UiView
        public class MenuViewImpl extends SamplePageView<MenuView.MenuUiHandlers>
            implements MenuView {

          @Inject
          public MenuViewImpl() {
            super("Menu", "Menu examples rendered from the shared demo-samples module.");
    addSample(BasicMenuSample.class, BasicMenuSample::create);
    addSample(MenuHeadersSample.class, MenuHeadersSample::create);
    addSample(MenuSearchSample.class, MenuSearchSample::create);
    addSample(CustomItemSample.class, CustomItemSample::create);
    addSample(MenuFeaturesSample.class, MenuFeaturesSample::create);
    addSample(MenuEmbedSample.class, MenuEmbedSample::create);
    addSample(DropdownMenuSample.class, DropdownMenuSample::create);
    addSample(ContextMenuSample.class, ContextMenuSample::create);
    addSample(NestedMenuSample.class, NestedMenuSample::create);
            initPage();
          }
        }
