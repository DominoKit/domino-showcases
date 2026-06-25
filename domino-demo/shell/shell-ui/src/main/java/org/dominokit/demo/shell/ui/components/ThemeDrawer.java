package org.dominokit.demo.shell.ui.components;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_amber;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_brown;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_deep_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_deep_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_green;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_indigo;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_light_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_light_green;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_lime;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_red;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_yellow;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeDark;
import org.dominokit.domino.ui.themes.DominoThemeLight;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.themes.IsDominoTheme;
import org.dominokit.domino.ui.typography.BlockHeader;

public class ThemeDrawer implements IsElement<HTMLDivElement> {

  private final DivElement root;
  private final DivElement lightModeOption;
  private final DivElement darkModeOption;
  private final List<AccentSwatch> accentSwatches = new ArrayList<>();

  private ThemeDrawer() {
    lightModeOption =
        createModeOption(
            "Light",
            "A bright default surface palette suited for documentation, forms, and operational dashboards.",
            DominoThemeLight.INSTANCE);
    darkModeOption =
        createModeOption(
            "Dark",
            "A darker contrast profile for long sessions, control rooms, and low-light environments.",
            DominoThemeDark.INSTANCE);

    DivElement accentGrid = div().addCss(dui_flex, dui_flex_wrap).style("gap:10px;");
    addAccentSwatch(accentGrid, "Red", dui_bg_red, DominoThemeAccent.RED);
    addAccentSwatch(accentGrid, "Pink", dui_bg_pink, DominoThemeAccent.PINK);
    addAccentSwatch(accentGrid, "Purple", dui_bg_purple, DominoThemeAccent.PURPLE);
    addAccentSwatch(accentGrid, "Deep Purple", dui_bg_deep_purple, DominoThemeAccent.DEEP_PURPLE);
    addAccentSwatch(accentGrid, "Indigo", dui_bg_indigo, DominoThemeAccent.INDIGO);
    addAccentSwatch(accentGrid, "Blue", dui_bg_blue, DominoThemeAccent.BLUE);
    addAccentSwatch(accentGrid, "Light Blue", dui_bg_light_blue, DominoThemeAccent.LIGHT_BLUE);
    addAccentSwatch(accentGrid, "Cyan", dui_bg_cyan, DominoThemeAccent.CYAN);
    addAccentSwatch(accentGrid, "Teal", dui_bg_teal, DominoThemeAccent.TEAL);
    addAccentSwatch(accentGrid, "Green", dui_bg_green, DominoThemeAccent.GREEN);
    addAccentSwatch(accentGrid, "Light Green", dui_bg_light_green, DominoThemeAccent.LIGHT_GREEN);
    addAccentSwatch(accentGrid, "Lime", dui_bg_lime, DominoThemeAccent.LIME);
    addAccentSwatch(accentGrid, "Yellow", dui_bg_yellow, DominoThemeAccent.YELLOW);
    addAccentSwatch(accentGrid, "Amber", dui_bg_amber, DominoThemeAccent.AMBER);
    addAccentSwatch(accentGrid, "Orange", dui_bg_orange, DominoThemeAccent.ORANGE);
    addAccentSwatch(accentGrid, "Deep Orange", dui_bg_deep_orange, DominoThemeAccent.DEEP_ORANGE);
    addAccentSwatch(accentGrid, "Brown", dui_bg_brown, DominoThemeAccent.BROWN);
    addAccentSwatch(accentGrid, "Grey", dui_bg_grey, DominoThemeAccent.GREY);
    addAccentSwatch(accentGrid, "Blue Grey", dui_bg_blue_grey, DominoThemeAccent.BLUE_GREY);

    root =
        div()
            .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(
                BlockHeader.create(
                    "Theme settings",
                    "Switch the color mode and accent applied across the demo. Selections are stored locally and restored on the next visit."))
            .appendChild(
                Card.create(
                        "Color mode",
                        "Choose the overall contrast profile for the shell, pages, and components.")
                    .appendChild(
                        div()
                            .style(
                                "display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:12px;")
                            .appendChild(lightModeOption)
                            .appendChild(darkModeOption)))
            .appendChild(
                Card.create(
                        "Accent color",
                        "Pick the accent used by buttons, highlights, links, and emphasis states throughout Domino UI.")
                    .appendChild(accentGrid));

    refreshSelectionState();
  }

  public static ThemeDrawer create() {
    return new ThemeDrawer();
  }

  private DivElement createModeOption(String label, String description, IsDominoTheme theme) {
    DivElement option =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_2)
            .style("padding:14px;border-radius:16px;cursor:pointer;transition:all 160ms ease;")
            .appendChild(h(5).textContent(label).style("margin:0;"))
            .appendChild(p().textContent(description).style("margin:0;opacity:0.82;line-height:1.6;"));

    option.addClickListener(
        evt -> {
          DominoThemeManager.INSTANCE.apply(theme);
          refreshSelectionState();
        });

    return option;
  }

  private void addAccentSwatch(
      DivElement accentGrid, String label, CssClass background, IsDominoTheme theme) {
    DivElement swatch =
        div()
            .addCss(background)
            .style(
                "width:28px;height:28px;border-radius:10px;border:2px solid transparent;"
                    + "cursor:pointer;transition:transform 120ms ease,box-shadow 120ms ease,border-color 120ms ease;")
            .setTooltip(label);

    swatch.addClickListener(
        evt -> {
          DominoThemeManager.INSTANCE.apply(theme);
          refreshSelectionState();
        });

    accentSwatches.add(new AccentSwatch(swatch, theme));
    accentGrid.appendChild(swatch);
  }

  private void refreshSelectionState() {
    styleModeOption(lightModeOption, DominoThemeLight.INSTANCE.isApplied(), false);
    styleModeOption(darkModeOption, DominoThemeDark.INSTANCE.isApplied(), true);
    accentSwatches.forEach(
        swatch -> styleAccentSwatch(swatch.element, swatch.theme.isApplied()));
  }

  private void styleModeOption(DivElement option, boolean active, boolean dark) {
    String background =
        dark
            ? active ? "#0f172a" : "#111827"
            : active ? "#ecfeff" : "#f8fafc";
    String border = active ? "#14b8a6" : "rgba(148,163,184,0.35)";
    String textColor = dark ? "#f8fafc" : "#0f172a";
    String shadow =
        active
            ? "0 12px 28px rgba(15,23,42,0.14),0 0 0 1px rgba(20,184,166,0.3)"
            : "none";

    option.style(
        "padding:14px;border-radius:16px;border:2px solid "
            + border
            + ";background:"
            + background
            + ";color:"
            + textColor
            + ";cursor:pointer;transition:all 160ms ease;box-shadow:"
            + shadow
            + ";");
  }

  private void styleAccentSwatch(DivElement swatch, boolean active) {
    swatch.style(
        "width:28px;height:28px;border-radius:10px;border:2px solid "
            + (active ? "#ffffff" : "transparent")
            + ";cursor:pointer;transition:transform 120ms ease,box-shadow 120ms ease,border-color 120ms ease;"
            + "box-shadow:"
            + (active ? "0 0 0 2px rgba(15,23,42,0.65)" : "none")
            + ";transform:"
            + (active ? "scale(1.08)" : "scale(1)")
            + ";");
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  private static final class AccentSwatch {
    private final DivElement element;
    private final IsDominoTheme theme;

    private AccentSwatch(DivElement element, IsDominoTheme theme) {
      this.element = element;
      this.theme = theme;
    }
  }
}
