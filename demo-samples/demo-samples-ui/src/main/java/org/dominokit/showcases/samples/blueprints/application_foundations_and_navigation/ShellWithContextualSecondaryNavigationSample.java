package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.elements.DivElement;

public final class ShellWithContextualSecondaryNavigationSample {

  private ShellWithContextualSecondaryNavigationSample() {}

  public static ApplicationFoundationSampleElement create() {
    ApplicationFoundationState state = ApplicationFoundationState.create("Overview", "Operations", 3);
    DivElement root = ApplicationFoundationSupport.root();
    DivElement content = ApplicationFoundationSupport.bordered("");
    DivElement tabs = ApplicationFoundationSupport.row();
    for (String section : new String[] {"Overview", "Activity", "Permissions"}) {
      tabs.appendChild(ApplicationFoundationSupport.action(section, () -> {
        state.selectArea(section);
        renderContent(content, state);
      }));
    }
    root.appendChild(ApplicationFoundationSupport.header(
        "Contextual navigation", "Customer account", "The primary shell stays stable while a page-level navigation bar changes the current record section."))
        .appendChild(ApplicationFoundationSupport.surface("Account shell", "Global navigation and the selected account remain in context.")
            .appendChild(tabs)
            .appendChild(content));
    renderContent(content, state);
    return ApplicationFoundationSampleElement.create(root);
  }

  private static void renderContent(DivElement content, ApplicationFoundationState state) {
    content.clearElement();
    content.appendChild(p().textContent(
        state.activeArea() + " content is rendered below the contextual navigation without leaving the account."));
  }
}
