package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;

public final class SplitViewNavigationShellSample {

  private SplitViewNavigationShellSample() {}

  public static ApplicationFoundationSampleElement create() {
    ApplicationFoundationState state = ApplicationFoundationState.create("Northwind", "Operations", 3);
    DivElement root = ApplicationFoundationSupport.root();
    DivElement detail = ApplicationFoundationSupport.bordered("");
    DivElement list = ApplicationFoundationSupport.stack();
    for (String item : new String[] {"Northwind", "Contoso", "Fabrikam", "Adventure Works"}) {
      list.appendChild(Button.create(item).addClickListener(event -> {
        state.selectArea(item);
        renderDetail(detail, state);
      }));
    }
    root.appendChild(ApplicationFoundationSupport.header(
        "Split-view shell", "Account directory", "The navigation list stays mounted beside the detail pane so selection does not destroy list context."))
        .appendChild(ApplicationFoundationSupport.grid("220px minmax(0, 1fr)")
            .appendChild(ApplicationFoundationSupport.surface("Accounts", "Select an account to inspect it.").appendChild(list))
            .appendChild(detail));
    renderDetail(detail, state);
    return ApplicationFoundationSampleElement.create(root);
  }

  private static void renderDetail(DivElement detail, ApplicationFoundationState state) {
    detail.clearElement().appendChild(h(5).textContent(state.activeArea()))
        .appendChild(p().textContent("The selected account opens here while the directory remains visible."));
  }
}
