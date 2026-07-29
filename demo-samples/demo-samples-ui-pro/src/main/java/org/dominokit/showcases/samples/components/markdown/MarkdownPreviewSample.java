package org.dominokit.showcases.samples.components.markdown;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreview;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreviewConfig;
import org.dominokit.pro.domino.ui.markdown.render.DominoMarkdownRenderer;
import org.dominokit.pro.domino.ui.markdown.render.MarkdownRenderer;
import org.dominokit.pro.domino.ui.markdown.render.MarkdownSanitizer;
import org.dominokit.pro.domino.ui.markdown.render.NoOpMarkdownSanitizer;

public class MarkdownPreviewSample extends BaseDominoElement<HTMLDivElement, MarkdownPreviewSample> {

    private final DivElement element;

    public static MarkdownPreviewSample create() {
        return new MarkdownPreviewSample();
    }

    public MarkdownPreviewSample() {
        MarkdownPreview preview =
            MarkdownPreview.from(
                MarkdownPreviewConfig.builder()
                    .markdown(MarkdownSamples.preview())
                    .build());
        MarkdownRenderer framedRenderer =
            markdown -> "<article class='md-editor-sample__framed-preview'>"
                + new DominoMarkdownRenderer().render(markdown)
                + "</article>";
        MarkdownSanitizer passthroughSanitizer = new NoOpMarkdownSanitizer();
        MarkdownSanitizer trimSanitizer = html -> html == null ? "" : html.trim();

        Badge sourceBadge = Badge.create("Source : Preview One");
        Badge rendererBadge = Badge.create("Renderer : Default");
        Badge sanitizerBadge = Badge.create("Sanitizer : Default");
        Badge htmlBadge = Badge.create("HTML chars : " + htmlLength(preview.getRenderedHtml()));

        DivElement controls =
            div()
                .addCss(dui_flex, dui_items_center, dui_gap_2)
                .appendChild(
                    Button.create("Preview one")
                        .addClickListener(
                            evt -> {
                                preview.setMarkdown(MarkdownSamples.preview());
                                sourceBadge.setTextContent("Source : Preview One");
                                updateHtmlBadge(preview, htmlBadge);
                            }))
                .appendChild(
                    Button.create("Preview two")
                        .addClickListener(
                            evt -> {
                                preview.setMarkdown(MarkdownSamples.previewTwo());
                                sourceBadge.setTextContent("Source : Preview Two");
                                updateHtmlBadge(preview, htmlBadge);
                            }))
                .appendChild(
                    Button.create("Framed renderer")
                        .addClickListener(
                            evt -> {
                                preview.setRenderer(framedRenderer);
                                rendererBadge.setTextContent("Renderer : Framed");
                                updateHtmlBadge(preview, htmlBadge);
                            }))
                .appendChild(
                    Button.create("Default renderer")
                        .addClickListener(
                            evt -> {
                                preview.setRenderer(new DominoMarkdownRenderer());
                                rendererBadge.setTextContent("Renderer : Default");
                                updateHtmlBadge(preview, htmlBadge);
                            }))
                .appendChild(
                    Button.create("Trim sanitizer")
                        .addClickListener(
                            evt -> {
                                preview.setSanitizer(trimSanitizer);
                                sanitizerBadge.setTextContent("Sanitizer : Trim");
                                updateHtmlBadge(preview, htmlBadge);
                            }))
                .appendChild(
                    Button.create("Default sanitizer")
                        .addClickListener(
                            evt -> {
                                preview.setSanitizer(passthroughSanitizer);
                                sanitizerBadge.setTextContent("Sanitizer : Default");
                                updateHtmlBadge(preview, htmlBadge);
                            }));

        this.element =
            div()
                .addCss("dui-p-2")
                .addCss(dui_flex, dui_flex_col, dui_gap_2, dui_w_full)
                .appendChild(div().addCss(dui_flex, dui_items_center, dui_gap_2).appendChild(sourceBadge).appendChild(rendererBadge).appendChild(sanitizerBadge).appendChild(htmlBadge))
                .appendChild(controls)
                .appendChild(preview);
        init(this);
    }

    private static void updateHtmlBadge(MarkdownPreview preview, Badge htmlBadge) {
        htmlBadge.setTextContent("HTML chars : " + htmlLength(preview.getRenderedHtml()));
    }

    private static int htmlLength(String html) {
        return html == null ? 0 : html.length();
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
