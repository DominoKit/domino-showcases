package org.dominokit.demo.shell.ui.components;

import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_dominant_d_2;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_absolute;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_dominant_d_1;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_yellow_d_1;
import static org.dominokit.domino.ui.utils.Domino.dui_border_4;
import static org.dominokit.domino.ui.utils.Domino.dui_border_dominant_l_4;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_dominant;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_font_size_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_font_size_8;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_h_16;
import static org.dominokit.domino.ui.utils.Domino.dui_h_24;
import static org.dominokit.domino.ui.utils.Domino.dui_h_48;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_order_10;
import static org.dominokit.domino.ui.utils.Domino.dui_overflow_visible;
import static org.dominokit.domino.ui.utils.Domino.dui_p_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_6;
import static org.dominokit.domino.ui.utils.Domino.dui_relative;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_top_4;
import static org.dominokit.domino.ui.utils.Domino.dui_w_24;
import static org.dominokit.domino.ui.utils.Domino.img;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.LabeledIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.utils.Unit;

public class ProfileCard implements IsElement<HTMLDivElement> {

  private final DivElement root;

  private ProfileCard() {
    DivElement infoContainer = div().addCss(dui_flex, dui_flex_col, dui_p_l_4);
    DivElement socialLinks = div()
        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_font_size_8, dui_p_t_6)
        .appendChild(Icons.github().clickable())
        .appendChild(Icons.patreon().clickable())
        .appendChild(Icons.twitter().clickable())
        .appendChild(Icons.linkedin().clickable());

    this.root = div()
        .addCss(dui_flex, dui_flex_col, dui_order_10, dui_overflow_visible)
        .appendChild(div()
            .addCss(dui_bg_dominant_d_2, dui_h_16, dui_relative)
            .appendChild(img(Resources.INSTANCE.logo().getSafeUri().asString())
                .addCss(
                    dui_bg_yellow_d_1,
                    CompositeCssClass.of(dui_border_4, dui_border_dominant_l_4, dui_border_solid),
                    dui_rounded_full,
                    dui_absolute,
                    dui_w_24,
                    dui_h_24,
                    dui_top_4)
                .setLeft(Calc.sub(Unit.percent.of(50), Unit.em.of(3)))))
        .appendChild(div()
            .addCss(dui_dominant, dui_h_48, dui_flex, dui_flex_col, dui_font_size_3_5, dui_p_14)
            .apply(container -> {
              try {
                Resources.INSTANCE.build().getText(new ResourceCallback<TextResource>() {
                  @Override
                  public void onError(ResourceException e) {
                    DomGlobal.console.error("failed ", e);
                  }

                  @Override
                  public void onSuccess(TextResource resource) {
                    String[] buildInfo = resource.getText().split(",");
                    container
                        .appendChild(infoContainer
                            .appendChild(LabeledIcon.create(Icons.email(), "info@dominokit.com"))
                            .appendChild(LabeledIcon.create(Icons.clock_outline(), buildInfo[0]))
                            .appendChild(LabeledIcon.create(Icons.source_branch(), buildInfo[1])))
                        .appendChild(socialLinks);
                  }
                });
              } catch (Exception e) {
                DomGlobal.console.error("Failed to load build time : ", e);
              }
            }));
  }

  public static ProfileCard create() {
    return new ProfileCard();
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  interface Resources extends ClientBundle {
    Resources INSTANCE = GWT.create(Resources.class);

    @Source("build.txt")
    ExternalTextResource build();

    @Source("images/logo/128.png")
    ImageResource logo();
  }
}
