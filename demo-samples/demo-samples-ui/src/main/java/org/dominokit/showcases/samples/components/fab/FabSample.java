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
package org.dominokit.showcases.samples.components.fab;

import static org.dominokit.domino.ui.utils.Domino.body;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.Fab;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Demonstrates standalone and click-to-expand floating action buttons. */
public class FabSample extends BaseDominoElement<HTMLDivElement, FabSample> {

  private final Card card;
  private Fab activeFab;

  public static FabSample create() {
    return new FabSample();
  }

  public FabSample() {
    card =
        Card.create("Floating action buttons")
            .appendChild(
                div()
                    .addCss(dui_p_4, dui_flex, dui_gap_4, dui_justify_center)
                    .appendChild(Button.create("Single FAB").addClickListener(e -> showSingleFab()))
                    .appendChild(
                        Button.create("Expanded FAB")
                            .addClickListener(e -> showExpandedFab())));
    init(this);
  }

  private void showSingleFab() {
    replaceFab(Fab.create(Icons.plus()).withButton((fab, button) -> button.setAriaLabel("Create")));
  }

  private void showExpandedFab() {
    replaceFab(
        Fab.create(Icons.plus())
            .withButton((fab, button) -> button.setAriaLabel("Open actions"))
            .addAction(Button.create(Icons.email()).setAriaLabel("Email"))
            .addAction(Button.create(Icons.pencil()).setAriaLabel("Edit")));
  }

  private void replaceFab(Fab fab) {
    if (activeFab != null) {
      activeFab.remove();
    }
    activeFab = fab;
    body().appendChild(activeFab.element());
  }

  @Override
  public HTMLDivElement element() {
    return card.element();
  }
}
