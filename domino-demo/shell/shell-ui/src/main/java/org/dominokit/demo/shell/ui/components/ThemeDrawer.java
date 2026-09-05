package org.dominokit.demo.shell.ui.components;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_amber;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_brown;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_cobalt;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_coral;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_deep_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_deep_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_emerald;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_green;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_indigo;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_light_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_light_green;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_lime;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_plum;
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
import static org.dominokit.domino.ui.utils.Domino.body;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.Storage;
import elemental2.webstorage.WebStorageWindow;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeCharacter;
import org.dominokit.domino.ui.themes.DominoThemeDark;
import org.dominokit.domino.ui.themes.DominoThemeDensity;
import org.dominokit.domino.ui.themes.DominoThemeIdentity;
import org.dominokit.domino.ui.themes.DominoThemeLight;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.themes.DominoThemeSurface;
import org.dominokit.domino.ui.themes.IsDominoTheme;
import org.dominokit.domino.ui.typography.BlockHeader;

public class ThemeDrawer implements IsElement<HTMLDivElement> {

  private static final String THEME_OPTION_CLASS = "demo-theme-option";
  private static final String MODE_OPTION_CLASS = "demo-mode-option";
  private static final String ACCENT_SWATCH_CLASS = "demo-accent-swatch";
  private static final String ACTIVE_OPTION_CLASS = "demo-option-active";
  private static final String LEGACY_THEME_STYLE_STORAGE_KEY = "domino-demo-theme-style";
  private static final String THEME_DENSITY_STORAGE_KEY = "domino-demo-theme-density";
  private static final String THEME_SURFACE_STORAGE_KEY = "domino-demo-theme-surface";
  private static final String THEME_CHARACTER_STORAGE_KEY = "domino-demo-theme-character";
  private static final String VISUAL_THEME_STORAGE_KEY = "domino-demo-visual-theme";
  private static final String COMPACT_THEME_CLASS = DominoThemeDensity.COMPACT.getName();
  private static final String BORDERED_THEME_CLASS = DominoThemeSurface.BORDERED.getName();
  private static final String ELEVATED_THEME_CLASS = DominoThemeSurface.ELEVATED.getName();
  private static final String ROUNDED_THEME_CLASS = DominoThemeSurface.ROUNDED.getName();
  private static final String LEGACY_ISLAND_THEME_CLASS = "dui-theme-island-lab";
  private static final String OCEAN_THEME_CLASS = DominoThemeIdentity.OCEAN.getName();
  private static final String FOREST_THEME_CLASS = DominoThemeIdentity.FOREST.getName();
  private static final String SANDSTONE_THEME_CLASS = DominoThemeIdentity.SANDSTONE.getName();
  private static final String GRAPHITE_THEME_CLASS = DominoThemeIdentity.GRAPHITE.getName();
  private static final String LAVENDER_THEME_CLASS = DominoThemeIdentity.LAVENDER.getName();
  private static final String SUNSET_THEME_CLASS = DominoThemeIdentity.SUNSET.getName();
  private static final String ARCTIC_THEME_CLASS = DominoThemeIdentity.ARCTIC.getName();
  private static final String ROSE_THEME_CLASS = DominoThemeIdentity.ROSE.getName();
  private static final String CRIMSON_THEME_CLASS = DominoThemeIdentity.CRIMSON.getName();
  private static final String AMETHYST_THEME_CLASS = DominoThemeIdentity.AMETHYST.getName();
  private static final String INDIGO_THEME_CLASS = DominoThemeIdentity.INDIGO.getName();
  private static final String AZURE_THEME_CLASS = DominoThemeIdentity.AZURE.getName();
  private static final String LAGOON_THEME_CLASS = DominoThemeIdentity.LAGOON.getName();
  private static final String JADE_THEME_CLASS = DominoThemeIdentity.JADE.getName();
  private static final String MEADOW_THEME_CLASS = DominoThemeIdentity.MEADOW.getName();
  private static final String LIME_THEME_CLASS = DominoThemeIdentity.LIME.getName();
  private static final String MARIGOLD_THEME_CLASS = DominoThemeIdentity.MARIGOLD.getName();
  private static final String AMBER_THEME_CLASS = DominoThemeIdentity.AMBER.getName();
  private static final String CARBON_THEME_CLASS = DominoThemeCharacter.CARBON.getName();
  private static final String PAPER_THEME_CLASS = DominoThemeCharacter.PAPER.getName();
  private static final String TERMINAL_THEME_CLASS = DominoThemeCharacter.TERMINAL.getName();
  private static final String GLASS_THEME_CLASS = DominoThemeCharacter.GLASS.getName();
  private static final String BLUEPRINT_THEME_CLASS = DominoThemeCharacter.BLUEPRINT.getName();
  private static final String HIGH_CONTRAST_THEME_CLASS = DominoThemeCharacter.HIGH_CONTRAST.getName();
  private static final String EDITORIAL_THEME_CLASS = DominoThemeCharacter.EDITORIAL.getName();
  private static final String SOFT_UI_THEME_CLASS = DominoThemeCharacter.SOFT_UI.getName();
  private static final String NEON_NIGHT_THEME_CLASS = DominoThemeCharacter.NEON_NIGHT.getName();
  private static final String RETRO_CONSOLE_THEME_CLASS = DominoThemeCharacter.RETRO_CONSOLE.getName();
  private static final String AURORA_THEME_CLASS = DominoThemeCharacter.AURORA.getName();

