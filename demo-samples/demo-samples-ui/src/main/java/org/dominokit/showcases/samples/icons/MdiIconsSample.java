package org.dominokit.showcases.samples.icons;

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_black;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_border_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_clickable;
import static org.dominokit.domino.ui.utils.Domino.dui_elevation_0;
import static org.dominokit.domino.ui.utils.Domino.dui_font_size_10;
import static org.dominokit.domino.ui.utils.Domino.dui_font_size_14;
import static org.dominokit.domino.ui.utils.Domino.dui_font_size_4;
import static org.dominokit.domino.ui.utils.Domino.dui_font_size_6;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_4;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_md;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.input;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import elemental2.dom.ClipboardEvent;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.LabeledIcon;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.lib.MdiByTagFactory;
import org.dominokit.domino.ui.icons.lib.MdiTags;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.PostfixAddOn;

public class MdiIconsSample extends BaseDominoElement<HTMLDivElement, MdiIconsSample> {

  private static final String ALL_TAG = "all";
  private static final String UNTAGGED_TAG = "untagged";
  private static final String UNTAGGED_LABEL = "Untagged";

  public static final Set<String> RESERVED_KEYWORDS =
      new HashSet<>(
          Arrays.asList(
              "abstract",
              "assert",
              "boolean",
              "break",
              "byte",
              "case",
              "catch",
              "char",
              "class",
              "const",
              "continue",
              "default",
              "do",
              "double",
              "else",
              "enum",
              "extends",
              "final",
              "finally",
              "float",
              "for",
              "goto",
              "if",
              "implements",
              "import",
              "instanceof",
              "int",
              "interface",
              "long",
              "native",
              "new",
              "package",
              "private",
              "protected",
              "public",
              "return",
              "short",
              "static",
              "strictfp",
              "super",
              "switch",
              "synchronized",
              "this",
              "throw",
              "throws",
              "transient",
              "try",
              "void",
              "volatile",
              "while",
              "true",
              "false",
              "null"));

  private final DivElement element;
  private final DivElement byTagsContainer;
  private final HTMLInputElement copyInput =
      input("textarea").style("visibility:hidden; width: 0px; height: 0px;").element();
  private final Map<String, Card> iconCards = new HashMap<>();

  private String tag = ALL_TAG;

  public static MdiIconsSample create() {
    return new MdiIconsSample();
  }

  public MdiIconsSample() {
    this.element = div();
    this.byTagsContainer = div();

    element.appendChild(copyInput);
    element.appendChild(createSearchBox());
    element.appendChild(byTagsContainer);
    appendAdvancedFeatures();

    init(this);
  }

