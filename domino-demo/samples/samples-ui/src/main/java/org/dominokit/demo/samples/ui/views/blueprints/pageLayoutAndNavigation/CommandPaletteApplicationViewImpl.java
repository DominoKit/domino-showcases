package org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.CommandPaletteApplicationView;
import org.dominokit.showcases.samples.blueprints.page_layout_and_navigation.CommandPaletteApplicationSample;

@UiView
public class CommandPaletteApplicationViewImpl extends BlueprintSamplePageView<CommandPaletteApplicationView.CommandPaletteApplicationUiHandlers>
    implements CommandPaletteApplicationView {

  @Inject
  public CommandPaletteApplicationViewImpl() {
    super("Command palette application", "Layout: Minimal shell with a global command/search trigger and an optional keyboard-shortcut hint. Interaction: Users search for pages, records, actions, or settings and execute commands without navigating menus. Variants: Modal palette, inline command bar, or command palette with recent actions.");
    addSample("Command palette application", "Layout: Minimal shell with a global command/search trigger and an optional keyboard-shortcut hint. Interaction: Users search for pages, records, actions, or settings and execute commands without navigating menus. Variants: Modal palette, inline command bar, or command palette with recent actions.", CommandPaletteApplicationSample.class, CommandPaletteApplicationSample::create);
    initPage();
  }
}
