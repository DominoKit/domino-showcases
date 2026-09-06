package org.dominokit.showcases.samples.blueprints;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BlueprintSampleCanvas extends BaseDominoElement<HTMLDivElement, BlueprintSampleCanvas> {

  private final DivElement root;

  public static BlueprintSampleCanvas create(
      String title, String description, BlueprintSampleKind kind, String... regions) {
    return new BlueprintSampleCanvas(title, description, kind, regions);
  }

  private BlueprintSampleCanvas(
      String title, String description, BlueprintSampleKind kind, String[] regions) {
    DivElement feedback = div().textContent("Ready for interaction");
    this.root = div().addCss(dui_flex, dui_flex_col, dui_gap_4, dui_p_4)
        .appendChild(h(4).textContent(title))
        .appendChild(p().textContent(description))
        .appendChild(renderComposition(kind, regions))
        .appendChild(Card.create("Interaction notes", "Representative controls for this composition.")
            .appendChild(div().addCss(dui_flex, dui_gap_4)
                .appendChild(Button.create(actionLabel(kind)).addClickListener(evt -> feedback.textContent("Action completed")))
                .appendChild(Button.create("Refresh").addClickListener(evt -> feedback.textContent("Content refreshed")))
                .appendChild(feedback)));
    init(this);
  }

  private DivElement renderComposition(BlueprintSampleKind kind, String[] regions) {
    switch (kind) {
      case NAVIGATION:
        return twoColumn("Navigation", "Workspace", regions);
      case DETAIL:
        return twoColumn("Record list", "Selected record", regions);
      case SCHEDULING:
        return twoColumn("Resources and filters", "Time-based schedule", regions);
      case CONTENT:
        return twoColumn("Folders and filters", "Preview or editor", regions);
      case ADMINISTRATION:
        return twoColumn("Scope and roles", "Policy or configuration", regions);
      case DASHBOARD:
      case REPORT:
      case OPERATIONS:
        return dashboard(regions);
      case FORM:
      case WORKFLOW:
      case BULK:
      case STATE:
      case CRUD:
      default:
        return grid(regions);
    }
  }

  private DivElement twoColumn(String leftTitle, String rightTitle, String[] regions) {
    DivElement layout = div().css("display: grid; grid-template-columns: minmax(160px, 1fr) minmax(260px, 2fr); gap: 12px;");
    layout.appendChild(BlueprintSampleSupport.panel(leftTitle, value(regions, 0)));
    layout.appendChild(BlueprintSampleSupport.panel(rightTitle, value(regions, 1)));
    return layout;
  }

  private DivElement dashboard(String[] regions) {
    DivElement layout = div().css("display: grid; grid-template-columns: repeat(auto-fit, minmax(170px, 1fr)); gap: 12px;");
    for (int i = 0; i < Math.max(4, regions.length); i++) {
      layout.appendChild(BlueprintSampleSupport.panel(i < regions.length ? regions[i] : "Supporting insight", metric(i)));
    }
    return layout;
  }

  private DivElement grid(String[] regions) {
    DivElement layout = div().css("display: grid; grid-template-columns: repeat(auto-fit, minmax(220px, 1fr)); gap: 12px;");
    for (int i = 0; i < Math.max(3, regions.length); i++) {
      layout.appendChild(BlueprintSampleSupport.panel(i < regions.length ? regions[i] : "Secondary region", sampleRow(i)));
    }
    return layout;
  }

  private String value(String[] values, int index) {
    return values.length == 0 ? "Primary content region" : values[Math.min(index, values.length - 1)];
  }

  private String metric(int index) {
    return BlueprintFixtures.metrics().get(index % BlueprintFixtures.metrics().size()) + " · live sample data";
  }

  private String sampleRow(int index) {
    return BlueprintFixtures.records().get(index % BlueprintFixtures.records().size()) + " · "
        + BlueprintFixtures.statuses().get(index % BlueprintFixtures.statuses().size());
  }

  private String actionLabel(BlueprintSampleKind kind) {
    switch (kind) {
      case FORM:
        return "Save changes";
      case WORKFLOW:
        return "Advance workflow";
      case REPORT:
        return "Run report";
      case SCHEDULING:
        return "Create booking";
      case BULK:
        return "Review operation";
      case STATE:
        return "Try recovery";
      default:
        return "Open primary action";
    }
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
