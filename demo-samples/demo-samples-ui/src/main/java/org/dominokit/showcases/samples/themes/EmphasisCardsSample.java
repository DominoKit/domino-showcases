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

import static org.dominokit.domino.ui.style.GenericCss.dui_red;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_filled;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_minimal;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_subtle;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Demonstrates emphasis modifiers on cards. */
public class EmphasisCardsSample
    extends BaseDominoElement<HTMLDivElement, EmphasisCardsSample> {

  private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

  private final DivElement element;

  public static EmphasisCardsSample create() {
    return new EmphasisCardsSample();
  }

  public EmphasisCardsSample() {
    element =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_2)
            .appendChild(
                Card.create("Filled card", "A card using the default emphasis appearance.")
                    .addCss(dui_primary, dui_emphasis_filled)
                        .appendChild(text(SAMPLE_CONTENT))
            )
            .appendChild(
                Card.create("Subtle card", "A card using a low-intensity accent surface.")
                    .addCss(dui_success, dui_emphasis_subtle))
            .appendChild(
                Card.create()
                    .addCss(dui_red, dui_emphasis_subtle)
                        .appendChild(text(SAMPLE_CONTENT))
            )
            .appendChild(
                Card.create("Minimal card", "A card using a transparent surface and semantic edge.")
                    .addCss(dui_info, dui_emphasis_minimal));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
