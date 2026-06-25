package org.dominokit.showcases.samples.data;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_border_0;
import static org.dominokit.domino.ui.utils.Domino.dui_border_b;
import static org.dominokit.domino.ui.utils.Domino.dui_border_b_grey_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_items_start;
import static org.dominokit.domino.ui.utils.Domino.dui_max_w_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import java.util.function.IntConsumer;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pro.domino.ui.data.DataList;
import org.dominokit.pro.domino.ui.data.DataListItem;
import org.dominokit.pro.domino.ui.data.DataSelect;
import org.dominokit.pro.domino.ui.util.KeyProvider;

public class DataSelectSample extends BaseDominoElement<HTMLDivElement, DataSelectSample> {

  private static final int DEFAULT_ITEMS_COUNT = 250000;

  private final DivElement element;

  public static DataSelectSample create() {
    return new DataSelectSample();
  }

  public DataSelectSample() {
    DataList<DemoContact, DataListItem<DemoContact>> dropDownDataList = createDataList();
    DataSelect<DemoContact> dataSelect = createDataSelect();

    this.element =
        div()
            .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(createCard(dropDownDataList, dataSelect));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  private Card createCard(
      DataList<DemoContact, DataListItem<DemoContact>> dropDownDataList,
      DataSelect<DemoContact> dataSelect) {
    return Card.create("BASIC DATA SELECT")
        .appendChild(
            createLoadCountBox(
                count -> dropDownDataList.setItems(ContactGenerator.generateContacts(count))))
        .appendChild(
            div()
                .addCss(dui_flex, dui_flex_col, dui_flex_wrap, dui_gap_4, dui_items_start)
                .appendChild(Button.create("DROP LIST").setDropMenu(dropDownDataList))
                .appendChild(dataSelect));
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

  private DataList<DemoContact, DataListItem<DemoContact>> createDataList() {
    return DataList.<DemoContact, DataListItem<DemoContact>>create(
            record ->
                DataListItem.create(record.getFirstName(), record)
                    .addCss(
                        dui_p_2,
                        dui_border_b_grey_l_2,
                        dui_border_b,
                        dui_border_0,
                        dui_border_solid))
        .setMaxHeight("300px")
        .setMinWidth("500px");
  }

  private DataSelect<DemoContact> createDataSelect() {
    return DataSelect.<DemoContact>create(
            record ->
                DataListItem.create(record.getFirstName(), record)
                    .addCss(
                        dui_p_2,
                        dui_border_b_grey_l_2,
                        dui_border_b,
                        dui_border_0,
                        dui_border_solid),
            KeyProvider.hashCodeKeyProvider())
        .setPlaceholder("Select a contact")
        .setOptions(ContactGenerator.generateContacts(DEFAULT_ITEMS_COUNT));
  }
}
