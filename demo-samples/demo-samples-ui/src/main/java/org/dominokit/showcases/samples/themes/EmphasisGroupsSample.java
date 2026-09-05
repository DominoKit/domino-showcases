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

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_filled;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_minimal;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_subtle;
import static org.dominokit.domino.ui.utils.Domino.dui_error;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;
import static org.dominokit.domino.ui.utils.Domino.h;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Demonstrates emphasis modifiers inherited by a group of components. */
public class EmphasisGroupsSample
    extends BaseDominoElement<HTMLDivElement, EmphasisGroupsSample> {

  private final DivElement element;

  public static EmphasisGroupsSample create() {
    return new EmphasisGroupsSample();
  }

  public EmphasisGroupsSample() {
    element =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_2)
            .appendChild(group("Subtle group", dui_emphasis_subtle, dui_primary, dui_success, dui_info))
            .appendChild(group("Minimal group", dui_emphasis_minimal, dui_warning, dui_accent, dui_error))
            .appendChild(group("Filled group", dui_emphasis_filled, dui_info, dui_primary, dui_success))
            .appendChild(inheritedBorders());
    init(this);
  }

  private DivElement group(
      String title,
      CssClass emphasis,
      CssClass firstColor,
      CssClass secondColor,
      CssClass thirdColor) {
    return div()
        .addCss(dui_flex, dui_flex_col, dui_gap_2)
        .appendChild(h(5).textContent(title))
        .appendChild(
            div()
                .addCss(dui_flex, dui_flex_wrap, dui_gap_2)
                .addCss(emphasis)
                .appendChild(Button.create("Button").addCss(firstColor))
                .appendChild(Badge.create("Badge").addCss(secondColor))
                .appendChild(Chip.create("Chip").addCss(thirdColor)));
  }

  private DivElement inheritedBorders() {
    return div()
        .addCss(dui_flex, dui_flex_col, dui_gap_2)
        .appendChild(h(5).textContent("Inherited component borders"))
        .appendChild(
            div()
                .addCss(dui_flex, dui_flex_wrap, dui_gap_2, dui_emphasis_subtle)
                .appendChild(Badge.create("Subtle badge").addCss(dui_success))
                .appendChild(Chip.create("Subtle chip").addCss(dui_info))
                .appendChild(Alert.info().textContent("Subtle alert")))
        .appendChild(
            div()
                .addCss(dui_flex, dui_flex_wrap, dui_gap_2, dui_emphasis_minimal)
                .appendChild(Badge.create("Minimal badge").addCss(dui_warning))
                .appendChild(Chip.create("Minimal chip").addCss(dui_error))
                .appendChild(Alert.warning().textContent("Minimal alert")));
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
