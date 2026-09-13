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

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableBorderMode;
import org.dominokit.domino.ui.datatable.TableColumnStripeMode;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;

public class TableBorderModeActionsTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "org.dominokit.showcases.samples.DemoSamplesUI";
    }

    public void testSpecificBorderModeCanBeToggledOffAndOn() {
        DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());
        TableBorderModeActions actions = TableBorderModeActions.create(table);

        actions.toggleMode(TableBorderMode.COLUMN_GROUPS);
        assertTrue(table.isBordered());
        assertTrue(table.getBorderModes().contains(TableBorderMode.COLUMN_GROUPS));

        actions.toggleMode(TableBorderMode.COLUMN_GROUPS);
        assertFalse(table.isBordered());
        assertTrue(table.getBorderModes().contains(TableBorderMode.COLUMN_GROUPS));
        assertFalse(table.getBorderModes().contains(TableBorderMode.FULL));

        actions.toggleMode(TableBorderMode.COLUMN_GROUPS);
        assertTrue(table.isBordered());
        assertTrue(table.getBorderModes().contains(TableBorderMode.COLUMN_GROUPS));
    }

    public void testSelectedModesCanBeToggledIndependently() {
        DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());
        table.addBorderMode(TableBorderMode.TABLE).addBorderMode(TableBorderMode.ROWS);
        TableBorderModeActions actions = TableBorderModeActions.create(table);

        actions.toggleMode(TableBorderMode.TABLE);

        assertTrue(table.isBordered());
        assertFalse(table.getBorderModes().contains(TableBorderMode.TABLE));
        assertTrue(table.getBorderModes().contains(TableBorderMode.ROWS));

        actions.toggleMode(TableBorderMode.ROWS);

        assertFalse(table.isBordered());
        assertTrue(table.getBorderModes().contains(TableBorderMode.ROWS));
    }

    public void testColumnStripeModesCanBeToggledIndependently() {
        DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());
        TableBorderModeActions actions = TableBorderModeActions.create(table);

        actions.toggleColumnStripeMode(TableColumnStripeMode.COLUMNS);
        assertTrue(table.isColumnStriped());
        assertEquals(TableColumnStripeMode.COLUMNS, table.getColumnStripeMode());

        actions.toggleColumnStripeMode(TableColumnStripeMode.COLUMNS);
        assertFalse(table.isColumnStriped());
        assertEquals(TableColumnStripeMode.COLUMNS, table.getColumnStripeMode());

        actions.toggleColumnStripeMode(TableColumnStripeMode.COLUMN_GROUPS);
        assertTrue(table.isColumnStriped());
        assertEquals(TableColumnStripeMode.COLUMN_GROUPS, table.getColumnStripeMode());

        actions.toggleColumnStripeMode(TableColumnStripeMode.COLUMNS);
        assertTrue(table.isColumnStriped());
        assertEquals(TableColumnStripeMode.COLUMNS, table.getColumnStripeMode());
    }
}
