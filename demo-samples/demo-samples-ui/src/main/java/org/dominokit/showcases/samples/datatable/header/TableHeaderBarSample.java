package org.dominokit.showcases.samples.datatable.header;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.SearchTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.ShowHideColumnsAction;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.ContactsProvider;
import org.dominokit.showcases.samples.datatable.ContactUiUtils;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_dominant_d_1;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_max_w_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_md;
import static org.dominokit.domino.ui.utils.Domino.text;

public class TableHeaderBarSample extends BaseDominoElement<HTMLDivElement, TableHeaderBarSample> {

    private DivElement element;

    public static TableHeaderBarSample create() {
        return new TableHeaderBarSample();
    }

    public TableHeaderBarSample() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getIndex() + 1 + ""))))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setRenderer(cell -> {
                            if (cell.getRecord().isActive()) {
                                cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                            } else {
                                cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getName()))))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord()))))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getEmail()))))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getPhone()))))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            }else {
                                cell.appendChild(text(""));
                            }
                        }))
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new NavigationBarPlugin<>((dataTable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("this a sample table with all features")
                            .appendChild(PostfixAddOn.of(Icons.close_circle()
                                            .clickable()
                                            .setTooltip("Select Inactive")
                                            .addClickListener(evt ->
                                                    dataTable.getRows().forEach(item -> {
                                                        if (!item.getRecord().isActive()) {
                                                            item.select();
                                                        } else {
                                                            item.deselect();
                                                        }
                                                    })
                                            )
                                    )
                            )
                            .appendChild(PostfixAddOn.of(Icons.check_circle()
                                            .clickable()
                                            .setTooltip("Select Active")
                                            .addClickListener(evt ->
                                                    dataTable.getRows().forEach(tableRow -> {
                                                        if (tableRow.getRecord().isActive()) {
                                                            tableRow.select();
                                                        } else {
                                                            tableRow.deselect();
                                                        }
                                                    }))
                                    )
                            )
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(dataTable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(dataTable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(dataTable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(dataTable)))
                            .appendChild(PostfixAddOn.of(ShowHideColumnsAction.create(dataTable)))
                            .appendChild(PostfixAddOn.of(SearchTableAction.create(dataTable)
                                    .withSearchBox((parent, searchBox) -> {
                                                searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                                            }
                                    )))
                    ;
                }))
        ;

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        localListDataStore.setData(ContactsProvider.instance.subList());
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
