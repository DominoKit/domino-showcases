package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.elements.DivElement;

public final class MultiWorkspaceApplicationSample {

  private MultiWorkspaceApplicationSample() {}

  public static PageLayoutSampleElement create() {
    PageLayoutState state = PageLayoutState.create("Overview", "Operations", 3);
    DivElement root = PageLayoutSupport.root();
    DivElement content = PageLayoutSupport.bordered("");
    DivElement switcher = PageLayoutSupport.row();
    for (String workspace : new String[] {"Operations", "Finance", "Customer success"}) {
      switcher.appendChild(PageLayoutSupport.action(workspace, () -> {
        state.selectWorkspace(workspace);
        renderContent(content, state);
      }));
    }
    root.appendChild(PageLayoutSupport.header(
        "Workspace-aware shell", "Business unit switcher", "Changing the active workspace refreshes the visible navigation and content context together."))
        .appendChild(PageLayoutSupport.surface("Active workspace", "The switcher is global so permissions, filters, and routes can follow the selected context.")
            .appendChild(switcher)
            .appendChild(content));
    renderContent(content, state);
    return PageLayoutSampleElement.create(root);
  }

  private static void renderContent(DivElement content, PageLayoutState state) {
    content.clearElement().appendChild(h(5).textContent(state.workspace()))
        .appendChild(p().textContent("Showing the " + state.workspace().toLowerCase() + " navigation and data scope."));
  }
}
