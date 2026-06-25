package org.dominokit.showcases.samples.datatable.mix;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.BooleanHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.DoubleHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.EnumHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.SelectHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.TextHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.grouping.GroupingPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.TopPanelPlugin;
import org.dominokit.domino.ui.datatable.plugins.marker.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.ScrollingPaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoEvent;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.showcases.samples.model.ContactsProvider;
import org.dominokit.showcases.samples.datatable.ContactSearchFilter;
import org.dominokit.showcases.samples.datatable.ContactSorter;
import org.dominokit.showcases.samples.datatable.ContactUiUtils;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.Gender;
import org.dominokit.showcases.samples.datatable.ContactsTopPanel;
import org.dominokit.showcases.samples.datatable.details.ContactDetails;

import java.util.List;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_align_middle;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_1;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_accent_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_p_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_24;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.text;

public class PluginsMixSample extends BaseDominoElement<HTMLDivElement, PluginsMixSample> {

    private DivElement element;

    public static PluginsMixSample create() {
        return new PluginsMixSample();
    }

    public PluginsMixSample() {
        ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
        ScrollingPaginationPlugin<Contact> scrollingPaginationPlugin = new ScrollingPaginationPlugin<>(10, 5);
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> elementOf(cellElement).addCss(dui_align_middle))
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getIndex() + 1 + "")))
                        .setWidth("70px")
                )
                .addColumn(ColumnConfig.<Contact>create("group 1", "Group 1")
                        .addColumn(ColumnConfig.<Contact>create("status", "Status")
                                .setWidth("80px")
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
                                .setWidth("200px")
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("group 2", "Group 2")
                        .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                                .setWidth("100px")
                                .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                                .setTextAlign(CellTextAlign.CENTER)
                                .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                        )
                        .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                                .styleHeader(head -> elementOf(head).addCss(dui_w_24))
                                .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                                .setTextAlign(CellTextAlign.CENTER)
                                .maxWidth("120px")
                                .applyMeta(ColumnFilterMeta.of(SelectHeaderFilter.<Contact>create()
                                                .appendChild(SelectOption.create("blue", "Blue"))
                                                .appendChild(SelectOption.create("brown", "Brown"))
                                                .appendChild(SelectOption.create("green", "Green"))
                                        )
                                )
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("group 3", "Group 3")
                        .addColumn(ColumnConfig.<Contact>create("group 2", "Group 2")
                                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                                        .sortable()
                                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                                        .setWidth("200px")
                                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                                )
                                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                        .setWidth("250px")
                                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getEmail())))
                                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                                )
                        )
                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setWidth("200px")
                                .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getPhone())))
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                                            if (cell.getRecord().getAge() < 35) {
                                                cell.appendChild(Badge.create("Young")
                                                        .addCss(dui_green, dui_float_none));
                                            }else {
                                                cell.appendChild(text(""));
                                            }
                                        })
                )
                .addPlugin(scrollingPaginationPlugin)
                .addPlugin(new TopPanelPlugin<Contact>() {

                    @Override
                    public HTMLElement element() {
                        return topPanel.element();
                    }

                    @Override
                    public void handleEvent(DominoEvent event) {
                        if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
                            topPanel.update((TableDataUpdatedEvent<Contact>) event);
                        }
                    }
                })
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(Icons.close_circle()
                                    .clickable()
                                    .setTooltip("Select Inactive")
                                    .addClickListener(evt ->
                                            datatable.getRows().forEach(item -> {
                                                if (!item.getRecord().isActive()) {
                                                    item.select();
                                                } else {
                                                    item.deselect();
                                                }
                                            }))))
                            .appendChild(PostfixAddOn.of(Icons.check_circle()
                                    .clickable()
                                    .setTooltip("Select Active")
                                    .addClickListener(evt ->
                                            datatable.getRows().forEach(tableRow -> {
                                                if (tableRow.getRecord().isActive()) {
                                                    tableRow.select();
                                                } else {
                                                    tableRow.deselect();
                                                }
                                            }))))
                    ;
                }))
                .addPlugin(new RecordDetailsPlugin<>((RecordDetailsRenderer<Contact>)  cell -> cell.appendChild(new ContactDetails(cell))))
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RowMarkerPlugin<>(cellInfo -> ContactUiUtils.getBalanceColor(cellInfo.getRecord()).color().getContextColor()))
                .addPlugin(new SortPlugin<>())
                .addPlugin(ColumnHeaderFilterPlugin.<Contact>create())
                .addPlugin(new GroupingPlugin<>(tableRow -> tableRow.getRecord().getGender().toString(),
                        cell -> {
                            cell
                                    .addCss(dui_border,
                                            dui_border_accent_d_3,
                                            dui_border_solid,
                                            dui_p_1,
                                            dui_bg_accent_d_1, dui_fg_white
                                    );
                            return text(cell.getRecord().getGender().getLabel());
                        }));

        LocalListDataStore<Contact> localListDataSource = new LocalListDataStore<Contact>()
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter())
                .setPagination(scrollingPaginationPlugin.getPagination());

        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataSource);

        this.element = div().addCss(dui_p_2)
                .appendChild(table);

        List<Contact> data = ContactsProvider.instance.subList(80);
        localListDataSource.setData(data);
        topPanel.update(data);
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
