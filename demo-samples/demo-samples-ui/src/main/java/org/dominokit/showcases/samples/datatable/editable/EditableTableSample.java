package org.dominokit.showcases.samples.datatable.editable;

import elemental2.dom.DomGlobal;
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
import org.dominokit.domino.ui.datatable.plugins.row.RowClickPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.EmailBox;
import org.dominokit.domino.ui.forms.TelephoneBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.showcases.samples.model.ContactsProvider;
import org.dominokit.showcases.samples.datatable.ContactUiUtils;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.EyeColor;
import org.dominokit.showcases.samples.model.Gender;

import static org.dominokit.domino.ui.forms.FormsStyles.dui_form_select_check_box;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_hide_label;
import static org.dominokit.domino.ui.utils.Domino.dui_min_w_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.text;

public class EditableTableSample extends BaseDominoElement<HTMLDivElement, EditableTableSample> {

    private DivElement element;

    public static EditableTableSample create() {
        return new EditableTableSample();
    }

    public EditableTableSample() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("edit_save", "")
                        .setRenderer(cell -> cell.appendChild(Icons.pencil()
                                .clickable()
                                .setTooltip("Edit")
                                .addClickListener(evt -> cell.getTableRow().edit()))
                        )
                        .setEditableRenderer(cell -> cell.appendChild(Icons.content_save()
                                .clickable()
                                .setTooltip("Save")
                                .addClickListener(evt -> {
                                    if (cell.getTableRow().validate().isValid()) {
                                        cell.getTableRow().save();
                                    }
                                })
                        ))
                )
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
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
                        .setEditableCellRenderer(cell -> {
                            CheckBox activeCheckBox = CheckBox.create()
                                    .addCss(dui_form_select_check_box, dui_hide_label)
                                    .withValue(cell.getRecord().isActive());
                            cell.setDirtyRecordHandler(dirty -> dirty.setActive(activeCheckBox.getValue()));
                            return activeCheckBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getName())))
                        .setEditableCellRenderer(cell -> {
                            TextBox nameBox = TextBox.create()
                                    .withValue(cell.getRecord().getName());

                            cell.setDirtyRecordHandler(dirty -> dirty.setName(nameBox.getValue()));
                            return nameBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setEditableCellRenderer(cell -> {
                            Select<Gender> genderSelect = Select.<Gender>create()
                                    .addCss(dui_min_w_24)
                                    .appendChild(SelectOption.create("Male", Gender.male, "Male"))
                                    .appendChild(SelectOption.create("female", Gender.female, "female"))
                                    .withValue(cell.getRecord().getGender());
                            cell.setDirtyRecordHandler(dirty -> dirty.setGender(genderSelect.getValue()));
                            return genderSelect.element();
                        })
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setEditableCellRenderer(cell -> {
                            Select<EyeColor> eyeColorSelect = Select.<EyeColor>create()
                                    .appendChild(SelectOption.create("Blue", EyeColor.blue, "Blue"))
                                    .appendChild(SelectOption.create("Brown", EyeColor.brown, "Brown"))
                                    .appendChild(SelectOption.create("Green", EyeColor.green, "Green"))
                                    .withValue(cell.getRecord().getEyeColor());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEyeColor(eyeColorSelect.getValue()));
                            return eyeColorSelect.element();
                        })
                        .setTextAlign(CellTextAlign.CENTER))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                        .setEditableRenderer(cell -> {
                            DoubleBox doubleBox = DoubleBox.create()
                                    .setMaxValue(4000.0)
                                    .withValue(cell.getRecord().getBalance());
                            cell.setDirtyRecordHandler(dirty -> dirty.setBalance(doubleBox.getValue()));
                            cell.setCellValidator(doubleBox::validate);
                            cell.appendChild(doubleBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getEmail())))
                        .setEditableRenderer(cell -> {
                            EmailBox emailBox = EmailBox.create()
                                    .withValue(cell.getRecord().getEmail());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEmail(emailBox.getValue()));
                            cell.appendChild(emailBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getPhone())))
                        .setEditableRenderer(cell -> {
                            TelephoneBox telephoneBox = TelephoneBox.create()
                                    .withValue(cell.getRecord().getPhone());

                            cell.setDirtyRecordHandler(dirty -> dirty.setPhone(telephoneBox.getValue()));
                            cell.appendChild(telephoneBox);
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            }
                            cell.appendChild(text(""));
                        })
                )
                .setDirtyRecordHandlers(Contact::new, (originalRecord, dirtyRecord) -> {
                    originalRecord.setActive(dirtyRecord.isActive());
                    originalRecord.setPhone(dirtyRecord.getPhone());
                    originalRecord.setEmail(dirtyRecord.getEmail());
                    originalRecord.setBalance(dirtyRecord.getBalance());
                    originalRecord.setEyeColor(dirtyRecord.getEyeColor());
                    originalRecord.setGender(dirtyRecord.getGender());
                    originalRecord.setName(dirtyRecord.getName());
                })
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)));
                }))
                .addPlugin(new RowClickPlugin<>(tableRow -> {
                    DomGlobal.console.info("CLICKING ON ROW ------------");
                }));

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
