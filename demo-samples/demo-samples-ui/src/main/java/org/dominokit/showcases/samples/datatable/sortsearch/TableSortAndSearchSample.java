package org.dominokit.showcases.samples.datatable.sortsearch;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.BooleanHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.DoubleHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.EnumHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.SelectHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.TextHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.ClearSearch;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.SearchTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.ContactsProvider;
import org.dominokit.showcases.samples.model.Gender;
import org.dominokit.showcases.samples.datatable.ContactSearchFilter;
import org.dominokit.showcases.samples.datatable.ContactSorter;
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

public class TableSortAndSearchSample extends BaseDominoElement<HTMLDivElement, TableSortAndSearchSample> {

    private DivElement element;

    public static TableSortAndSearchSample create() {
        return new TableSortAndSearchSample();
    }

    public TableSortAndSearchSample() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getIndex() + 1 + "")))
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
                        .applyMeta(ColumnFilterMeta.of(BooleanHeaderFilter.<Contact>create("Active", "Inactive", "Both")))
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getName())))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                        .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                        .applyMeta(ColumnFilterMeta.of(SelectHeaderFilter.<Contact>create()
                                .appendChild(SelectOption.create("blue","blue", "Blue"))
                                .appendChild(SelectOption.create("brown","brown", "Brown"))
                                .appendChild(SelectOption.create("green","green", "Green"))
                        ))
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getEmail())))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getPhone())))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                                            if (cell.getRecord().getAge() < 35) {
                                                cell.appendChild(Badge.create("Young")
                                                        .addCss(dui_green, dui_float_none));
                                            }
                                            cell.appendChild(text(""));
                                        }));

        ColumnHeaderFilterPlugin<Contact> contactColumnHeaderFilterPlugin = ColumnHeaderFilterPlugin.<Contact>create();
        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(Icons.filter_menu_outline()
                                    .clickable()
                                    .addClickListener(evt -> contactColumnHeaderFilterPlugin.getFiltersRowElement()
                                            .toggleDisplay())))
                            .appendChild(PostfixAddOn.of(ClearSearch.create(datatable)))
                            .appendChild(PostfixAddOn.of(SearchTableAction.create(datatable)
                                    .withSearchBox((parent, searchBox) -> {
                                        searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                                    })))

                    ;
                }))
                .addPlugin(contactColumnHeaderFilterPlugin);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
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
