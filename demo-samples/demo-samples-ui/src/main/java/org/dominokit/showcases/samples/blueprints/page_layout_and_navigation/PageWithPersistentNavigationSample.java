package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;

public final class PageWithPersistentNavigationSample {

  private PageWithPersistentNavigationSample() {}

  public static PageLayoutSampleElement create() {
    PageLayoutState state = PageLayoutState.create("Dashboard", "Operations", 3);
    DivElement root = PageLayoutSupport.root();
    DivElement layout = PageLayoutSupport.grid("220px minmax(0, 1fr)");
    DivElement navigation = PageLayoutSupport.bordered("min-height: 230px;");
    DivElement content = PageLayoutSupport.stack();
    Button toggle = Button.create("Collapse navigation");

    Runnable render = () -> {
      layout.cssText("display: grid; grid-template-columns: "
          + (state.navigationCollapsed() ? "64px" : "220px") + " minmax(0, 1fr); gap: 12px; align-items: start;");
      toggle.setText(state.navigationCollapsed() ? "Expand navigation" : "Collapse navigation");
      navigation.clearElement();
      if (state.navigationCollapsed()) {
        navigation.appendChild(p().textContent("⌂"))
            .appendChild(p().textContent("▣"))
            .appendChild(p().textContent("⚙"));
      } else {
        navigation.appendChild(h(5).textContent("Operations"));
        for (String item : new String[] {"Dashboard", "Work queue", "Reports", "Settings"}) {
          navigation.appendChild(Button.create(item)
              .addClickListener(event -> {
                state.selectArea(item);
                renderContent(content, state);
              }));
        }
      }
      renderContent(content, state);
    };
    toggle.addClickListener(event -> {
      state.toggleNavigation();
      render.run();
    });
    root.appendChild(PageLayoutSupport.header(
        "Persistent shell", "Operations workspace", "A global shell keeps navigation and current context visible while the content route changes."))
        .appendChild(PageLayoutSupport.row().appendChild(toggle).appendChild(p().textContent("Workspace: Operations")))
        .appendChild(layout.appendChild(navigation).appendChild(content));
    render.run();
    return PageLayoutSampleElement.create(root);
  }

  private static void renderContent(DivElement content, PageLayoutState state) {
    content.clearElement();
    content.appendChild(PageLayoutSupport.surface(
        state.activeArea(),
        "The shell preserves the header, navigation context, and active workspace while this routed region changes.")
        .appendChild(PageLayoutSupport.status("Current route: /operations/" + state.activeArea().toLowerCase().replace(" ", "-"))));
  }
}
