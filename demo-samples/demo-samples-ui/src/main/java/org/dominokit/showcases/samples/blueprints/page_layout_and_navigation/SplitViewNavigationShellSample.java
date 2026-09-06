package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;

public final class SplitViewNavigationShellSample {

  private SplitViewNavigationShellSample() {}

  public static PageLayoutSampleElement create() {
    PageLayoutState state = PageLayoutState.create("Northwind", "Operations", 3);
    DivElement root = PageLayoutSupport.root();
    DivElement detail = PageLayoutSupport.bordered("");
    DivElement list = PageLayoutSupport.stack();
    for (String item : new String[] {"Northwind", "Contoso", "Fabrikam", "Adventure Works"}) {
      list.appendChild(Button.create(item).addClickListener(event -> {
        state.selectArea(item);
        renderDetail(detail, state);
      }));
    }
    root.appendChild(PageLayoutSupport.header(
        "Split-view shell", "Account directory", "The navigation list stays mounted beside the detail pane so selection does not destroy list context."))
        .appendChild(PageLayoutSupport.grid("220px minmax(0, 1fr)")
            .appendChild(PageLayoutSupport.surface("Accounts", "Select an account to inspect it.").appendChild(list))
            .appendChild(detail));
    renderDetail(detail, state);
    return PageLayoutSampleElement.create(root);
  }

  private static void renderDetail(DivElement detail, PageLayoutState state) {
    detail.clearElement().appendChild(h(5).textContent(state.activeArea()))
        .appendChild(p().textContent("The selected account opens here while the directory remains visible."));
  }
}
