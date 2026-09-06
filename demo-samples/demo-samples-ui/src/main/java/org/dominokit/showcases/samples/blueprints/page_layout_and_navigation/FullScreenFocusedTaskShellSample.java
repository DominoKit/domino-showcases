package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.elements.DivElement;

public final class FullScreenFocusedTaskShellSample {

  private FullScreenFocusedTaskShellSample() {}

  public static PageLayoutSampleElement create() {
    PageLayoutState state = PageLayoutState.create("Review", "Operations", 3);
    DivElement root = PageLayoutSupport.root().cssText("max-width: 760px; margin: 0 auto; padding: 24px;");
    DivElement progress = PageLayoutSupport.row();
    DivElement content = PageLayoutSupport.bordered("");
    DivElement footer = PageLayoutSupport.row();
    boolean[] paused = {false};
    Runnable[] render = new Runnable[1];
    render[0] = () -> {
      progress.clearElement();
      for (int i = 1; i <= 3; i++) {
        progress.appendChild(p().textContent((i <= state.taskStep() ? "● " : "○ ") + new String[] {"Details", "Review", "Finish"}[i - 1]));
      }
      content.clearElement().appendChild(h(5).textContent(paused[0] ? "Task paused" : "Step " + state.taskStep() + ": " + state.activeArea()))
          .appendChild(p().textContent(paused[0] ? "Your progress is saved and the task can be resumed." : "Secondary navigation is hidden so the user can focus on the current task."));
      footer.clearElement()
          .appendChild(PageLayoutSupport.action(paused[0] ? "Resume" : "Pause", () -> { paused[0] = !paused[0]; render[0].run(); }))
          .appendChild(PageLayoutSupport.action("Save draft", () -> content.appendChild(p().textContent("Draft saved."))))
          .appendChild(PageLayoutSupport.action(state.taskStep() == 3 ? "Complete task" : "Continue", () -> { state.advanceTask(); render[0].run(); }));
    };
    root.appendChild(PageLayoutSupport.header(
        "Focused task shell", "Complete review", "A reduced shell gives one workflow the full viewport and makes pause, save, and completion states explicit."))
        .appendChild(progress)
        .appendChild(content)
        .appendChild(footer);
    render[0].run();
    return PageLayoutSampleElement.create(root);
  }
}
