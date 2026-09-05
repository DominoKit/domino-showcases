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
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_filled;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_minimal;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_subtle;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_red;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Demonstrates emphasis modifiers applied directly to individual components. */
public class EmphasisComponentsSample
    extends BaseDominoElement<HTMLDivElement, EmphasisComponentsSample> {

  private final DivElement element;

  public static EmphasisComponentsSample create() {
    return new EmphasisComponentsSample();
  }

  public EmphasisComponentsSample() {
    element =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_2)
            .appendChild(buttons())
            .appendChild(badges())
            .appendChild(chips())
            .appendChild(alerts())
            .appendChild(infoBoxes())
            .appendChild(progressBars());
    init(this);
  }

  private DivElement buttons() {
    return row()
        .appendChild(Button.create("Filled button").addCss(dui_primary, dui_emphasis_filled))
        .appendChild(Button.create("Subtle button").addCss(dui_success, dui_emphasis_subtle))
        .appendChild(Button.create("Minimal button").addCss(dui_info, dui_emphasis_minimal));
  }

  private DivElement badges() {
    return row()
        .appendChild(Badge.create("Filled badge").addCss(dui_primary, dui_emphasis_filled))
        .appendChild(Badge.create("Subtle badge").addCss(dui_success, dui_emphasis_subtle))
        .appendChild(Badge.create("Minimal badge").addCss(dui_info, dui_emphasis_minimal));
  }

  private DivElement chips() {
    return row()
        .appendChild(Chip.create("Filled chip").addCss(dui_primary, dui_emphasis_filled))
        .appendChild(Chip.create("Subtle chip").addCss(dui_success, dui_emphasis_subtle))
        .appendChild(Chip.create("Minimal chip").addCss(dui_info, dui_emphasis_minimal));
  }

  private DivElement alerts() {
    return column()
        .appendChild(Alert.success().textContent("Filled alert").addCss(dui_emphasis_filled))
        .appendChild(
            Alert.create()
                .addCss(dui_red)
                .textContent("Subtle red alert")
                .addCss(dui_emphasis_subtle))
        .appendChild(Alert.warning().textContent("Minimal alert").addCss(dui_emphasis_minimal));
  }

  private DivElement infoBoxes() {
    return row()
        .appendChild(
            InfoBox.create(Icons.cart(), "Filled info box", "125")
                .addCss(dui_primary, dui_emphasis_filled))
        .appendChild(
            InfoBox.create(Icons.face_man(), "Subtle info box", "257")
                .addCss(dui_success, dui_emphasis_subtle))
        .appendChild(
            InfoBox.create(Icons.star(), "Minimal info box", "117")
                .addCss(dui_info, dui_emphasis_minimal));
  }

  private DivElement progressBars() {
    return column()
        .appendChild(
            Progress.create()
                .appendChild(
                    ProgressBar.create(100)
                        .setValue(72)
                        .addCss(dui_primary, dui_emphasis_filled)))
        .appendChild(
            Progress.create()
                .appendChild(
                    ProgressBar.create(100)
                        .setValue(54)
                        .addCss(dui_success, dui_emphasis_subtle)))
        .appendChild(
            Progress.create()
                .appendChild(
                    ProgressBar.create(100)
                        .setValue(36)
                        .addCss(dui_info, dui_emphasis_minimal)));
  }

  private DivElement row() {
    return div().addCss(dui_flex, dui_flex_wrap, dui_gap_2);
  }

  private DivElement column() {
    return div().addCss(dui_flex, dui_flex_col, dui_gap_2);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