  private final DivElement root;
  private final DivElement defaultDensityOption;
  private final DivElement compactDensityOption;
  private final DivElement defaultSurfaceOption;
  private final DivElement borderedSurfaceOption;
  private final DivElement elevatedSurfaceOption;
  private final DivElement roundedSurfaceOption;
  private final DivElement defaultCharacterThemeOption;
  private final DivElement carbonThemeOption;
  private final DivElement paperThemeOption;
  private final DivElement terminalThemeOption;
  private final DivElement glassThemeOption;
  private final DivElement blueprintThemeOption;
  private final DivElement highContrastThemeOption;
  private final DivElement editorialThemeOption;
  private final DivElement softUiThemeOption;
  private final DivElement neonNightThemeOption;
  private final DivElement retroConsoleThemeOption;
  private final DivElement auroraThemeOption;
  private final DivElement defaultVisualThemeOption;
  private final DivElement oceanThemeOption;
  private final DivElement forestThemeOption;
  private final DivElement sandstoneThemeOption;
  private final DivElement graphiteThemeOption;
  private final DivElement lavenderThemeOption;
  private final DivElement sunsetThemeOption;
  private final DivElement arcticThemeOption;
  private final DivElement roseThemeOption;
  private final DivElement crimsonThemeOption;
  private final DivElement amethystThemeOption;
  private final DivElement indigoThemeOption;
  private final DivElement azureThemeOption;
  private final DivElement lagoonThemeOption;
  private final DivElement jadeThemeOption;
  private final DivElement meadowThemeOption;
  private final DivElement limeThemeOption;
  private final DivElement marigoldThemeOption;
  private final DivElement amberThemeOption;
  private final DivElement lightModeOption;
  private final DivElement darkModeOption;
  private final List<AccentSwatch> accentSwatches = new ArrayList<>();

