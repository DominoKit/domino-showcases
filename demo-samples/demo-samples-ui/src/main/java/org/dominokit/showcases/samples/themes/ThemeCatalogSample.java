package org.dominokit.showcases.samples.themes;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.li;
import static org.dominokit.domino.ui.utils.Domino.p;
import static org.dominokit.domino.ui.utils.Domino.ul;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Lists the built-in identity, character, and composable surface theme families. */
public class ThemeCatalogSample extends BaseDominoElement<HTMLDivElement, ThemeCatalogSample> {

  private static final String[] IDENTITIES = {
    "Ocean", "Forest", "Sandstone", "Graphite", "Lavender", "Sunset", "Arctic", "Rose", "Crimson",
    "Amethyst", "Indigo", "Azure", "Lagoon", "Jade", "Meadow", "Lime", "Marigold", "Amber"
  };

  private static final String[] CHARACTERS = {
    "Carbon", "Paper", "Terminal", "Glass", "Blueprint", "High contrast", "Editorial", "Soft UI",
    "Neon night", "Retro console", "Aurora"
  };

  private static final String[] SURFACES = {
    "Bordered", "Elevated", "Rounded", "Accent headers"
  };

  private final DivElement root;

  public static ThemeCatalogSample create() {
    return new ThemeCatalogSample();
  }

  private ThemeCatalogSample() {
    root =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_2)
            .appendChild(p("Choose one visual identity and character, then compose density and surface treatments."))
            .appendChild(themeFamily("Identity themes", "dui-theme-catalog-identity", IDENTITIES))
            .appendChild(themeFamily("Character themes", "dui-theme-catalog-character", CHARACTERS))
            .appendChild(themeFamily("Surface treatments", "dui-theme-catalog-surface", SURFACES));
    init(this);
  }

  private DivElement themeFamily(String title, String cssClass, String[] themes) {
    DivElement family = div().addCss(cssClass);
    family.appendChild(h(5).textContent(title));
    var entries = ul();
    for (String theme : themes) {
      entries.appendChild(li().addCss("dui-theme-catalog-item").textContent(theme));
    }
    return family.appendChild(entries);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
