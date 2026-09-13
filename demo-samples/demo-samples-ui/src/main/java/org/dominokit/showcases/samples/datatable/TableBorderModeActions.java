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
package org.dominokit.showcases.samples.datatable;

import elemental2.dom.HTMLDivElement;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableBorderMode;
import org.dominokit.domino.ui.datatable.TableColumnStripeMode;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;

/** Shared showcase controls for toggling datatable border and column-stripe modes. */
public class TableBorderModeActions
        extends BaseDominoElement<HTMLDivElement, TableBorderModeActions> {

    private final DivElement root = div().addCss(dui_flex, dui_gap_2);
    private final Map<TableBorderMode, MdiIcon> modeIcons = new HashMap<>();
    private final Map<TableColumnStripeMode, MdiIcon> columnStripeModeIcons = new HashMap<>();
    private final DataTable<?> dataTable;
    private final ToggleMdiIcon bordersToggle;

    public static TableBorderModeActions create(DataTable<?> dataTable) {
        return new TableBorderModeActions(dataTable);
    }

    private TableBorderModeActions(DataTable<?> dataTable) {
        this.dataTable = dataTable;
        this.bordersToggle =
                ToggleMdiIcon.create(Icons.border_vertical(), Icons.border_none())
                        .clickable()
                        .toggleOnClick(true)
                        .setTooltip("Borders")
                        .onToggle(
                                icon -> {
                                    dataTable.setBordered(!dataTable.isBordered());
                                    updateSelection();
                                });

        root.appendChild(bordersToggle);
        addMode(TableBorderMode.FULL, "Full borders", Icons.border_all());
        addMode(TableBorderMode.TABLE, "Table border", Icons.border_outside());
        addMode(TableBorderMode.ROWS, "Row borders", Icons.border_horizontal());
        addMode(TableBorderMode.COLUMNS, "Column borders", Icons.border_vertical());
        addMode(TableBorderMode.COLUMN_GROUPS, "Column group borders", Icons.table_column());
        addMode(TableBorderMode.SECTIONS, "Section borders", Icons.table_border());
        addColumnStripeMode(
                TableColumnStripeMode.COLUMNS, "Column stripes", Icons.view_column());
        addColumnStripeMode(
                TableColumnStripeMode.COLUMN_GROUPS, "Column group stripes", Icons.table_column());

        init(this);
        updateSelection();
    }

    private void addMode(TableBorderMode mode, String tooltip, MdiIcon icon) {
        modeIcons.put(
                mode,
                icon.clickable().setTooltip(tooltip).addClickListener(event -> toggleMode(mode)));
        root.appendChild(modeIcons.get(mode));
    }

    private void addColumnStripeMode(TableColumnStripeMode mode, String tooltip, MdiIcon icon) {
        columnStripeModeIcons.put(
                mode,
                icon.clickable()
                        .setTooltip(tooltip)
                        .addClickListener(event -> toggleColumnStripeMode(mode)));
        root.appendChild(columnStripeModeIcons.get(mode));
    }

    void toggleColumnStripeMode(TableColumnStripeMode mode) {
        if (dataTable.isColumnStriped() && dataTable.getColumnStripeMode() == mode) {
            dataTable.setColumnStriped(false);
        } else {
            dataTable.setColumnStripeMode(mode);
        }
        updateSelection();
    }

    void toggleMode(TableBorderMode mode) {
        if (mode == TableBorderMode.FULL) {
            if (dataTable.isBordered()) {
                dataTable.setBordered(false);
            } else {
                dataTable.setBorderMode(TableBorderMode.FULL);
            }
        } else if (!dataTable.isBordered()) {
            dataTable.addBorderMode(mode);
        } else if (dataTable.getBorderModes().contains(mode)) {
            if (dataTable.getBorderModes().size() == 1) {
                dataTable.setBordered(false);
            } else {
                dataTable.removeBorderMode(mode);
            }
        } else {
            dataTable.addBorderMode(mode);
        }
        updateSelection();
    }

    private void updateSelection() {
        boolean bordered = dataTable.isBordered();
        modeIcons.forEach(
                (mode, icon) -> {
                    if (bordered && dataTable.getBorderModes().contains(mode)) {
                        icon.addCss(dui_accent);
                    } else {
                        icon.removeCss(dui_accent);
                    }
                });
        boolean columnStriped = dataTable.isColumnStriped();
        columnStripeModeIcons.forEach(
                (mode, icon) -> {
                    if (columnStriped && dataTable.getColumnStripeMode() == mode) {
                        icon.addCss(dui_accent);
                    } else {
                        icon.removeCss(dui_accent);
                    }
                });
        if (bordersToggle.isToggled() != bordered) {
            bordersToggle.toggle(true);
        }
        bordersToggle.setTooltip(bordered ? "No borders" : "Borders");
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