  private ThemeDrawer() {
    restoreThemePreferences();

    defaultDensityOption = createThemeOption("Default", "", ThemeCategory.DENSITY);
    compactDensityOption = createThemeOption("Compact", COMPACT_THEME_CLASS, ThemeCategory.DENSITY);
    defaultSurfaceOption = createThemeOption("Default", "", ThemeCategory.SURFACE);
    borderedSurfaceOption =
        createThemeOption("Bordered", BORDERED_THEME_CLASS, ThemeCategory.SURFACE);
    elevatedSurfaceOption =
        createThemeOption("Elevated", ELEVATED_THEME_CLASS, ThemeCategory.SURFACE);
    roundedSurfaceOption =
        createThemeOption("Rounded", ROUNDED_THEME_CLASS, ThemeCategory.SURFACE);
    defaultCharacterThemeOption = createThemeOption("Default", "", ThemeCategory.CHARACTER);
    carbonThemeOption = createThemeOption("Carbon", CARBON_THEME_CLASS, ThemeCategory.CHARACTER);
    paperThemeOption = createThemeOption("Paper", PAPER_THEME_CLASS, ThemeCategory.CHARACTER);
    terminalThemeOption =
        createThemeOption("Terminal", TERMINAL_THEME_CLASS, ThemeCategory.CHARACTER);
    glassThemeOption = createThemeOption("Glass", GLASS_THEME_CLASS, ThemeCategory.CHARACTER);
    blueprintThemeOption =
        createThemeOption("Blueprint", BLUEPRINT_THEME_CLASS, ThemeCategory.CHARACTER);
    highContrastThemeOption =
        createThemeOption("High Contrast", HIGH_CONTRAST_THEME_CLASS, ThemeCategory.CHARACTER);
    editorialThemeOption =
        createThemeOption("Editorial", EDITORIAL_THEME_CLASS, ThemeCategory.CHARACTER);
    softUiThemeOption = createThemeOption("Soft UI", SOFT_UI_THEME_CLASS, ThemeCategory.CHARACTER);
    neonNightThemeOption =
        createThemeOption("Neon Night", NEON_NIGHT_THEME_CLASS, ThemeCategory.CHARACTER);
    retroConsoleThemeOption =
        createThemeOption("Retro Console", RETRO_CONSOLE_THEME_CLASS, ThemeCategory.CHARACTER);
    auroraThemeOption = createThemeOption("Aurora", AURORA_THEME_CLASS, ThemeCategory.CHARACTER);
    defaultVisualThemeOption = createThemeOption("Default", "", ThemeCategory.VISUAL);
    oceanThemeOption = createThemeOption("Ocean", OCEAN_THEME_CLASS, ThemeCategory.VISUAL);
    forestThemeOption = createThemeOption("Forest", FOREST_THEME_CLASS, ThemeCategory.VISUAL);
    sandstoneThemeOption = createThemeOption("Sandstone", SANDSTONE_THEME_CLASS, ThemeCategory.VISUAL);
    graphiteThemeOption = createThemeOption("Graphite", GRAPHITE_THEME_CLASS, ThemeCategory.VISUAL);
    lavenderThemeOption = createThemeOption("Lavender", LAVENDER_THEME_CLASS, ThemeCategory.VISUAL);
    sunsetThemeOption = createThemeOption("Sunset", SUNSET_THEME_CLASS, ThemeCategory.VISUAL);
    arcticThemeOption = createThemeOption("Arctic", ARCTIC_THEME_CLASS, ThemeCategory.VISUAL);
    roseThemeOption = createThemeOption("Rose", ROSE_THEME_CLASS, ThemeCategory.VISUAL);
    crimsonThemeOption = createThemeOption("Crimson", CRIMSON_THEME_CLASS, ThemeCategory.VISUAL);
    amethystThemeOption = createThemeOption("Amethyst", AMETHYST_THEME_CLASS, ThemeCategory.VISUAL);
    indigoThemeOption = createThemeOption("Indigo", INDIGO_THEME_CLASS, ThemeCategory.VISUAL);
    azureThemeOption = createThemeOption("Azure", AZURE_THEME_CLASS, ThemeCategory.VISUAL);
    lagoonThemeOption = createThemeOption("Lagoon", LAGOON_THEME_CLASS, ThemeCategory.VISUAL);
    jadeThemeOption = createThemeOption("Jade", JADE_THEME_CLASS, ThemeCategory.VISUAL);
    meadowThemeOption = createThemeOption("Meadow", MEADOW_THEME_CLASS, ThemeCategory.VISUAL);
    limeThemeOption = createThemeOption("Lime", LIME_THEME_CLASS, ThemeCategory.VISUAL);
    marigoldThemeOption = createThemeOption("Marigold", MARIGOLD_THEME_CLASS, ThemeCategory.VISUAL);
    amberThemeOption = createThemeOption("Amber", AMBER_THEME_CLASS, ThemeCategory.VISUAL);

    lightModeOption =
        createModeOption(
            "Light",
            DominoThemeLight.INSTANCE);
    darkModeOption =
        createModeOption(
            "Dark",
            DominoThemeDark.INSTANCE);

    DivElement accentGrid = div().addCss(dui_flex, dui_flex_wrap).style("gap:10px;");
    addAccentSwatch(accentGrid, "Red", dui_bg_red, DominoThemeAccent.RED);
    addAccentSwatch(accentGrid, "Coral", dui_bg_coral, DominoThemeAccent.CORAL);
    addAccentSwatch(accentGrid, "Pink", dui_bg_pink, DominoThemeAccent.PINK);
    addAccentSwatch(accentGrid, "Purple", dui_bg_purple, DominoThemeAccent.PURPLE);
    addAccentSwatch(accentGrid, "Plum", dui_bg_plum, DominoThemeAccent.PLUM);
    addAccentSwatch(accentGrid, "Deep Purple", dui_bg_deep_purple, DominoThemeAccent.DEEP_PURPLE);
    addAccentSwatch(accentGrid, "Indigo", dui_bg_indigo, DominoThemeAccent.INDIGO);
    addAccentSwatch(accentGrid, "Blue", dui_bg_blue, DominoThemeAccent.BLUE);
    addAccentSwatch(accentGrid, "Cobalt", dui_bg_cobalt, DominoThemeAccent.COBALT);
    addAccentSwatch(accentGrid, "Light Blue", dui_bg_light_blue, DominoThemeAccent.LIGHT_BLUE);
    addAccentSwatch(accentGrid, "Cyan", dui_bg_cyan, DominoThemeAccent.CYAN);
    addAccentSwatch(accentGrid, "Teal", dui_bg_teal, DominoThemeAccent.TEAL);
    addAccentSwatch(accentGrid, "Green", dui_bg_green, DominoThemeAccent.GREEN);
    addAccentSwatch(accentGrid, "Emerald", dui_bg_emerald, DominoThemeAccent.EMERALD);
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
                    "Choose mode and accent. Preferences are saved."))
            .appendChild(
                Card.create(
                        "Density",
                        "Choose spacing and control density.")
                    .appendChild(
                        div()
                            .style(
                                "display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:8px;")
                            .appendChild(defaultDensityOption)
                            .appendChild(compactDensityOption)))
            .appendChild(
                Card.create(
                        "Surface style",
                        "Toggle surface treatments or clear them.")
                    .appendChild(
                        div()
                            .style(
                                "display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:8px;")
                            .appendChild(defaultSurfaceOption)
                            .appendChild(borderedSurfaceOption)
                            .appendChild(elevatedSurfaceOption)
                            .appendChild(roundedSurfaceOption)))
            .appendChild(
                Card.create(
                        "Visual identity",
                        "Choose the app's surface and text palette.")
                    .appendChild(
                        div()
                            .style(
                                "display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:8px;")
                            .appendChild(defaultVisualThemeOption)
                            .appendChild(oceanThemeOption)
                            .appendChild(forestThemeOption)
                            .appendChild(sandstoneThemeOption)
                            .appendChild(graphiteThemeOption)
                            .appendChild(lavenderThemeOption)
                            .appendChild(sunsetThemeOption)
                            .appendChild(arcticThemeOption)
                            .appendChild(roseThemeOption)
                            .appendChild(crimsonThemeOption)
                            .appendChild(amethystThemeOption)
                            .appendChild(indigoThemeOption)
                            .appendChild(azureThemeOption)
                            .appendChild(lagoonThemeOption)
                            .appendChild(jadeThemeOption)
                            .appendChild(meadowThemeOption)
                            .appendChild(limeThemeOption)
                            .appendChild(marigoldThemeOption)
                            .appendChild(amberThemeOption)))
            .appendChild(
                Card.create(
                        "Character",
                        "Choose the interface's visual character.")
                    .appendChild(
                        div()
                            .style(
                                "display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:8px;")
                            .appendChild(defaultCharacterThemeOption)
                            .appendChild(carbonThemeOption)
                            .appendChild(paperThemeOption)
                            .appendChild(terminalThemeOption)
                            .appendChild(glassThemeOption)
                            .appendChild(blueprintThemeOption)
                            .appendChild(highContrastThemeOption)
                            .appendChild(editorialThemeOption)
                            .appendChild(softUiThemeOption)
                            .appendChild(neonNightThemeOption)
                            .appendChild(retroConsoleThemeOption)
                            .appendChild(auroraThemeOption)))
            .appendChild(
                Card.create(
                        "Color mode",
                        "Choose light or dark mode.")
                    .appendChild(
                        div()
                            .style(
                                "display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:8px;")
                            .appendChild(lightModeOption)
                            .appendChild(darkModeOption)))
            .appendChild(
                Card.create(
                        "Accent color",
                        "Choose the accent for controls and highlights.")
                    .appendChild(accentGrid));

    refreshSelectionState();
  }

  public static ThemeDrawer create() {
    return new ThemeDrawer();
  }

  private DivElement createThemeOption(
      String label, String themeClass, ThemeCategory category) {
    DivElement option =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_2)
            .addCss(THEME_OPTION_CLASS)
            .appendChild(h(5).textContent(label).style("margin:0;"));

    option.addClickListener(
        evt -> {
          if (ThemeCategory.VISUAL == category) {
            applyVisualTheme(themeClass);
          } else if (ThemeCategory.SURFACE == category) {
            if (themeClass.isEmpty()) {
              clearSurfaceThemes();
            } else {
              toggleSurfaceTheme(themeClass);
            }
          } else if (ThemeCategory.CHARACTER == category) {
            applyCharacterTheme(themeClass);
          } else {
            applyDensityTheme(themeClass);
          }
          refreshSelectionState();
        });

    return option;
  }

  private void applyDensityTheme(String themeClass) {
    applyDensityTheme(themeClass, true);
  }

  private void applyDensityTheme(String themeClass, boolean persist) {
    String selectedTheme =
        COMPACT_THEME_CLASS.equals(canonicalThemeClass(themeClass)) ? COMPACT_THEME_CLASS : "";
    body().removeCss(COMPACT_THEME_CLASS);
    if (!selectedTheme.isEmpty()) {
      body().addCss(selectedTheme);
    }
    if (persist) {
      localStorage().setItem(THEME_DENSITY_STORAGE_KEY, selectedTheme);
    }
  }

  private void toggleSurfaceTheme(String themeClass) {
    toggleSurfaceTheme(themeClass, true);
  }

  private void toggleSurfaceTheme(String themeClass, boolean persist) {
    String selectedTheme = canonicalThemeClass(themeClass);
    selectedTheme =
        LEGACY_ISLAND_THEME_CLASS.equals(selectedTheme) ? BORDERED_THEME_CLASS : selectedTheme;
    if (!isKnownSurfaceTheme(selectedTheme)) {
      return;
    }
    body().removeCss(LEGACY_ISLAND_THEME_CLASS);
    if (body().element().classList.contains(selectedTheme)) {
      body().removeCss(selectedTheme);
    } else {
      body().addCss(selectedTheme);
    }
    if (persist) {
      persistSurfaceThemes();
    }
  }

  private void clearSurfaceThemes() {
    clearSurfaceThemes(true);
  }

  private void clearSurfaceThemes(boolean persist) {
    body().removeCss(BORDERED_THEME_CLASS);
    body().removeCss(ELEVATED_THEME_CLASS);
    body().removeCss(ROUNDED_THEME_CLASS);
    body().removeCss(LEGACY_ISLAND_THEME_CLASS);
    if (persist) {
      persistSurfaceThemes();
    }
  }

  private void persistSurfaceThemes() {
    String selectedThemes = "";
    if (body().element().classList.contains(BORDERED_THEME_CLASS)) {
      selectedThemes = BORDERED_THEME_CLASS;
    }
    if (body().element().classList.contains(ELEVATED_THEME_CLASS)) {
      selectedThemes = appendThemeClass(selectedThemes, ELEVATED_THEME_CLASS);
    }
    if (body().element().classList.contains(ROUNDED_THEME_CLASS)) {
      selectedThemes = appendThemeClass(selectedThemes, ROUNDED_THEME_CLASS);
    }
    localStorage().setItem(THEME_SURFACE_STORAGE_KEY, selectedThemes);
  }

  private String appendThemeClass(String selectedThemes, String themeClass) {
    return selectedThemes.isEmpty() ? themeClass : selectedThemes + " " + themeClass;
  }

  private void applyVisualTheme(String themeClass) {
    applyVisualTheme(themeClass, true);
  }

  private void applyCharacterTheme(String themeClass) {
    applyCharacterTheme(themeClass, true);
  }

  private void applyCharacterTheme(String themeClass, boolean persist) {
    String canonicalTheme = canonicalThemeClass(themeClass);
    String selectedTheme = isKnownCharacterTheme(canonicalTheme) ? canonicalTheme : "";
    body().removeCss(CARBON_THEME_CLASS);
    body().removeCss(PAPER_THEME_CLASS);
    body().removeCss(TERMINAL_THEME_CLASS);
    body().removeCss(GLASS_THEME_CLASS);
    body().removeCss(BLUEPRINT_THEME_CLASS);
    body().removeCss(HIGH_CONTRAST_THEME_CLASS);
    body().removeCss(EDITORIAL_THEME_CLASS);
    body().removeCss(SOFT_UI_THEME_CLASS);
    body().removeCss(NEON_NIGHT_THEME_CLASS);
    body().removeCss(RETRO_CONSOLE_THEME_CLASS);
    body().removeCss(AURORA_THEME_CLASS);
    if (!selectedTheme.isEmpty()) {
      body().addCss(selectedTheme);
    }
    if (persist) {
      localStorage().setItem(THEME_CHARACTER_STORAGE_KEY, selectedTheme);
    }
  }

  private void applyVisualTheme(String themeClass, boolean persist) {
    String canonicalTheme = canonicalThemeClass(themeClass);
    String selectedTheme = isKnownVisualTheme(canonicalTheme) ? canonicalTheme : "";
    body().removeCss(OCEAN_THEME_CLASS);
    body().removeCss(FOREST_THEME_CLASS);
    body().removeCss(SANDSTONE_THEME_CLASS);
    body().removeCss(GRAPHITE_THEME_CLASS);
    body().removeCss(LAVENDER_THEME_CLASS);
    body().removeCss(SUNSET_THEME_CLASS);
    body().removeCss(ARCTIC_THEME_CLASS);
    body().removeCss(ROSE_THEME_CLASS);
    body().removeCss(CRIMSON_THEME_CLASS);
    body().removeCss(AMETHYST_THEME_CLASS);
    body().removeCss(INDIGO_THEME_CLASS);
    body().removeCss(AZURE_THEME_CLASS);
    body().removeCss(LAGOON_THEME_CLASS);
    body().removeCss(JADE_THEME_CLASS);
    body().removeCss(MEADOW_THEME_CLASS);
    body().removeCss(LIME_THEME_CLASS);
    body().removeCss(MARIGOLD_THEME_CLASS);
    body().removeCss(AMBER_THEME_CLASS);
    if (!selectedTheme.isEmpty()) {
      body().addCss(selectedTheme);
    }
    if (persist) {
      localStorage().setItem(VISUAL_THEME_STORAGE_KEY, selectedTheme);
    }
  }

  private void restoreThemePreferences() {
    Storage storage = localStorage();
    String density = storage.getItem(THEME_DENSITY_STORAGE_KEY);
    String surface = storage.getItem(THEME_SURFACE_STORAGE_KEY);
    if (density == null && surface == null) {
      String legacyStyle = canonicalThemeClass(storage.getItem(LEGACY_THEME_STYLE_STORAGE_KEY));
      if (BORDERED_THEME_CLASS.equals(legacyStyle)
          || LEGACY_ISLAND_THEME_CLASS.equals(legacyStyle)) {
        density = COMPACT_THEME_CLASS;
        surface = BORDERED_THEME_CLASS;
      } else {
        density = legacyStyle;
        surface = "";
      }
    }
    applyDensityTheme(density, false);
    restoreSurfaceThemes(surface);
    applyCharacterTheme(storage.getItem(THEME_CHARACTER_STORAGE_KEY), false);
    applyVisualTheme(storage.getItem(VISUAL_THEME_STORAGE_KEY), false);
  }

  private void restoreSurfaceThemes(String surfaceThemes) {
    clearSurfaceThemes(false);
    if (surfaceThemes == null || surfaceThemes.isEmpty()) {
      return;
    }
    for (String themeClass : surfaceThemes.split(" ")) {
      String canonicalTheme = canonicalThemeClass(themeClass);
      if (isKnownSurfaceTheme(canonicalTheme)) {
        body().addCss(canonicalTheme);
      }
    }
  }

  private String canonicalThemeClass(String themeClass) {
    if (themeClass == null || themeClass.isEmpty()) {
      return "";
    }
    if (LEGACY_ISLAND_THEME_CLASS.equals(themeClass)) {
      return themeClass;
    }
    return themeClass.endsWith("-lab")
        ? themeClass.substring(0, themeClass.length() - "-lab".length())
        : themeClass;
  }

  private boolean isKnownSurfaceTheme(String themeClass) {
    return BORDERED_THEME_CLASS.equals(themeClass)
        || ELEVATED_THEME_CLASS.equals(themeClass)
        || ROUNDED_THEME_CLASS.equals(themeClass);
  }

  private boolean isKnownVisualTheme(String themeClass) {
    return OCEAN_THEME_CLASS.equals(themeClass)
        || FOREST_THEME_CLASS.equals(themeClass)
        || SANDSTONE_THEME_CLASS.equals(themeClass)
        || GRAPHITE_THEME_CLASS.equals(themeClass)
        || LAVENDER_THEME_CLASS.equals(themeClass)
        || SUNSET_THEME_CLASS.equals(themeClass)
        || ARCTIC_THEME_CLASS.equals(themeClass)
        || ROSE_THEME_CLASS.equals(themeClass)
        || CRIMSON_THEME_CLASS.equals(themeClass)
        || AMETHYST_THEME_CLASS.equals(themeClass)
        || INDIGO_THEME_CLASS.equals(themeClass)
        || AZURE_THEME_CLASS.equals(themeClass)
        || LAGOON_THEME_CLASS.equals(themeClass)
        || JADE_THEME_CLASS.equals(themeClass)
        || MEADOW_THEME_CLASS.equals(themeClass)
        || LIME_THEME_CLASS.equals(themeClass)
        || MARIGOLD_THEME_CLASS.equals(themeClass)
        || AMBER_THEME_CLASS.equals(themeClass);
  }

  private boolean isKnownCharacterTheme(String themeClass) {
    return CARBON_THEME_CLASS.equals(themeClass)
        || PAPER_THEME_CLASS.equals(themeClass)
        || TERMINAL_THEME_CLASS.equals(themeClass)
        || GLASS_THEME_CLASS.equals(themeClass)
        || BLUEPRINT_THEME_CLASS.equals(themeClass)
        || HIGH_CONTRAST_THEME_CLASS.equals(themeClass)
        || EDITORIAL_THEME_CLASS.equals(themeClass)
        || SOFT_UI_THEME_CLASS.equals(themeClass)
        || NEON_NIGHT_THEME_CLASS.equals(themeClass)
        || RETRO_CONSOLE_THEME_CLASS.equals(themeClass)
        || AURORA_THEME_CLASS.equals(themeClass);
  }

  private Storage localStorage() {
    return WebStorageWindow.of(DomGlobal.window).localStorage;
  }

  private DivElement createModeOption(String label, IsDominoTheme theme) {
    DivElement option =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_2)
            .addCss(MODE_OPTION_CLASS)
            .appendChild(h(5).textContent(label).style("margin:0;"));

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
            .addCss(ACCENT_SWATCH_CLASS)
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
    boolean compactThemeApplied = body().element().classList.contains(COMPACT_THEME_CLASS);
    boolean borderedThemeApplied = body().element().classList.contains(BORDERED_THEME_CLASS);
    boolean elevatedThemeApplied = body().element().classList.contains(ELEVATED_THEME_CLASS);
    boolean roundedThemeApplied = body().element().classList.contains(ROUNDED_THEME_CLASS);
    boolean oceanThemeApplied = body().element().classList.contains(OCEAN_THEME_CLASS);
    boolean forestThemeApplied = body().element().classList.contains(FOREST_THEME_CLASS);
    boolean sandstoneThemeApplied = body().element().classList.contains(SANDSTONE_THEME_CLASS);
    boolean graphiteThemeApplied = body().element().classList.contains(GRAPHITE_THEME_CLASS);
    boolean lavenderThemeApplied = body().element().classList.contains(LAVENDER_THEME_CLASS);
    boolean sunsetThemeApplied = body().element().classList.contains(SUNSET_THEME_CLASS);
    boolean arcticThemeApplied = body().element().classList.contains(ARCTIC_THEME_CLASS);
    boolean roseThemeApplied = body().element().classList.contains(ROSE_THEME_CLASS);
    boolean crimsonThemeApplied = body().element().classList.contains(CRIMSON_THEME_CLASS);
    boolean amethystThemeApplied = body().element().classList.contains(AMETHYST_THEME_CLASS);
    boolean indigoThemeApplied = body().element().classList.contains(INDIGO_THEME_CLASS);
    boolean azureThemeApplied = body().element().classList.contains(AZURE_THEME_CLASS);
    boolean lagoonThemeApplied = body().element().classList.contains(LAGOON_THEME_CLASS);
    boolean jadeThemeApplied = body().element().classList.contains(JADE_THEME_CLASS);
    boolean meadowThemeApplied = body().element().classList.contains(MEADOW_THEME_CLASS);
    boolean limeThemeApplied = body().element().classList.contains(LIME_THEME_CLASS);
    boolean marigoldThemeApplied = body().element().classList.contains(MARIGOLD_THEME_CLASS);
    boolean amberThemeApplied = body().element().classList.contains(AMBER_THEME_CLASS);
    boolean carbonThemeApplied = body().element().classList.contains(CARBON_THEME_CLASS);
    boolean paperThemeApplied = body().element().classList.contains(PAPER_THEME_CLASS);
    boolean terminalThemeApplied = body().element().classList.contains(TERMINAL_THEME_CLASS);
    boolean glassThemeApplied = body().element().classList.contains(GLASS_THEME_CLASS);
    boolean blueprintThemeApplied = body().element().classList.contains(BLUEPRINT_THEME_CLASS);
    boolean highContrastThemeApplied =
        body().element().classList.contains(HIGH_CONTRAST_THEME_CLASS);
    boolean editorialThemeApplied = body().element().classList.contains(EDITORIAL_THEME_CLASS);
    boolean softUiThemeApplied = body().element().classList.contains(SOFT_UI_THEME_CLASS);
    boolean neonNightThemeApplied = body().element().classList.contains(NEON_NIGHT_THEME_CLASS);
    boolean retroConsoleThemeApplied =
        body().element().classList.contains(RETRO_CONSOLE_THEME_CLASS);
    boolean auroraThemeApplied = body().element().classList.contains(AURORA_THEME_CLASS);
    boolean characterThemeApplied =
        carbonThemeApplied
            || paperThemeApplied
            || terminalThemeApplied
            || glassThemeApplied
            || blueprintThemeApplied
            || highContrastThemeApplied
            || editorialThemeApplied
            || softUiThemeApplied
            || neonNightThemeApplied
            || retroConsoleThemeApplied
            || auroraThemeApplied;
    boolean visualThemeApplied =
        oceanThemeApplied
            || forestThemeApplied
            || sandstoneThemeApplied
            || graphiteThemeApplied
            || lavenderThemeApplied
            || sunsetThemeApplied
            || arcticThemeApplied
            || roseThemeApplied
            || crimsonThemeApplied
            || amethystThemeApplied
            || indigoThemeApplied
            || azureThemeApplied
            || lagoonThemeApplied
            || jadeThemeApplied
            || meadowThemeApplied
            || limeThemeApplied
            || marigoldThemeApplied
            || amberThemeApplied;
    styleThemeOption(defaultDensityOption, !compactThemeApplied);
    styleThemeOption(compactDensityOption, compactThemeApplied);
    styleThemeOption(
        defaultSurfaceOption,
        !borderedThemeApplied && !elevatedThemeApplied && !roundedThemeApplied);
    styleThemeOption(borderedSurfaceOption, borderedThemeApplied);
    styleThemeOption(elevatedSurfaceOption, elevatedThemeApplied);
    styleThemeOption(roundedSurfaceOption, roundedThemeApplied);
    styleThemeOption(defaultVisualThemeOption, !visualThemeApplied);
    styleThemeOption(oceanThemeOption, oceanThemeApplied);
    styleThemeOption(forestThemeOption, forestThemeApplied);
    styleThemeOption(sandstoneThemeOption, sandstoneThemeApplied);
    styleThemeOption(graphiteThemeOption, graphiteThemeApplied);
    styleThemeOption(lavenderThemeOption, lavenderThemeApplied);
    styleThemeOption(sunsetThemeOption, sunsetThemeApplied);
    styleThemeOption(arcticThemeOption, arcticThemeApplied);
    styleThemeOption(roseThemeOption, roseThemeApplied);
    styleThemeOption(crimsonThemeOption, crimsonThemeApplied);
    styleThemeOption(amethystThemeOption, amethystThemeApplied);
    styleThemeOption(indigoThemeOption, indigoThemeApplied);
    styleThemeOption(azureThemeOption, azureThemeApplied);
    styleThemeOption(lagoonThemeOption, lagoonThemeApplied);
    styleThemeOption(jadeThemeOption, jadeThemeApplied);
    styleThemeOption(meadowThemeOption, meadowThemeApplied);
    styleThemeOption(limeThemeOption, limeThemeApplied);
    styleThemeOption(marigoldThemeOption, marigoldThemeApplied);
    styleThemeOption(amberThemeOption, amberThemeApplied);
    styleThemeOption(defaultCharacterThemeOption, !characterThemeApplied);
    styleThemeOption(carbonThemeOption, carbonThemeApplied);
    styleThemeOption(paperThemeOption, paperThemeApplied);
    styleThemeOption(terminalThemeOption, terminalThemeApplied);
    styleThemeOption(glassThemeOption, glassThemeApplied);
    styleThemeOption(blueprintThemeOption, blueprintThemeApplied);
    styleThemeOption(highContrastThemeOption, highContrastThemeApplied);
    styleThemeOption(editorialThemeOption, editorialThemeApplied);
    styleThemeOption(softUiThemeOption, softUiThemeApplied);
    styleThemeOption(neonNightThemeOption, neonNightThemeApplied);
    styleThemeOption(retroConsoleThemeOption, retroConsoleThemeApplied);
    styleThemeOption(auroraThemeOption, auroraThemeApplied);
    styleModeOption(lightModeOption, DominoThemeLight.INSTANCE.isApplied());
    styleModeOption(darkModeOption, DominoThemeDark.INSTANCE.isApplied());
    accentSwatches.forEach(
        swatch -> styleAccentSwatch(swatch.element, swatch.theme.isApplied()));
  }

  private void styleThemeOption(DivElement option, boolean active) {
    styleOptionState(option, active);
  }

  private void styleModeOption(DivElement option, boolean active) {
    styleOptionState(option, active);
  }

  private void styleAccentSwatch(DivElement swatch, boolean active) {
    styleOptionState(swatch, active);
  }

  private void styleOptionState(DivElement option, boolean active) {
    option.removeCss(ACTIVE_OPTION_CLASS);
    if (active) {
      option.addCss(ACTIVE_OPTION_CLASS);
    }
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

  private enum ThemeCategory {
    DENSITY,
    SURFACE,
    CHARACTER,
    VISUAL
  }
}
