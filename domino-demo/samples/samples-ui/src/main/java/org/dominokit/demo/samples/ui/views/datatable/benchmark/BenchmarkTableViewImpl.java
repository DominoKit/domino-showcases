package org.dominokit.demo.samples.ui.views.datatable.benchmark;

import static org.dominokit.domino.ui.style.SpacingCss.dui_w_96;
import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_hide_label;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_italic;
import static org.dominokit.domino.ui.utils.Domino.dui_text_sm;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.span;
import static org.dominokit.domino.ui.utils.Domino.text;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableRowElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import javax.inject.Inject;
import jsinterop.base.Js;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.datatable.benchmark.BenchmarkTableView;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.utils.PostfixAddOn;

@UiView
public class BenchmarkTableViewImpl extends SamplePageView<BenchmarkTableView.BenchmarkTableUiHandlers>
    implements BenchmarkTableView {

  private static final int DEFAULT_ROW_COUNT = 5_000;

  private static final List<BenchmarkColumn> TEXT_COLUMNS =
      Arrays.asList(
          column("id", "#", CellTextAlign.RIGHT, contact -> String.valueOf(contact.getId() + 1)),
          column("isActive", "Active", CellTextAlign.LEFT, contact -> String.valueOf(contact.isActive())),
          column("firstName", "First Name", CellTextAlign.LEFT, BenchmarkContact::getFirstName),
          column("lastName", "Last Name", CellTextAlign.LEFT, BenchmarkContact::getLastName),
          column("email", "Email", CellTextAlign.LEFT, BenchmarkContact::getEmail),
          column("phone", "Phone", CellTextAlign.LEFT, BenchmarkContact::getPhone),
          column("address", "Address", CellTextAlign.LEFT, BenchmarkContact::getAddress),
          column("city", "City", CellTextAlign.LEFT, BenchmarkContact::getCity),
          column("state", "State", CellTextAlign.LEFT, BenchmarkContact::getState),
          column("zipCode", "ZIP Code", CellTextAlign.LEFT, BenchmarkContact::getZipCode),
          column("country", "Country", CellTextAlign.LEFT, BenchmarkContact::getCountry),
          column("birthDate", "Birth Date", CellTextAlign.LEFT, BenchmarkTableViewImpl::formatDate),
          column("company", "Company", CellTextAlign.LEFT, BenchmarkContact::getCompany),
          column("jobTitle", "Job Title", CellTextAlign.LEFT, BenchmarkContact::getJobTitle),
          column("department", "Department", CellTextAlign.LEFT, BenchmarkContact::getDepartment),
          column("website", "Website", CellTextAlign.LEFT, BenchmarkContact::getWebsite),
          column("twitterHandle", "Twitter Handle", CellTextAlign.LEFT, BenchmarkContact::getTwitterHandle),
          column("facebookId", "Facebook Id", CellTextAlign.LEFT, BenchmarkContact::getFacebookId),
          column("linkedinProfile", "LinkedIn Profile", CellTextAlign.LEFT, BenchmarkContact::getLinkedinProfile),
          column("notes", "Notes", CellTextAlign.LEFT, BenchmarkContact::getNotes),
          column("createdAt", "Created At", CellTextAlign.LEFT, BenchmarkTableViewImpl::formatCreatedAt),
          column("updatedAt", "Updated At", CellTextAlign.LEFT, BenchmarkTableViewImpl::formatUpdatedAt),
          column("rating", "Rating", CellTextAlign.LEFT, contact -> String.valueOf(contact.getRating())),
          column("customField1", "Custom Field-1", CellTextAlign.LEFT, BenchmarkContact::getCustomField1),
          column("customField2", "Custom Field-2", CellTextAlign.LEFT, contact -> String.valueOf(contact.getCustomField2())));

  @Inject
  public BenchmarkTableViewImpl() {
    super(
        "Benchmark Table",
        "Compare Domino UI tables, widget-heavy cells, raw DOM rendering, and GWT CellTable with the same wide dataset.");

    root.appendChild(
        div()
            .addCss(dui_text_sm, dui_italic)
            .textContent(
                "The measurements focus on render/update time after the dataset is already generated for the selected row count."));
    root.appendChild(createTextCellsBenchmarkCard());
    root.appendChild(createWidgetCellsBenchmarkCard());
    root.appendChild(createPlainDomBenchmarkCard());
    root.appendChild(createGwtCellTableBenchmarkCard());
    initPage();
  }

  private Card createTextCellsBenchmarkCard() {
    BenchmarkDataset dataset = BenchmarkDataset.create(DEFAULT_ROW_COUNT);
    LocalListDataStore<BenchmarkContact> store = new LocalListDataStore<>();
    DataTable<BenchmarkContact> table = new DataTable<>(createTextTableConfig(), store);
    SpanElement timeElement = span().textContent("Took: -");

    return createBenchmarkCard(
        "Text Cells Table",
        "Domino UI DataTable with 25 text-only renderers.",
        dataset,
        timeElement,
        () -> measureRender(timeElement, () -> store.setData(dataset.data())),
        table);
  }

  private Card createWidgetCellsBenchmarkCard() {
    BenchmarkDataset dataset = BenchmarkDataset.create(DEFAULT_ROW_COUNT);
    LocalListDataStore<BenchmarkContact> store = new LocalListDataStore<>();
    DataTable<BenchmarkContact> table = new DataTable<>(createWidgetTableConfig(), store);
    SpanElement timeElement = span().textContent("Took: -");

    return createBenchmarkCard(
        "Widget Cells Table",
        "Domino UI DataTable with checkboxes, inputs, selects, and link-like anchors mixed into the same 25-column layout.",
        dataset,
        timeElement,
        () -> measureRender(timeElement, () -> store.setData(dataset.data())),
        table);
  }

  private Card createPlainDomBenchmarkCard() {
    BenchmarkDataset dataset = BenchmarkDataset.create(DEFAULT_ROW_COUNT);
    SpanElement timeElement = span().textContent("Took: -");
    DivElement container = div().style("overflow-x:auto; width:100%;");

    return createBenchmarkCard(
        "Plain DOM Table",
        "Raw DOM table rendering without Domino UI DataTable abstractions.",
        dataset,
        timeElement,
        () ->
            measureRender(
                timeElement,
                () -> {
                  container.clearElement();
                  container.appendChild(elementOf(createPlainHtmlTable(dataset.data())));
                }),
        container);
  }

  private Card createGwtCellTableBenchmarkCard() {
    BenchmarkDataset dataset = BenchmarkDataset.create(DEFAULT_ROW_COUNT);
    CellTable<BenchmarkContact> cellTable = new CellTable<>(1_000_000, BenchmarkContact::getId);
    SpanElement timeElement = span().textContent("Took: -");

    cellTable.setAutoHeaderRefreshDisabled(true);
    cellTable.setAutoFooterRefreshDisabled(true);
    initGwtCellTableColumns(cellTable);

    return createBenchmarkCard(
        "GWT CellTable",
        "Legacy GWT CellTable rendering the same text dataset for comparison.",
        dataset,
        timeElement,
        () ->
            measureRender(
                timeElement,
                () -> {
                  cellTable.setRowCount(dataset.data().size(), true);
                  cellTable.setRowData(0, dataset.data());
                }),
        div()
            .style("overflow-x:auto; width:100%;")
            .appendChild(elementOf(Js.<Element>uncheckedCast(cellTable.getElement()))));
  }

  private Card createBenchmarkCard(
      String title,
      String description,
      BenchmarkDataset dataset,
      SpanElement timeElement,
      Runnable loadAction,
      IsElement<?> content) {
    Card card = Card.create(title, description).setCollapsible(true);

    card.appendChild(
        dataset
            .countBox()
            .addCss(dui_w_96)
            .appendChild(
                PostfixAddOn.of(
                    Button.create("Load Data")
                        .addCss(dui_primary)
                        .addClickListener(
                            evt -> {
                              if (dataset.countBox().validate().isValid()) {
                                loadAction.run();
                              } else {
                                timeElement.textContent("Took: invalid row count");
                              }
                            }))));
    card.appendChild(timeElement);
    card.appendChild(content);
    return card;
  }

  private TableConfig<BenchmarkContact> createTextTableConfig() {
    TableConfig<BenchmarkContact> tableConfig = new TableConfig<>();
    TEXT_COLUMNS.forEach(
        column ->
            tableConfig.addColumn(
                ColumnConfig.<BenchmarkContact>create(column.key(), column.header())
                    .setTextAlign(column.textAlign())
                    .setHeaderTextAlign(column.textAlign())
                    .setRenderer(cell -> cell.appendChild(text(column.value(cell.getRecord()))))));
    return tableConfig;
  }

  private TableConfig<BenchmarkContact> createWidgetTableConfig() {
    TableConfig<BenchmarkContact> tableConfig = new TableConfig<>();

    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("id", "#")
            .setTextAlign(CellTextAlign.RIGHT)
            .setHeaderTextAlign(CellTextAlign.RIGHT)
            .setRenderer(cell -> cell.appendChild(text(String.valueOf(cell.getRecord().getId() + 1)))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("isActive", "Active")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        CheckBox.create().addCss(dui_hide_label).withValue(cell.getRecord().isActive()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("firstName", "First Name")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getFirstName()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("lastName", "Last Name")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getLastName()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("email", "Email")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        a().textContent(cell.getRecord().getEmail()).setHref(cell.getRecord().getEmail()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("rating", "Rating")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        Select.<Double>create()
                            .addCss(dui_hide_label)
                            .appendChild(SelectOption.create(1.0, "1"))
                            .appendChild(SelectOption.create(2.0, "2"))
                            .appendChild(SelectOption.create(3.0, "3"))
                            .appendChild(SelectOption.create(4.0, "4"))
                            .appendChild(SelectOption.create(5.0, "5"))
                            .withValue(cell.getRecord().getRating()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("website", "Website")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        a()
                            .textContent(cell.getRecord().getWebsite())
                            .setHref(cell.getRecord().getWebsite()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("twitterHandle", "Twitter Handle")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        a()
                            .textContent(cell.getRecord().getTwitterHandle())
                            .setHref(cell.getRecord().getTwitterHandle()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("facebookId", "Facebook Id")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        a()
                            .textContent(cell.getRecord().getFacebookId())
                            .setHref(cell.getRecord().getFacebookId()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("linkedinProfile", "LinkedIn Profile")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        a()
                            .textContent(cell.getRecord().getLinkedinProfile())
                            .setHref(cell.getRecord().getLinkedinProfile()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("phone", "Phone")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getPhone()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("address", "Address")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getAddress()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("city", "City")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getCity()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("state", "State")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getState()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("zipCode", "ZIP Code")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getZipCode()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("country", "Country")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getCountry()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("birthDate", "Birth Date")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(formatDate(cell.getRecord())))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("company", "Company")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getCompany()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("jobTitle", "Job Title")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getJobTitle()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("department", "Department")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getDepartment()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("notes", "Notes")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getNotes()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("createdAt", "Created At")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(formatCreatedAt(cell.getRecord())))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("updatedAt", "Updated At")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(cell -> cell.appendChild(text(formatUpdatedAt(cell.getRecord())))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("customField1", "Custom Field-1")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        TextBox.create().addCss(dui_hide_label).withValue(cell.getRecord().getCustomField1()))));
    tableConfig.addColumn(
        ColumnConfig.<BenchmarkContact>create("customField2", "Custom Field-2")
            .setTextAlign(CellTextAlign.LEFT)
            .setHeaderTextAlign(CellTextAlign.LEFT)
            .setRenderer(
                cell ->
                    cell.appendChild(
                        IntegerBox.create().addCss(dui_hide_label).withValue(cell.getRecord().getCustomField2()))));

    return tableConfig;
  }

  private HTMLTableElement createPlainHtmlTable(List<BenchmarkContact> contacts) {
    HTMLTableElement table = Js.uncheckedCast(DomGlobal.document.createElement("table"));
    table.setAttribute(
        "style",
        "border-collapse:collapse; min-width:1800px; width:max-content; border:1px solid #d0d7de;");

    HTMLTableRowElement headerRow = Js.uncheckedCast(DomGlobal.document.createElement("tr"));
    TEXT_COLUMNS.forEach(column -> headerRow.appendChild(createHeaderCell(column.header())));
    table.appendChild(headerRow);

    contacts.forEach(
        contact -> {
          HTMLTableRowElement row = Js.uncheckedCast(DomGlobal.document.createElement("tr"));
          TEXT_COLUMNS.forEach(column -> row.appendChild(createBodyCell(column.value(contact))));
          table.appendChild(row);
        });

    return table;
  }

  private HTMLTableCellElement createHeaderCell(String text) {
    HTMLTableCellElement cell = Js.uncheckedCast(DomGlobal.document.createElement("th"));
    cell.textContent = text;
    cell.setAttribute(
        "style",
        "border:1px solid #d0d7de; padding:6px 8px; text-align:left; background:#f6f8fa; white-space:nowrap;");
    return cell;
  }

  private HTMLTableCellElement createBodyCell(String text) {
    HTMLTableCellElement cell = Js.uncheckedCast(DomGlobal.document.createElement("td"));
    cell.textContent = text;
    cell.setAttribute(
        "style",
        "border:1px solid #d0d7de; padding:4px 8px; white-space:nowrap; font-size:12px;");
    return cell;
  }

  private void initGwtCellTableColumns(CellTable<BenchmarkContact> cellTable) {
    TEXT_COLUMNS.forEach(
        definition ->
            cellTable.addColumn(
                new Column<BenchmarkContact, String>(new TextCell()) {
                  @Override
                  public String getValue(BenchmarkContact object) {
                    return definition.value(object);
                  }
                },
                definition.header()));
  }

  private void measureRender(SpanElement timeElement, Runnable renderAction) {
    double start = DomGlobal.performance.now();
    renderAction.run();
    DomGlobal.setTimeout(
        ignored -> {
          double delta = DomGlobal.performance.now() - start;
          timeElement.textContent("Took: " + formatElapsed(delta));
        },
        0);
  }

  private static String formatElapsed(double deltaMillis) {
    double seconds = Math.floor(deltaMillis / 1000d);
    double milliseconds = deltaMillis % 1000d;
    return ((int) seconds) + "s and " + milliseconds + "ms";
  }

  private static String formatDate(BenchmarkContact contact) {
    return contact.getBirthDate().toString();
  }

  private static String formatCreatedAt(BenchmarkContact contact) {
    return new Date(contact.getCreatedAt()).toString();
  }

  private static String formatUpdatedAt(BenchmarkContact contact) {
    return new Date(contact.getUpdatedAt()).toString();
  }

  private static BenchmarkColumn column(
      String key,
      String header,
      CellTextAlign textAlign,
      Function<BenchmarkContact, String> valueProvider) {
    return new BenchmarkColumn(key, header, textAlign, valueProvider);
  }

  private static final class BenchmarkColumn {
    private final String key;
    private final String header;
    private final CellTextAlign textAlign;
    private final Function<BenchmarkContact, String> valueProvider;

    private BenchmarkColumn(
        String key,
        String header,
        CellTextAlign textAlign,
        Function<BenchmarkContact, String> valueProvider) {
      this.key = key;
      this.header = header;
      this.textAlign = textAlign;
      this.valueProvider = valueProvider;
    }

    private String key() {
      return key;
    }

    private String header() {
      return header;
    }

    private CellTextAlign textAlign() {
      return textAlign;
    }

    private String value(BenchmarkContact contact) {
      return valueProvider.apply(contact);
    }
  }

  private static final class BenchmarkDataset {
    private List<BenchmarkContact> data;
    private final IntegerBox countBox;

    private BenchmarkDataset(int initialSize) {
      this.data = new ArrayList<>(BenchmarkContactGenerator.generateContacts(initialSize));
      this.countBox = IntegerBox.create("Row Count").setMarginBottom("0").withValue(initialSize);
      this.countBox.addChangeListener(
          (oldValue, newValue) -> {
            if (countBox.validate().isValid()) {
              data = new ArrayList<>(BenchmarkContactGenerator.generateContacts(countBox.getValue()));
            }
          });
    }

    private static BenchmarkDataset create(int initialSize) {
      return new BenchmarkDataset(initialSize);
    }

    private List<BenchmarkContact> data() {
      return data;
    }

    private IntegerBox countBox() {
      return countBox;
    }
  }
}
