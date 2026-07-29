package org.dominokit.showcases.samples.components.markdown;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;

import elemental2.dom.HTMLDivElement;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.markdown.ext.classes.MarkdownClassExtension;
import org.dominokit.markdown.node.Heading;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreview;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreviewConfig;
import org.dominokit.pro.domino.ui.markdown.render.DominoMarkdownRenderer;

public class MarkdownClassStylingSample extends BaseDominoElement<HTMLDivElement, MarkdownClassStylingSample> {

    private final DivElement element;

    public static MarkdownClassStylingSample create() {
        return new MarkdownClassStylingSample();
    }

    public MarkdownClassStylingSample() {
        MarkdownClassExtension extension =
            MarkdownClassExtension.builder()
                .classes("dui-demo-md")
                .nodeClasses(Heading.class, "demo-md-heading")
                .tagClasses("h1", "demo-md-h1")
                .build();

        MarkdownPreview defaultPreview =
            MarkdownPreview.from(
                MarkdownPreviewConfig.builder()
                    .markdown(MarkdownSamples.classStyling())
                    .build());
        MarkdownPreview styledPreview =
            MarkdownPreview.from(
                MarkdownPreviewConfig.builder()
                    .markdown(MarkdownSamples.classStyling())
                    .renderer(new DominoMarkdownRenderer(List.of(extension)))
                    .build());

        this.element =
            div().addCss("dui-p-2")
                .addCss(dui_flex, dui_flex_col, dui_gap_2, dui_w_full)
                .appendChild(defaultPreview)
                .appendChild(styledPreview);
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
