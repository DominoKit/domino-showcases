package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.elements.DivElement;

public final class BreadcrumbAndBackStackWorkspaceSample {

  private BreadcrumbAndBackStackWorkspaceSample() {}

  public static PageLayoutSampleElement create() {
    DivElement root = PageLayoutSupport.root();
    DivElement breadcrumbs = PageLayoutSupport.row();
    DivElement content = PageLayoutSupport.bordered("");
    String[] path = {"Accounts", "Northwind", "Contacts"};
    int[] depth = {2};
    Runnable[] render = new Runnable[1];
    render[0] = () -> {
      breadcrumbs.clearElement();
      if (depth[0] > 0) {
        breadcrumbs.appendChild(PageLayoutSupport.action("Back", () -> { depth[0] = Math.max(0, depth[0] - 1); renderContent(content, path, depth[0]); render[0].run(); }));
      }
      for (int i = 0; i <= depth[0]; i++) {
        int index = i;
        breadcrumbs.appendChild(PageLayoutSupport.action(path[i], () -> { depth[0] = index; renderContent(content, path, depth[0]); render[0].run(); }));
      }
    };
    root.appendChild(PageLayoutSupport.header(
        "Back-stack workspace", "Account context", "Breadcrumbs replace permanent navigation while preserving the path back through nested records."))
        .appendChild(breadcrumbs)
        .appendChild(content);
    renderContent(content, path, depth[0]);
    render[0].run();
    return PageLayoutSampleElement.create(root);
  }

  private static void renderContent(DivElement content, String[] path, int depth) {
    content.clearElement().appendChild(h(5).textContent(path[depth]))
        .appendChild(p().textContent("Context restored for " + path[depth] + ". Search and filter state stays attached to the back stack."));
  }
}
