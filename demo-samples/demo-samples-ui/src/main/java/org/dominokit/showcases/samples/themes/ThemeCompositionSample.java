/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.showcases.samples.themes;

import static org.dominokit.domino.ui.utils.Domino.code;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_elevation_4;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_sm;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import java.util.List;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.themes.DominoCssTheme;
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeCategories;
import org.dominokit.domino.ui.themes.DominoThemeDark;
import org.dominokit.domino.ui.themes.DominoThemeDefault;
import org.dominokit.domino.ui.themes.DominoThemeLight;
import org.dominokit.domino.ui.themes.ElementThemeManager;
import org.dominokit.domino.ui.themes.IsDominoTheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ThemeCompositionSample
    extends BaseDominoElement<HTMLDivElement, ThemeCompositionSample> {

  private static final List<NamedTheme> ACCENTS =
      Arrays.asList(
          NamedTheme.of("Red", DominoThemeAccent.RED),
          NamedTheme.of("Pink", DominoThemeAccent.PINK),
          NamedTheme.of("Purple", DominoThemeAccent.PURPLE),
          NamedTheme.of("Deep purple", DominoThemeAccent.DEEP_PURPLE),
          NamedTheme.of("Indigo", DominoThemeAccent.INDIGO),
          NamedTheme.of("Blue", DominoThemeAccent.BLUE),
          NamedTheme.of("Light blue", DominoThemeAccent.LIGHT_BLUE),
          NamedTheme.of("Cyan", DominoThemeAccent.CYAN),
          NamedTheme.of("Teal", DominoThemeAccent.TEAL),
          NamedTheme.of("Green", DominoThemeAccent.GREEN),
          NamedTheme.of("Light green", DominoThemeAccent.LIGHT_GREEN),
          NamedTheme.of("Lime", DominoThemeAccent.LIME),
          NamedTheme.of("Yellow", DominoThemeAccent.YELLOW),
          NamedTheme.of("Amber", DominoThemeAccent.AMBER),
          NamedTheme.of("Orange", DominoThemeAccent.ORANGE),
          NamedTheme.of("Deep orange", DominoThemeAccent.DEEP_ORANGE),
          NamedTheme.of("Brown", DominoThemeAccent.BROWN),
          NamedTheme.of("Grey", DominoThemeAccent.GREY),
          NamedTheme.of("Blue grey", DominoThemeAccent.BLUE_GREY));

  private final DivElement root;
  private final DivElement previewRoot;
  private final DominoCssTheme customTheme =
      DominoCssTheme.of("acme-brand", DominoThemeCategories.MAIN, "acme-theme");
  private Button customThemeButton;

  public static ThemeCompositionSample create() {
    return new ThemeCompositionSample();
  }

  public ThemeCompositionSample() {
    previewRoot = createPreviewRoot();
    root =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(
                h(3).textContent("Theme composition and scoped isolation"))
            .appendChild(
                p("Change the preview theme. The plain sibling remains outside the themed subtree."))
            .appendChild(controls())
            .appendChild(previewRoot)
            .appendChild(
                div()
                    .addCss(dui_p_4, dui_border, dui_border_solid, dui_rounded_sm)
                    .appendChild(h(5).textContent("Unthemed host content"))
                    .appendChild(
                        p("This sibling has no Domino UI theme classes and is not changed by the preview controls.")))
            .appendChild(
                code()
                    .textContent(
                        ".dui.dui-theme-default.acme-theme {\n"
                            + "  --dui-clr-primary: #355cde;\n"
                            + "  --dui-accent-clr: #355cde;\n"
                            + "  --dui-text-color: #1b2430;\n"
                            + "}"))
            .appendChild(
                p("WaitMe is a separate ready-to-use loader stylesheet; it is not part of this theme token set."));

    ElementThemeManager.INSTANCE.apply(DominoThemeDefault.INSTANCE, previewRoot.element());
    ElementThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE, previewRoot.element());
    ElementThemeManager.INSTANCE.apply(DominoThemeAccent.TEAL, previewRoot.element());
    init(this);
  }

  private DivElement controls() {
    return div()
        .addCss(dui_flex, dui_flex_col, dui_gap_2)
        .appendChild(h(5).textContent("Color mode"))
        .appendChild(
            div()
                .addCss(dui_flex, dui_gap_2)
                .appendChild(themeButton("Light", DominoThemeLight.INSTANCE))
                .appendChild(themeButton("Dark", DominoThemeDark.INSTANCE)))
        .appendChild(h(5).textContent("Accent"))
        .appendChild(accentButtons())
        .appendChild(h(5).textContent("Custom CSS theme"))
        .appendChild(
            customThemeButton =
                Button.create("Apply custom theme")
                    .addCss(dui_p_2)
                    .addClickListener(event -> toggleCustomTheme()));
  }

  private DivElement accentButtons() {
    DivElement buttons = div().addCss(dui_flex, dui_flex_wrap, dui_gap_2);
    ACCENTS.forEach(
        namedTheme -> buttons.appendChild(themeButton(namedTheme.name, namedTheme.theme)));
    return buttons;
  }

  private Button themeButton(String label, IsDominoTheme theme) {
    return Button.create(label)
        .addCss(dui_p_2)
        .addClickListener(event -> ElementThemeManager.INSTANCE.apply(theme, previewRoot.element()));
  }

  private DivElement createPreviewRoot() {
    DivElement nestedRoot =
        div()
            .addCss(dui_p_4, dui_border, dui_border_solid, dui_rounded_sm, dui_elevation_4)
            .appendChild(h(4).textContent("Themed Domino UI preview"))
            .appendChild(p("This root uses the base, color-mode, and accent theme layers."))
            .appendChild(Button.create("Preview action").addCss(dui_accent));

    ElementThemeManager.INSTANCE.apply(DominoThemeDark.INSTANCE, nestedRoot.element());
    nestedRoot.appendChild(
        div()
            .addCss(dui_p_2, dui_m_t_4)
            .appendChild(h(5).textContent("Nested override"))
            .appendChild(p("This nested root stays dark when the parent preview changes mode.")));

    return div().addCss(dui_flex, dui_flex_col, dui_gap_4).appendChild(nestedRoot);
  }

  private void toggleCustomTheme() {
    if (customTheme.isApplied(previewRoot.element())) {
      customTheme.cleanup(previewRoot.element());
      Style.of(previewRoot).removeCssProperty("--dui-clr-primary");
      Style.of(previewRoot).removeCssProperty("--dui-accent-clr");
      Style.of(previewRoot).removeCssProperty("--dui-text-color");
      customThemeButton.setText("Apply custom theme");
    } else {
      customTheme.apply(previewRoot.element());
      Style.of(previewRoot)
          .setCssProperty("--dui-clr-primary", "#355cde")
          .setCssProperty("--dui-accent-clr", "#355cde")
          .setCssProperty("--dui-text-color", "#1b2430");
      customThemeButton.setText("Remove custom theme");
    }
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  private static final class NamedTheme {
    private final String name;
    private final IsDominoTheme theme;

    private NamedTheme(String name, IsDominoTheme theme) {
      this.name = name;
      this.theme = theme;
    }

    private static NamedTheme of(String name, IsDominoTheme theme) {
      return new NamedTheme(name, theme);
    }
  }
}
