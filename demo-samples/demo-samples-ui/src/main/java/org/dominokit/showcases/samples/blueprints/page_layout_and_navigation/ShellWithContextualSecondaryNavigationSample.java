package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.elements.DivElement;

public final class ShellWithContextualSecondaryNavigationSample {

  private ShellWithContextualSecondaryNavigationSample() {}

  public static PageLayoutSampleElement create() {
    PageLayoutState state = PageLayoutState.create("Overview", "Operations", 3);
    DivElement root = PageLayoutSupport.root();
    DivElement content = PageLayoutSupport.bordered("");
    DivElement tabs = PageLayoutSupport.row();
    for (String section : new String[] {"Overview", "Activity", "Permissions"}) {
      tabs.appendChild(PageLayoutSupport.action(section, () -> {
        state.selectArea(section);
        renderContent(content, state);
      }));
    }
    root.appendChild(PageLayoutSupport.header(
        "Contextual navigation", "Customer account", "The primary shell stays stable while a page-level navigation bar changes the current record section."))
        .appendChild(PageLayoutSupport.surface("Account shell", "Global navigation and the selected account remain in context.")
            .appendChild(tabs)
            .appendChild(content));
    renderContent(content, state);
    return PageLayoutSampleElement.create(root);
  }

  private static void renderContent(DivElement content, PageLayoutState state) {
    content.clearElement();
    content.appendChild(p().textContent(
        state.activeArea() + " content is rendered below the contextual navigation without leaving the account."));
  }
}
