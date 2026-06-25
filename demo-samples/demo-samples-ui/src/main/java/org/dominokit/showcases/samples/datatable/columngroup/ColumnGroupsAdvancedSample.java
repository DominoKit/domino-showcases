package org.dominokit.showcases.samples.datatable.columngroup;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.showcases.samples.datatable.ContactUiUtils;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.ContactsProvider;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.text;

public class ColumnGroupsAdvancedSample extends BaseDominoElement<HTMLDivElement, ColumnGroupsAdvancedSample> {

    private DivElement element;

    public static ColumnGroupsAdvancedSample create() {
        return new ColumnGroupsAdvancedSample();
    }

    public ColumnGroupsAdvancedSample() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("identity", "Identity")
                        .addColumn(ColumnConfig.<Contact>create("id", "#")
                                .applyMeta(ResizeColumnMeta.create(false))
                                .setTextAlign(CellTextAlign.RIGHT)
                                .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getIndex() + 1 + "")))
                        )
                        .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                                .setWidth("200px")
                                .minWidth("100px")
                                .maxWidth("400px")
                                .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getName())))
                        )
                        .applyMeta(PinColumnMeta.left())
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setRenderer(cell -> {
                            if (cell.getRecord().isActive()) {
                                cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                            } else {
                                cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                            }
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                )
                .addColumn(ColumnConfig.<Contact>create("contact", "Contact")
                        .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getEmail())))
                        )

                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getPhone())))
                        )
                ).addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                                        .setRenderer(cell -> {
                                            if (cell.getRecord().getAge() < 35) {
                                                cell.appendChild(Badge.create("Young")
                                                        .addCss(dui_green, dui_float_none));
                                            }
                                            cell.appendChild(text(""));
                                        })
                                )
                        )
                )
                .addPlugin(new PinColumnsPlugin<Contact>()
                        .configure(config -> config
                                .setShowPinIcon(true)
                                .setShowPinMenu(true))
                )
                .addPlugin(new ResizeColumnsPlugin<>())
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)));
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
