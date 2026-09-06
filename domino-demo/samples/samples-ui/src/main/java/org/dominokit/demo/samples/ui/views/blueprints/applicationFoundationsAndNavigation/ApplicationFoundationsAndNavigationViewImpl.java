package org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.ApplicationFoundationsAndNavigationView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.ShellWithPersistentNavigationSample;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.ShellWithContextualSecondaryNavigationSample;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.WorkspaceWithResizableNavigationPaneSample;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.BreadcrumbAndBackStackWorkspaceSample;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.CommandPaletteApplicationSample;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.MultiWorkspaceApplicationSample;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.SplitViewNavigationShellSample;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.FullScreenFocusedTaskShellSample;

@UiView
public class ApplicationFoundationsAndNavigationViewImpl extends BrixView<HTMLDivElement, ApplicationFoundationsAndNavigationView.ApplicationFoundationsAndNavigationUiHandlers>
    implements ApplicationFoundationsAndNavigationView {

  private final DivElement root;

  @Inject
  public ApplicationFoundationsAndNavigationViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Application foundations and navigation",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Shell with persistent navigation",
                    "Layout: Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region. Interaction: Users switch modules from the navigation while the shell preserves context, theme, and session actions. Variants: Fixed or overlay navigation; compact icon rail; mobile drawer.",
                    ShellWithPersistentNavigationSample.class,
                    ShellWithPersistentNavigationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Shell with contextual secondary navigation",
                    "Layout: Global shell plus a page-level tab or sub-navigation bar below the primary header. Interaction: Users move between related views without losing the selected parent record or module. Variants: Horizontal tabs, vertical section navigation, or a local navigation drawer.",
                    ShellWithContextualSecondaryNavigationSample.class,
                    ShellWithContextualSecondaryNavigationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Workspace with resizable navigation pane",
                    "Layout: Main content is paired with a draggable navigation or folder pane. Interaction: Users resize, collapse, pin, and select nodes while the content pane updates. Variants: File tree, project tree, saved-search tree, or queue navigation.",
                    WorkspaceWithResizableNavigationPaneSample.class,
                    WorkspaceWithResizableNavigationPaneSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Breadcrumb and back-stack workspace",
                    "Layout: A compact breadcrumb and back control sit above content, with no permanent side navigation required. Interaction: Users traverse nested records and return to prior contexts without rebuilding the full search state. Variants: Breadcrumb-only, breadcrumb plus history menu, or breadcrumb plus split view.",
                    BreadcrumbAndBackStackWorkspaceSample.class,
                    BreadcrumbAndBackStackWorkspaceSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Command palette application",
                    "Layout: Minimal shell with a global command/search trigger and an optional keyboard-shortcut hint. Interaction: Users search for pages, records, actions, or settings and execute commands without navigating menus. Variants: Modal palette, inline command bar, or command palette with recent actions.",
                    CommandPaletteApplicationSample.class,
                    CommandPaletteApplicationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Multi-workspace application",
                    "Layout: A global workspace switcher controls the active tenant, project, environment, or business unit. Interaction: Users switch contexts and the shell refreshes navigation, permissions, filters, and data. Variants: Dropdown switcher, tabbed workspaces, or recent-workspace launcher.",
                    MultiWorkspaceApplicationSample.class,
                    MultiWorkspaceApplicationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Split-view navigation shell",
                    "Layout: A list or tree remains visible beside a detail/content pane. Interaction: Selecting an item updates the detail pane while preserving the navigation list and its scroll position. Variants: Fixed split, resizable split, or mobile drill-in with back navigation.",
                    SplitViewNavigationShellSample.class,
                    SplitViewNavigationShellSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Full-screen focused task shell",
                    "Layout: A reduced shell hides secondary navigation and gives one task or workflow most of the viewport. Interaction: Users complete, pause, save, or abandon the focused task. Variants: Wizard shell, review shell, or distraction-free editor.",
                    FullScreenFocusedTaskShellSample.class,
                    FullScreenFocusedTaskShellSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
