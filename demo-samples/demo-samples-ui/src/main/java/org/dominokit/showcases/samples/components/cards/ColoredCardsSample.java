package org.dominokit.showcases.samples.components.cards;

import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_accent_d_1;
import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_accent_d_2;
import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_accent_d_4;
import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_accent_l_3;
import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_accent_l_4;
import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_accent_l_5;
import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_dominant_d_1;
import static org.dominokit.domino.ui.style.FlexCss.dui_justify_center;
import static org.dominokit.domino.ui.style.GenericCss.dui_bg_d_1;
import static org.dominokit.domino.ui.style.GenericCss.dui_bg_l_5;
import static org.dominokit.domino.ui.style.GenericCss.dui_secondary;
import static org.dominokit.domino.ui.style.SizingCss.dui_min_w_24;
import static org.dominokit.domino.ui.style.SizingCss.dui_min_w_32;
import static org.dominokit.domino.ui.style.SizingCss.dui_min_w_48;
import static org.dominokit.domino.ui.style.SpacingUtilitiesCss.dui_p_1;
import static org.dominokit.domino.ui.style.TypographyCss.dui_align_middle;
import static org.dominokit.domino.ui.utils.Domino.br;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_end;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;
import static org.dominokit.domino.ui.utils.Domino.strong;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.cards.HeaderPosition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class ColoredCardsSample extends BaseDominoElement<HTMLDivElement, ColoredCardsSample> {

  private DivElement element;

  public static ColoredCardsSample create() {
    return new ColoredCardsSample();
  }

  public ColoredCardsSample() {
    this.element =
        div()
            .addCss(dui_p_2)
            .appendChild(
                Row.create()
                    .appendChild(Column.span4().appendChild(revenueCard()))
                    .appendChild(Column.span4().appendChild(settingsCard()))
                    .appendChild(Column.span4().appendChild(activityCard())))
            .appendChild(
                Row.create()
                    .appendChild(Column.span4().appendChild(actionsCard()))
                    .appendChild(Column.span4().appendChild(statusCard()))
                    .appendChild(Column.span4().appendChild(plainContentCard())));
    init(this);
  }

  private Card revenueCard() {
    return Card.create("Revenue overview", "A monthly snapshot for the workspace")
        .withContentHeader(
            (card, contentHeader) ->
                contentHeader
                        .addCss(dui_p_1, dui_bg_dominant_d_1)
                        .appendChild(
                    NavBar.create("This month")
                        .appendChild(PrefixAddOn.of(Icons.calendar_today()))
                        .appendChild(PostfixAddOn.of(Badge.create("Live").addCss(dui_success)))))
        .appendChild(
            div()
                .addCss(dui_flex, dui_items_center, dui_gap_2)
                .appendChild(Icons.check_circle())
                .appendChild(strong().textContent("$24,680")))
        .appendChild("12% above the previous month")
        .withContentFooter(
            (card, footer) ->
                footer.appendChild(
                    Alert.create().addCss(dui_success).appendChild("Target reached for this month.")));
  }

  private Card settingsCard() {
    return Card.create("Workspace settings", "Update the team workspace details")
        .addCss(dui_accent)
        .appendChild(TextBox.create("Workspace name").withValue("Design system"))
        .appendChild(TextBox.create("Workspace owner").withValue("team@dominokit.org"))
        .appendChild(SwitchButton.create("Email notifications", "Off", "On").check())
        .withContentFooter(
            (card, footer) ->
                footer
                        .addCss(dui_p_2, dui_bg_accent_d_2)
                    .addCss(dui_flex, dui_justify_end, dui_gap_2)
                    .appendChild(LinkButton.create("Cancel"))
                    .appendChild(Button.create(Icons.check_circle(), "Save").addCss(dui_bg_accent_d_4)));
  }

  private Card activityCard() {
    return Card.create("Team activity", "The latest changes from your team")
        .addCss(dui_blue)
        .withContentHeader(
            (card, contentHeader) ->
                contentHeader
                        .addCss(dui_p_2, dui_bg_d_1)
                        .appendChild(
                    NavBar.create("Recent activity")
                        .appendChild(PrefixAddOn.of(Icons.bell()))
                        .appendChild(PostfixAddOn.of(Icons.cog().clickable()))))
        .appendChild(activityItem(Icons.account(), "Maya updated the design tokens"))
        .appendChild(activityItem(Icons.check_circle(), "Omar approved the button changes"))
        .appendChild(activityItem(Icons.clock_outline(), "A review is scheduled for tomorrow"))
        .withContentFooter(
            (card, footer) ->
                footer.appendChild(
                    Alert.create().dismissible().addCss(dui_warning).appendChild("Three updates need your attention.")));
  }

  private Card actionsCard() {
    return Card.create("Quick actions", "Common workspace actions")
        .setHeaderPosition(HeaderPosition.BOTTOM)
        .withHeader(
            (card, header) ->
                header.addCss(dui_teal).appendChild(PostfixAddOn.of(Icons.cog().clickable())))
            .withBody((card, body) -> body.addCss(dui_flex, dui_justify_center))
        .appendChild(
            div()
                .addCss(dui_flex, dui_flex_col, dui_gap_2)
                .appendChild(Button.create(Icons.account(), "Invite member").addCss(dui_min_w_48))
                .appendChild(Button.create(Icons.calendar_today(), "Schedule review").addCss(dui_min_w_48))
                .appendChild(Button.create(Icons.check_circle(), "Mark complete").addCss(dui_primary, dui_min_w_48))
                .appendChild(Button.create(Icons.check_circle(), "Park task").addCss(dui_secondary, dui_min_w_48))
                .appendChild(Button.create(Icons.check_circle(), "Reassign task").addCss(dui_accent, dui_min_w_48))
        );
  }

  private Card statusCard() {
    return Card.create("System status", "A quick view of connected services")
        .withContentHeader(
            (card, contentHeader) ->
                contentHeader
                        .addCss(dui_p_1, dui_bg_dominant_d_1)
                        .appendChild(
                    NavBar.create("Services")
                        .appendChild(PrefixAddOn.of(Icons.shield()))
                        .appendChild(PostfixAddOn.of(Badge.create("3 online").addCss(dui_success)))))
        .appendChild(
            Alert.create()
                .addCss(dui_success)
                .appendChild(strong().textContent("All systems operational"))
                .appendChild(" Authentication and storage are available."))
        .appendChild(
            Alert.create()
                .addCss(dui_warning)
                .appendChild(strong().textContent("Scheduled maintenance"))
                .appendChild(" Reports will be briefly unavailable tonight."));
  }

  private Card plainContentCard() {
    return Card.create("Plain content", "The original simple card content remains supported")
            .addCss(dui_blue)
        .withHeader(
            (card, header) ->
                header.addCss(dui_accent).appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable())))
        .appendChild(
            "Cards can still contain ordinary text while richer content is composed from Domino UI components.")
            .appendChild(br())
            .appendChild(TextBox.create("Workspace name").withValue("Design system"))
            .appendChild(TextBox.create("Workspace owner").withValue("team@dominokit.org"))
            .appendChild(SwitchButton.create("Email notifications", "Off", "On").check())
            .withContentFooter(
                    (card, footer) ->
                            footer
                                    .addCss(dui_p_2, dui_bg_accent_d_2)
                                    .addCss(dui_flex, dui_justify_end, dui_gap_2)
                                    .appendChild(LinkButton.create("Cancel"))
                                    .appendChild(Button.create(Icons.check_circle(), "Save").addCss(dui_bg_accent_d_4)));
  }

  private DivElement activityItem(Icon<?> icon, String message) {
    return div().addCss(dui_flex, dui_items_center, dui_gap_2).appendChild(icon).appendChild(message);
  }

  @Override
  public HTMLDivElement element() {
    return this.element.element();
  }
}
