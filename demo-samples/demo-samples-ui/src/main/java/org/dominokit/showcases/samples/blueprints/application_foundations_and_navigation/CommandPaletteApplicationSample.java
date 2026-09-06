package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;

public final class CommandPaletteApplicationSample {

  private CommandPaletteApplicationSample() {}

  public static ApplicationFoundationSampleElement create() {
    DivElement root = ApplicationFoundationSupport.root();
    DivElement palette = ApplicationFoundationSupport.bordered("");
    Button toggle = Button.create("Open command palette");
    TextBox search = TextBox.create("Search commands");
    boolean[] open = {false};
    String[] commands = {"Open dashboard", "Create work item", "Search accounts", "Manage settings"};
    Runnable renderCommands = () -> {
      palette.clearElement();
      if (!open[0]) {
        palette.appendChild(p().textContent("The command palette is closed. Use the trigger or keyboard shortcut to open it."));
        toggle.setText("Open command palette");
        return;
      }
      toggle.setText("Close command palette");
      palette.appendChild(search);
      String query = search.getValue() == null ? "" : search.getValue().toLowerCase();
      for (String command : commands) {
        if (query.isEmpty() || command.toLowerCase().contains(query)) {
          palette.appendChild(Button.create(command).addClickListener(event -> {
            open[0] = false;
            palette.clearElement().appendChild(p().textContent("Executed: " + command));
            toggle.setText("Open command palette");
          }));
        }
      }
      if (palette.element().childElementCount == 1) {
        palette.appendChild(p().textContent("No commands match the current search."));
      }
    };
    search.withInputElement((parent, input) -> input.onKeyUp(event -> renderCommands.run()));
    toggle.addClickListener(event -> { open[0] = !open[0]; renderCommands.run(); });
    root.appendChild(ApplicationFoundationSupport.header(
        "Command-driven shell", "Quick actions", "A minimal application shell lets users reach pages, records, and actions without navigating a deep menu."))
        .appendChild(ApplicationFoundationSupport.row().appendChild(toggle).appendChild(p().textContent("Shortcut: Ctrl/⌘ + K")))
        .appendChild(palette);
    renderCommands.run();
    return ApplicationFoundationSampleElement.create(root);
  }
}
