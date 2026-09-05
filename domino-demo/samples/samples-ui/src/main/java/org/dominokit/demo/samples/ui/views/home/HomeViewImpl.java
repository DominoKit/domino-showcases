package org.dominokit.demo.samples.ui.views.home;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.views.home.HomeView;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView
public class HomeViewImpl extends BrixView<HTMLDivElement, HomeView.HomeUiHandlers>
    implements HomeView {

  private final DivElement root;

  @Inject
  public HomeViewImpl() {
    this.root =
        div()
            .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(createHeroSection())
            .appendChild(
                BlockHeader.create(
                    "Featured areas",
                    "Jump into the demo the way you would approach a real product home page: by workflow, not by a flat list of widgets."))
            .appendChild(createFeaturedAreasGrid())
            .appendChild(
                BlockHeader.create(
                    "Next steps",
                    "A few suggested paths if you want to move from individual widgets into full screen composition."))
            .appendChild(createGuidanceGrid());
    init(this);
  }

  private DivElement createHeroSection() {
    return div()
        .addCss("demo-home-hero")
        .style(
            "padding:32px;"
                + "display:grid;"
                + "grid-template-columns:repeat(auto-fit,minmax(280px,1fr));"
                + "gap:24px;"
                )
        .appendChild(
            div()
                .addCss(dui_flex, dui_flex_col, dui_gap_2)
                .appendChild(
                    span()
                        .textContent("DOMINO DEMO")
                        .addCss("demo-home-hero-badge")
                        .style(
                            "display:inline-flex;"
                                + "width:max-content;"
                                + "padding:6px 12px;"
                                + "border-radius:999px;"
                                + "letter-spacing:0.12em;"
                                + "font-size:12px;"
                                + "font-weight:700;"))
                .appendChild(
                    h(2)
                        .textContent("Build polished enterprise interfaces with Domino UI.")
                        .addCss("demo-home-hero-title")
                        .style("margin:0;font-size:2.2rem;line-height:1.15;"))
                .appendChild(
                    p()
                        .textContent(
                            "Domino UI gives Java teams a rich set of components, layouts, forms, data views, and styling primitives for building consistent web applications with a strong product feel.")
                        .addCss("demo-home-hero-description")
                        .style("margin:0;font-size:1rem;line-height:1.7;"))
                .appendChild(
                    p()
                        .textContent(
                            "This demo highlights how those pieces come together across common application screens, from navigation and forms to data-heavy workflows, while the DominoKit website provides the broader docs and ecosystem context.")
                        .addCss("demo-home-hero-secondary")
                        .style("margin:0;font-size:0.98rem;line-height:1.7;"))
                .appendChild(
                    actionRow(
                        routeShortcut("Open Buttons", () -> handlers().openButtons()),
                        routeShortcut("Explore Forms", () -> handlers().openBasicFormElements()),
                        routeShortcut("View Tables", () -> handlers().openBasicDataTable()),
                        externalShortcut("Visit DominoKit", "https://dominokit.com/"))))
        .appendChild(
            div()
                .style(
                    "display:grid;"
                        + "grid-template-columns:repeat(auto-fit,minmax(180px,1fr));"
                        + "gap:12px;"
                        + "align-content:start;")
                .appendChild(
                    heroTile(
                        "Components",
                        "Buttons, alerts, cards, trees, and the building blocks used by dashboard-style screens."))
                .appendChild(
                    heroTile(
                        "Forms",
                        "Basic fields, structured inputs, and stepper-based flows for task completion journeys."))
                .appendChild(
                    heroTile(
                        "Data",
                        "Tables, plugins, and benchmark comparisons for information-dense application surfaces."))
                .appendChild(
                    heroTile(
                        "Resources",
                        "A direct path back to dominokit.com for docs, product context, and the broader ecosystem.")));
  }

  private DivElement createFeaturedAreasGrid() {
    return grid()
        .appendChild(
            Card.create(
                    "Component workspace",
                    "Common interaction primitives collected into a single, easy start point.")
                .appendChild(
                    p()
                        .textContent(
                            "Start here if you want immediate visual feedback. These samples cover interactive UI elements that appear on nearly every business-facing screen."))
                .appendChild(
                    actionRow(
                        routeShortcut("Alerts", () -> handlers().openAlerts()),
                        routeShortcut("Buttons", () -> handlers().openButtons()),
                        routeShortcut("Cards", () -> handlers().openCards()))))
        .appendChild(
            Card.create(
                    "Forms workflow",
                    "Field composition, richer inputs, and guided step-by-step interactions.")
                .appendChild(
                    p()
                        .textContent(
                            "Use this slice when you are building onboarding, settings, or approval flows and want to move beyond isolated field examples."))
                .appendChild(
                    actionRow(
                        routeShortcut("Basic elements", () -> handlers().openBasicFormElements()),
                        routeShortcut("Input fields", () -> handlers().openInputFields()),
                        routeShortcut("Steppers", () -> handlers().openSteppers()))))
        .appendChild(
            Card.create(
                    "Data and tables",
                    "Simple table setups first, then deeper comparisons for heavier data screens.")
                .appendChild(
                    p()
                        .textContent(
                            "This is the best entry point for admin consoles, operational dashboards, and any page where sorting, scanning, or high row counts matter."))
                .appendChild(
                    actionRow(
                        routeShortcut("Basic table", () -> handlers().openBasicDataTable()),
                        routeShortcut("Benchmark table", () -> handlers().openBenchmarkTable()))))
        .appendChild(
            Card.create(
                    "Design foundations",
                    "The visual system behind the demo, from colors to icons to typography.")
                .appendChild(
                    p()
                        .textContent(
                            "Keep these references nearby while designing a screen so the component pages and the styling primitives stay aligned."))
                .appendChild(
                    actionRow(
                        routeShortcut("Colors", () -> handlers().openColors()),
                        routeShortcut("Icons", () -> handlers().openIcons()),
                        routeShortcut("Typography", () -> handlers().openTypography()))));
  }

  private DivElement createGuidanceGrid() {
    return grid()
        .appendChild(
            Card.create(
                    "Suggested journeys",
                    "A few realistic routes through the demo when you want to assemble an entire page instead of opening random samples.")
                .appendChild(
                    h(5)
                        .textContent("Compose a shell and layout")
                        .addCss("demo-home-guidance-title")
                        .style("margin:0 0 8px 0;"))
                .appendChild(
                    p()
                        .textContent(
                            "Start with layout samples to decide how navigation, side panels, and content regions should be organized for the screen you have in mind."))
                .appendChild(
                    actionRow(
                        routeShortcut("Flex layout", () -> handlers().openFlexLayout()),
                        routeShortcut("App layout", () -> handlers().openAppLayout())))
                .appendChild(
                    h(5)
                        .textContent("Move into data-heavy pages")
                        .addCss("demo-home-guidance-title")
                        .style("margin:16px 0 8px 0;"))
                .appendChild(
                    p()
                        .textContent(
                            "Once the shell is in place, continue into the table samples to evaluate how information density, plugin combinations, and rendering cost affect the user experience."))
                .appendChild(
                    actionRow(
                        routeShortcut("Basic table", () -> handlers().openBasicDataTable()),
                        routeShortcut("Benchmark table", () -> handlers().openBenchmarkTable()))))
        .appendChild(
            Card.create(
                    "Resource center",
                    "A small set of links you would normally expect from a real application home page: product site, docs, and project references.")
                .appendChild(
                    p()
                        .textContent(
                            "The demo focuses on runnable examples, while the DominoKit website provides the broader narrative, documentation, and ecosystem entry points."))
                .appendChild(
                    p()
                        .textContent(
                            "Keep both open if you are evaluating components for a real app: the demo shows behavior, and the website fills in the product story and reference material."))
                .appendChild(
                    actionRow(
                        externalShortcut("dominokit.com", "https://dominokit.com/"),
                        externalShortcut(
                            "Domino UI Docs",
                            "https://dominokit.com/solutions/domino-ui/v2/docs/"),
                        externalShortcut("GitHub", "https://github.com/DominoKit"))));
  }

  private DivElement heroTile(String title, String description) {
    return div()
        .addCss("demo-home-hero-tile")
        .style(
            "padding:18px;"
                + "backdrop-filter:blur(8px);")
        .appendChild(
            h(5).textContent(title).addCss("demo-home-hero-tile-title").style("margin:0 0 8px 0;"))
        .appendChild(
            p()
                .textContent(description)
                .addCss("demo-home-hero-tile-description")
                .style("margin:0;line-height:1.6;"));
  }

  private DivElement grid() {
    return div()
        .style(
            "display:grid;"
                + "grid-template-columns:repeat(auto-fit,minmax(280px,1fr));"
                + "gap:16px;");
  }

  private DivElement actionRow(LinkButton... buttons) {
    DivElement actions =
        div().style("display:flex;flex-wrap:wrap;gap:10px;align-items:center;margin-top:12px;");
    for (LinkButton button : buttons) {
      actions.appendChild(button);
    }
    return actions;
  }

  private LinkButton routeShortcut(String label, Runnable action) {
    LinkButton linkButton = LinkButton.create(label).removeHref();
    linkButton.addClickListener(
        evt -> {
          evt.preventDefault();
          action.run();
        });
    return linkButton;
  }

  private LinkButton externalShortcut(String label, String href) {
    LinkButton linkButton = LinkButton.create(label);
    linkButton.getClickableElement().setAttribute("href", href);
    linkButton.getClickableElement().setAttribute("target", "_blank");
    linkButton.getClickableElement().setAttribute("rel", "noopener noreferrer");
    return linkButton;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
