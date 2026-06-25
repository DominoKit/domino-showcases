package org.dominokit.pages.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoNavigator;

import static org.dominokit.domino.ui.utils.Domino.code;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_black_l_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_4;
import static org.dominokit.domino.ui.utils.Domino.dui_overflow_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_overflow_hidden;
import static org.dominokit.domino.ui.utils.Domino.dui_relative;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded;
import static org.dominokit.domino.ui.utils.Domino.pre;

public class DemoCode extends BaseDominoElement<HTMLDivElement, DemoCode> {

    private final DivElement root;

    public static DemoCode create(String code) {
        return new DemoCode(code);
    }

    public DemoCode(String code) {
        this.root = div()
                .addCss(dui_relative, dui_bg_black_l_3, dui_rounded, dui_overflow_hidden, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_flex, ()->"dui-site-code", dui_overflow_auto)
                        .setCssProperty("max-height", "700px")
                        .appendChild(pre()
                                .addCss(()->"dui-site-pre")
                                .appendChild(code()
                                        .addCss(()->"dui-site-code")
                                        .setInnerHtml(PR.prettyPrintOne(code.replace("<", "&lt;").replace(">", "&gt;"), null, false))
                                )
                        )
                )
                .appendChild(div()
                        .addCss(()->"dui-site-copy-icon")
                        .appendChild(Icons.content_copy()
                                .addCss(dui_fg_white)
                                .clickable()
                                .addClickListener(evt -> {
                                    Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator).clipboard.writeText(code);
                                })
                        )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}