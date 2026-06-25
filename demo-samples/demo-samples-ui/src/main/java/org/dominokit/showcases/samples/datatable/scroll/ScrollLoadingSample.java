package org.dominokit.showcases.samples.datatable.scroll;

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
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.pagination.BodyScrollPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
//import org.dominokit.showcases.samples.datatable.ContactSearchFilter;
import org.dominokit.showcases.samples.datatable.ContactSearchFilter;
import org.dominokit.showcases.samples.datatable.ContactSorter;
import org.dominokit.showcases.samples.datatable.ContactUiUtils;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.ContactsProvider;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_align_middle;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_24;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.text;

public class ScrollLoadingSample extends BaseDominoElement<HTMLDivElement, ScrollLoadingSample> {

    private DivElement element;

    public static ScrollLoadingSample create() {
        return new ScrollLoadingSample();
    }

    public ScrollLoadingSample() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> elementOf(cellElement).addCss(dui_align_middle))
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
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getName())))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .styleHeader(head -> elementOf(head).addCss(dui_w_24))
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                        .setWidth("250px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("250px")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getEmail()))))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("150px")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getPhone()))))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                                            if (cell.getRecord().getAge() < 35) {
                                                cell.appendChild(Badge.create("Young")
                                                        .addCss(dui_green, dui_float_none));
                                            }
                                            cell.appendChild(text(""));
                                        }))
                .addPlugin(new BodyScrollPlugin<>())
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)));
                }))
                .addPlugin(new SortPlugin<>());

        LocalListScrollingDataSource<Contact> scrollingDataSource = new LocalListScrollingDataSource<Contact>(10)
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter());

        DataTable<Contact> table = new DataTable<>(tableConfig, scrollingDataSource);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        scrollingDataSource.setData(ContactsProvider.instance.subList(100));
        scrollingDataSource.load();
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
