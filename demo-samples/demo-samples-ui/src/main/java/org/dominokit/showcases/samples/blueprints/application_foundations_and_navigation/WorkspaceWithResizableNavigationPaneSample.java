package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;

public final class WorkspaceWithResizableNavigationPaneSample {

  private WorkspaceWithResizableNavigationPaneSample() {}

  public static ApplicationFoundationSampleElement create() {
    DivElement root = ApplicationFoundationSupport.root();
    DivElement layout = ApplicationFoundationSupport.grid("240px minmax(0, 1fr)");
    DivElement pane = ApplicationFoundationSupport.bordered("min-height: 250px;");
    DivElement content = ApplicationFoundationSupport.bordered("min-height: 250px;");
    int[] paneWidth = {240};
    Button collapse = Button.create("Collapse pane");

    Runnable render = () -> {
      layout.cssText("display: grid; grid-template-columns: " + paneWidth[0] + "px minmax(0, 1fr); gap: 12px; align-items: start;");
      pane.clearElement();
      if (paneWidth[0] == 0) {
        pane.appendChild(p().textContent("Navigation pane collapsed"));
      } else {
        pane.appendChild(h(5).textContent("Project navigation"));
        for (String item : new String[] {"Projects", "Saved searches", "Team queue", "Archive"}) {
          pane.appendChild(Button.create(item).addClickListener(event -> content.clearElement()
              .appendChild(h(5).textContent(item)).appendChild(p().textContent("Selected in the navigation pane."))));
        }
      }
      collapse.setText(paneWidth[0] == 0 ? "Expand pane" : "Collapse pane");
    };
    root.appendChild(ApplicationFoundationSupport.header(
        "Resizable workspace", "Project explorer", "A persistent navigation pane can be resized or collapsed without losing the active content context."))
        .appendChild(ApplicationFoundationSupport.row()
            .appendChild(ApplicationFoundationSupport.action("Narrow", () -> { paneWidth[0] = Math.max(0, paneWidth[0] - 40); render.run(); }))
            .appendChild(ApplicationFoundationSupport.action("Widen", () -> { paneWidth[0] = Math.min(360, paneWidth[0] + 40); render.run(); }))
            .appendChild(collapse))
        .appendChild(layout.appendChild(pane).appendChild(content));
    collapse.addClickListener(event -> { paneWidth[0] = paneWidth[0] == 0 ? 240 : 0; render.run(); });
    content.appendChild(h(5).textContent("Select a navigation node"))
        .appendChild(p().textContent("The content pane keeps its position while the navigation pane changes size."));
    render.run();
    return ApplicationFoundationSampleElement.create(root);
  }
}
