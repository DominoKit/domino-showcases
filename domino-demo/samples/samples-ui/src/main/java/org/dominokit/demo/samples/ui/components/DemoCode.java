package org.dominokit.demo.samples.ui.components;

import static org.dominokit.domino.ui.utils.Domino.code;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_black_l_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_m_0;
import static org.dominokit.domino.ui.utils.Domino.dui_overflow_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.dui_relative;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded;
import static org.dominokit.domino.ui.utils.Domino.pre;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class DemoCode extends BaseDominoElement<HTMLDivElement, DemoCode> {

  private final DivElement root;

  public static DemoCode create(String sourceCode) {
    return new DemoCode(sourceCode);
  }

  public DemoCode(String sourceCode) {
    this.root =
        div()
            .addCss(dui_relative, dui_bg_black_l_3, dui_rounded)
            .appendChild(
                div()
                    .addCss(dui_overflow_auto)
                    .setCssProperty("max-height", "700px")
                    .appendChild(
                        pre()
                            .addCss(dui_m_0, dui_p_4)
                            .appendChild(
                                code()
                                    .addCss(dui_fg_white)
                                    .setInnerHtml(
                                        PR.prettyPrintOne(
                                            escape(sourceCode), null, false)))));
    init(this);
  }

  private String escape(String sourceCode) {
    return sourceCode.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
