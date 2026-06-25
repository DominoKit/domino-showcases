package org.dominokit.showcases.samples.data;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_border_0;
import static org.dominokit.domino.ui.utils.Domino.dui_border_b;
import static org.dominokit.domino.ui.utils.Domino.dui_border_b_grey_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_max_w_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.small;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import java.util.function.IntConsumer;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.pro.domino.ui.data.CheckableDataListItem;
import org.dominokit.pro.domino.ui.data.DataList;
import org.dominokit.pro.domino.ui.data.DataListItem;

public class DataListSample extends BaseDominoElement<HTMLDivElement, DataListSample> {

  private static final int DEFAULT_ITEMS_COUNT = 250000;

  private final DivElement element;

  public static DataListSample create() {
    return new DataListSample();
  }

  public DataListSample() {
    DataList<DemoContact, DataListItem<DemoContact>> basicDataList = createBasicDataList();
    DataList<DemoContact, DataListItem<DemoContact>> multiSelectDataList =
        createMultiSelectDataList();

    this.element =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(createBasicCard(basicDataList))
            .appendChild(createMultiSelectCard(multiSelectDataList));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  private Card createBasicCard(DataList<DemoContact, DataListItem<DemoContact>> dataList) {
    return Card.create("BASIC DATA LIST")
        .appendChild(
            createLoadCountBox(
                count -> dataList.setItems(ContactGenerator.generateContacts(count))))
        .appendChild(div().setHeight("500px").appendChild(dataList.setWidth("500px")));
  }

  private Card createMultiSelectCard(DataList<DemoContact, DataListItem<DemoContact>> dataList) {
    return Card.create("MULTI SELECT DATA LIST")
        .appendChild(
            createLoadCountBox(
                count -> dataList.setItems(ContactGenerator.generateContacts(count))))
        .appendChild(div().setHeight("500px").appendChild(dataList.setWidth("500px")));
  }

  private IntegerBox createLoadCountBox(IntConsumer onLoad) {
    return IntegerBox.create("Items count")
        .addCss(dui_max_w_64)
        .withValue(DEFAULT_ITEMS_COUNT)
        .apply(
            box ->
                box.appendChild(
                    PostfixAddOn.of(
                        Button.create("Load")
                            .addClickListener(
                                evt -> {
                                  Integer value = box.getValue();
                                  if (value != null && value >= 0) {
                                    onLoad.accept(value);
                                  }
                                }))));
  }

  private DataList<DemoContact, DataListItem<DemoContact>> createBasicDataList() {
    return DataList.<DemoContact, DataListItem<DemoContact>>create(
        record ->
            DataListItem.create(record.getFirstName(), record)
                .addCss(
                    dui_p_2,
                    dui_border_b_grey_l_2,
                    dui_border_b,
                    dui_border_0,
                    dui_border_solid));
  }

  private DataList<DemoContact, DataListItem<DemoContact>> createMultiSelectDataList() {
    return new DataList<DemoContact, DataListItem<DemoContact>>(
            record ->
                CheckableDataListItem.create(record.getFirstName(), record)
                    .appendChild(small().textContent(record.getEmail()))
                    .appendChild(PrefixAddOn.of(Icons.drag_vertical()))
                    .appendChild(PostfixAddOn.of(Icons.information_outline()))
                    .addCss(
                        dui_p_2,
                        dui_border_b_grey_l_2,
                        dui_border_b,
                        dui_border_0,
                        dui_border_solid))
        .setIcon(Icons.file())
        .setTitle("Files")
        .setMultiSelect(true)
        .withHeader(
            (menu, header) ->
                header
                    .appendChild(
                        PostfixAddOn.of(
                            Icons.folder_key_outline()
                                .clickable()
                                .addClickListener(
                                    evt -> Notification.create("Action clicked").show())))
                    .appendChild(
                        PostfixAddOn.of(
                            Icons.folder_heart_outline()
                                .clickable()
                                .addClickListener(
                                    evt -> Notification.create("Action clicked").show())))
                    .appendChild(
                        PostfixAddOn.of(
                            ToggleMdiIcon.create(
                                    Icons.checkbox_multiple_outline().clickable(),
                                    Icons.close_box_multiple_outline().clickable())
                                .toggleOnClick(true)
                                .onToggle(
                                    icon -> {
                                      boolean toggled = icon.isToggled();
                                      DomGlobal.setTimeout(
                                          ignore -> {
                                            if (toggled) {
                                              menu.selectAll();
                                            } else {
                                              menu.deselectAll();
                                            }
                                          },
                                          0);
                                    }))))
        .setSearchable(
            (record, token, caseSensitive) -> {
              if (caseSensitive) {
                return record.getFirstName().contains(token);
              }
              return record.getFirstName().toLowerCase().contains(token.toLowerCase());
            });
  }
}
