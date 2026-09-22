package org.dominokit.showcases.samples.themes;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Explains surface treatments that can be composed independently. */
public class ThemeSurfaceSample extends BaseDominoElement<HTMLDivElement, ThemeSurfaceSample> {

  private final DivElement root;

  public static ThemeSurfaceSample create() {
    return new ThemeSurfaceSample();
  }

  private ThemeSurfaceSample() {
    root =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_2)
            .appendChild(p("Surface treatments are independently composable and can be cleared independently."))
            .appendChild(treatment("Bordered", "Adds theme-aware borders without changing elevation."))
            .appendChild(treatment("Elevated", "Adds elevation without clearing an active bordered treatment."))
            .appendChild(treatment("Rounded", "Applies theme-aware radius rules to supported surfaces."))
            .appendChild(treatment("Accent headers", "Uses the selected accent for supported component headers."));
    init(this);
  }

  private DivElement treatment(String title, String description) {
    return div()
        .addCss("dui-theme-surface-treatment")
        .appendChild(h(5).textContent(title))
        .appendChild(p(description));
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
