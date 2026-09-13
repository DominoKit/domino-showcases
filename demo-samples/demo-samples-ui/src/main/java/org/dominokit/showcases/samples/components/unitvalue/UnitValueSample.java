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
package org.dominokit.showcases.samples.components.unitvalue;

import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_dominant_d_2;
import static org.dominokit.domino.ui.style.GenericCss.dui_emphasis_subtle;
import static org.dominokit.domino.ui.style.GenericCss.dui_error;
import static org.dominokit.domino.ui.style.GenericCss.dui_info;
import static org.dominokit.domino.ui.style.GenericCss.dui_success;
import static org.dominokit.domino.ui.style.SizingCss.dui_w_full;
import static org.dominokit.domino.ui.style.SpacingUtilitiesCss.dui_gap_1;
import static org.dominokit.domino.ui.style.SpacingUtilitiesCss.dui_gap_2;
import static org.dominokit.domino.ui.style.SpacingUtilitiesCss.dui_p_l_2;
import static org.dominokit.domino.ui.style.VisualCss.dui_rounded_md;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_horizontal;
import static org.dominokit.domino.ui.utils.Domino.dui_large;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.hr;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.unitvalue.UnitValue;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Demonstrates pre-formatted values with optional units, titles, descriptions, and layouts.
 */
public class UnitValueSample extends BaseDominoElement<HTMLDivElement, UnitValueSample> {

    private final Row element;

    public static UnitValueSample create() {
        return new UnitValueSample();
    }

    public UnitValueSample() {
        element = Row.create()
                .span4(Card.create("Basic samples")
                        .withBody((parent, self) -> self.addCss(dui_flex, dui_flex_col, dui_gap_4))
                        .appendChild(UnitValue.create("603.455")
                                .setTitle("Total revenue"))
                        .appendChild(UnitValue.create("-293.517", "JOD")
                                .setTitle("Net change")
                                .setDescription("Compared with the previous month"))
                        .appendChild(UnitValue.create("120,000.00")
                                .setTitle("Total sales")
                                .setUnit(Icons.cash())
                                .setDescription("Since first day of year until now"))
                )
                .span4(Card.create("Contextual coloring")
                        .withBody((parent, self) -> self.addCss(dui_flex, dui_flex_col, dui_gap_4))
                        .appendChild(UnitValue.create("603.455")
                                .addCss(dui_success)
                                .setTitle("Total revenue"))
                        .appendChild(UnitValue.create("-293.517", "JOD")
                                .addCss(dui_error)
                                .setTitle("Net change")
                                .setDescription("Compared with the previous month"))
                        .appendChild(UnitValue.create("120,000.00")
                                .addCss(dui_info)
                                .setTitle("Total sales")
                                .setUnit(Icons.cash())
                                .setDescription("Since first day of year until now"))
                )
                .span4(Card.create("Horizontal layout")
                        .withBody((parent, self) -> self.addCss(dui_flex, dui_flex_col, dui_gap_2))
                        .appendChild(UnitValue.create("1,989.729")
                                .setTitle("Processed volume")
                                .setUnit(Icons.currency_usd())
                                .setDescription("Last 30 days")
                                .addCss(dui_w_full, dui_p_2, dui_bg_dominant_d_2, dui_rounded_md, dui_emphasis_subtle)
                        )
                        .appendChild(div().addCss(dui_flex, dui_flex_col, dui_gap_1, dui_p_2)
                                .appendChild(UnitValue.create("603.455", "JOD")
                                        .addCss(dui_success)
                                        .setTitle("Total revenue")
                                        .addCss(dui_horizontal))
                                .appendChild(UnitValue.create("-293.517", "JOD")
                                        .addCss(dui_error)
                                        .setTitle("Net change")
                                        .addCss(dui_horizontal))
                                .appendChild(UnitValue.create("120,000.00")
                                        .addCss(dui_info)
                                        .setTitle("Total sales")
                                        .setUnit(Icons.cash())
                                        .addCss(dui_horizontal)
                                )
                                .appendChild(hr())
                                .appendChild(UnitValue.create("78.661", "%")
                                        .setTitle("Conversion rate")
                                        .setDescription("From qualified visits")
                                        .addCss(dui_horizontal))
                                .appendChild(UnitValue.create("42", "items")
                                        .setTitle("Open tasks")
                                        .setDescription("Requires attention")
                                        .addCss(dui_horizontal))
                        )
                )


        ;
        init(this);
    }

    private DivElement metric(UnitValue unitValue) {
        return div().addCss(dui_flex, dui_flex_col).appendChild(unitValue);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