  public void setTag(String targetTag) {
    this.tag = normalizeTag(targetTag);
    renderIcons("");
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  private SearchBox createSearchBox() {
    return SearchBox.create()
        .addCss(dui_m_b_4, dui_rounded_md, dui_border, dui_border_teal, dui_border_solid)
        .setAutoSearch(true)
        .setAutoSearchDelay(1000)
        .withTextBox(
            (parent, textBox) ->
                textBox.appendChild(
                    PostfixAddOn.of(
                        ToggleMdiIcon.create(
                                Icons.arrow_collapse_vertical(), Icons.arrow_expand_vertical())
                            .clickable()
                            .apply(
                                self ->
                                    self.addClickListener(
                                        evt -> {
                                          self.toggle();
                                          iconCards.forEach((ignored, card) -> card.toggleCollapse());
                                        })))))
        .addSearchListener(this::renderIcons);
  }

  private void renderIcons(String token) {
    byTagsContainer.clearElement();
    iconCards.clear();

    if (ALL_TAG.equals(tag)) {
      MdiTags.TAGS.forEach(iconTag -> findForTag(token, iconTag));
      return;
    }

    findForTag(token, tag);
  }

  private void findForTag(String token, String tag) {
    GWT.runAsync(
        new RunAsyncCallback() {
          @Override
          public void onFailure(Throwable throwable) {}

          @Override
          public void onSuccess() {
            List<Supplier<MdiIcon>> foundForTag =
                MdiByTagFactory.get(isUntagged(tag) ? MdiTags.UNTAGGED : tag).stream()
                    .filter(
                        supplier -> {
                          MdiIcon mdiIcon = supplier.get();
                          return mdiIcon.getMetaInfo().getAliases().stream()
                                  .anyMatch(
                                      alias ->
                                          token.isEmpty()
                                              || alias.toLowerCase().contains(token.toLowerCase()))
                              || mdiIcon.getMetaInfo().getName().contains(token.toLowerCase())
                              || mdiIcon.getMetaInfo().getTags().stream()
                                  .anyMatch(
                                      iconTag ->
                                          iconTag.toLowerCase().contains(token.toLowerCase()));
                        })
                    .collect(Collectors.toList());

            if (!foundForTag.isEmpty()) {
              iconCards.put(tag, createCategoryCard(tag, foundForTag));
            }
          }
        });
  }

  private boolean isUntagged(String tag) {
    return !isNull(tag)
        && (tag.trim().isEmpty()
            || UNTAGGED_TAG.equalsIgnoreCase(tag.trim())
            || UNTAGGED_LABEL.equalsIgnoreCase(tag.trim()));
  }

  private Card createCategoryCard(String tag, List<Supplier<MdiIcon>> iconsSuppliers) {
    Card card = Card.create(getTagDisplayName(tag)).addCss(dui_elevation_0).setCollapsible(true);
    card.appendChild(PostfixAddOn.of(Badge.create(String.valueOf(iconsSuppliers.size())).addCss(dui_rounded_full)));
    byTagsContainer.appendChild(card.element());

    int rows = (iconsSuppliers.size() / 4) + ((iconsSuppliers.size() % 4) > 0 ? 1 : 0);
    for (int i = 0; i < rows; i++) {
      Row row = Row.create().addCss(dui_m_y_4);
      card.appendChild(row);
      for (int j = i * 4; j < (i * 4 + 4) && j < iconsSuppliers.size(); j++) {
        row.appendChild(Column.span3().appendChild(createDemoIcon(iconsSuppliers.get(j).get())));
      }
    }
    return card;
  }

  private String getTagDisplayName(String tag) {
    return isUntagged(tag) ? UNTAGGED_LABEL : tag;
  }

  private IsElement<HTMLElement> createDemoIcon(Icon<?> icon) {
    return LabeledIcon.create(icon, icon.getName())
        .addCss(dui_clickable)
        .addClickListener(
            evt -> {
              String name = icon.getName().replace("mdi-", "").replace("-", "_");
              copyInput.value = "Icons." + unreservedKeywordName(name) + "()";
              copyInput.select();

              EventListener copyListener =
                  event -> {
                    ClipboardEvent clipboardEvent = Js.uncheckedCast(event);
                    clipboardEvent.clipboardData.setData("text/plain", copyInput.value);
                    event.preventDefault();
                  };

              DomGlobal.document.addEventListener("copy", copyListener);
              DominoDom.document.execCommand("copy");
              DomGlobal.document.removeEventListener("copy", copyListener);
              Notification.create("Copied to clipboard").addCss(dui_info).show();
            });
  }

  private String normalizeTag(String targetTag) {
    if (isNull(targetTag)) {
      return ALL_TAG;
    }

    String normalized =
        targetTag.trim()
            .replace("%20", " ")
            .replace("%2F", "/")
            .replace("%2f", "/")
            .replace("--", "/")
            .replace("_", "/")
            .replaceAll("\\s*/\\s*", " / ")
            .replaceAll("\\s+", " ")
            .trim();

    if (normalized.isEmpty()) {
      return UNTAGGED_LABEL;
    }

    if (ALL_TAG.equalsIgnoreCase(normalized)) {
      return ALL_TAG;
    }

    if (isUntagged(normalized)) {
      return UNTAGGED_LABEL;
    }

    for (String mdiTag : MdiTags.TAGS) {
      if (mdiTag.equalsIgnoreCase(normalized)) {
        return mdiTag;
      }
    }

    return normalized;
  }

  private String unreservedKeywordName(String value) {
    if (RESERVED_KEYWORDS.contains(value)) {
      return value + "_";
    }
    return value;
  }

  private void appendAdvancedFeatures() {
    element.appendChild(
        Card.create("Icons advanced features")
            .addCss(dui_elevation_0)
            .appendChild(BlockHeader.create("Sizes"))
            .appendChild(
                Row.create()
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Size 18px"))
                            .appendChild(Icons.account().addCss(dui_font_size_4)))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Size 24px"))
                            .appendChild(Icons.account().addCss(dui_font_size_6)))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Size 36px"))
                            .appendChild(Icons.account().addCss(dui_font_size_10)))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Size 48px"))
                            .appendChild(Icons.account().addCss(dui_font_size_14))))
            .appendChild(BlockHeader.create("Rotate"))
            .appendChild(
                Row.create()
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("No rotate"))
                            .appendChild(Icons.account()))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Rotate 45"))
                            .appendChild(Icons.account().rotate45()))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Rotate 90"))
                            .appendChild(Icons.account().rotate90()))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Rotate 135"))
                            .appendChild(Icons.account().rotate135())))
            .appendChild(
                Row.create()
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Rotate 180"))
                            .appendChild(Icons.account().rotate180()))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Rotate 255"))
                            .appendChild(Icons.account().rotate225()))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Rotate 270"))
                            .appendChild(Icons.account().rotate270()))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Rotate 315"))
                            .appendChild(Icons.account().rotate315())))
            .appendChild(BlockHeader.create("Flip"))
            .appendChild(
                Row.create()
                    .appendChild(
                        Column.span4()
                            .appendChild(h(6).textContent("No flip"))
                            .appendChild(Icons.account_alert()))
                    .appendChild(
                        Column.span4()
                            .appendChild(h(6).textContent("Flip horizontal"))
                            .appendChild(Icons.account_alert().flipH()))
                    .appendChild(
                        Column.span4()
                            .appendChild(h(6).textContent("Flip vertical"))
                            .appendChild(Icons.account_alert().flipV())))
            .appendChild(BlockHeader.create("Spin"))
            .appendChild(
                Row.create()
                    .appendChild(Column.span6().appendChild(Icons.loading().spin()))
                    .appendChild(Column.span6().appendChild(Icons.star().spin())))
            .appendChild(BlockHeader.create("Contrast"))
            .appendChild(
                Row.create()
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Light"))
                            .appendChild(
                                div()
                                    .style("width: 40px; height:40px")
                                    .addCss(dui_black, dui_font_size_10)
                                    .appendChild(Icons.account().light())))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Light inactive"))
                            .appendChild(
                                div()
                                    .style("width: 40px; height:40px")
                                    .addCss(dui_black, dui_font_size_10)
                                    .appendChild(Icons.account().light().inactive())))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Dark"))
                            .appendChild(Icons.account().dark()))
                    .appendChild(
                        Column.span3()
                            .appendChild(h(6).textContent("Dark inactive"))
                            .appendChild(Icons.account().dark().inactive())))
            .setCollapsible(true));
  }
}
