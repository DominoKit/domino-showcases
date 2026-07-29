package org.dominokit.showcases.samples.components.markdown;

import static org.dominokit.domino.ui.style.SizingCss.dui_max_w_48;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;

import elemental2.dom.HTMLDivElement;

import java.util.List;
import java.util.function.Consumer;

import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.markdown.ext.classes.MarkdownClassExtension;
import org.dominokit.pro.domino.ui.markdown.editor.MarkdownEditor;
import org.dominokit.pro.domino.ui.markdown.editor.MarkdownEditorConfig;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreview;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreviewConfig;
import org.dominokit.pro.domino.ui.markdown.render.DominoMarkdownRenderer;
import org.dominokit.pro.domino.ui.markdown.render.MarkdownRenderer;
import org.dominokit.pro.domino.ui.markdown.render.NoOpMarkdownSanitizer;

public class MarkdownPlaygroundSample extends BaseDominoElement<HTMLDivElement, MarkdownPlaygroundSample> {

    private final DivElement element;

    public static MarkdownPlaygroundSample create() {
        return new MarkdownPlaygroundSample();
    }

    public MarkdownPlaygroundSample() {
        MarkdownEditor editor =
                MarkdownEditor.from(
                        MarkdownEditorConfig.builder()
                                .initialValue(MarkdownSamples.playground())
                                .syncScrollEnabled(true)
                                .renderDebounceMillis(250)
                                .build());
        MarkdownPreview preview =
                MarkdownPreview.from(
                        MarkdownPreviewConfig.builder()
                                .markdown(MarkdownSamples.playground())
                                .renderer(new DominoMarkdownRenderer(List.of(createExtension())))
                                .build());
        MarkdownRenderer framedRenderer =
                markdown -> "<article class='md-editor-sample__framed-preview'>"
                        + new DominoMarkdownRenderer().render(markdown)
                        + "</article>";
        Badge rendererBadge = Badge.create("Renderer : Default");
        Badge sanitizerBadge = Badge.create("Sanitizer : Default");
        Badge debounceBadge = Badge.create("Debounce : 250 ms");
        Badge livePreviewBadge = Badge.create("Live preview : On");
        Badge syncScrollBadge = Badge.create("Sync scroll : On");
        Badge markdownCharsBadge = Badge.create("Markdown chars : " + MarkdownSamples.playground().length());
        Badge htmlCharsBadge = Badge.create("HTML chars : " + htmlLength(preview.getRenderedHtml()));
        NoOpMarkdownSanitizer defaultSanitizer = new NoOpMarkdownSanitizer();
        boolean livePreviewEnabled = true;

        editor.addChangeListener((oldValue, newValue) ->
                markdownCharsBadge.setTextContent("Markdown chars : " + newValue.length()));
        editor.addPreviewUpdateListener(html ->
                htmlCharsBadge.setTextContent("HTML chars : " + htmlLength(html)));
        editor.bindPreview(preview);

        DivElement controls =
                div()
                        .addCss(dui_flex, dui_flex_col, dui_gap_2)
                        .appendChild(div()
                                .addCss(dui_flex, dui_items_center, dui_gap_2)
                                .appendChild(
                                        Button.create("Debounce 0")
                                                .addClickListener(
                                                        evt -> {
                                                            editor.setRenderDebounceMillis(0);
                                                            debounceBadge.setTextContent("Debounce : 0 ms");
                                                        }))
                                .appendChild(
                                        Button.create("Debounce 150")
                                                .addClickListener(
                                                        evt -> {
                                                            editor.setRenderDebounceMillis(150);
                                                            debounceBadge.setTextContent("Debounce : 150 ms");
                                                        }))
                                .appendChild(
                                        Button.create("Debounce 500")
                                                .addClickListener(
                                                        evt -> {
                                                            editor.setRenderDebounceMillis(500);
                                                            debounceBadge.setTextContent("Debounce : 500 ms");
                                                        }))
                                .appendChild(
                                        Button.create("Framed renderer")
                                                .addClickListener(
                                                        evt -> {
                                                            editor.setRenderer(framedRenderer);
                                                            rendererBadge.setTextContent("Renderer : Framed");
                                                        }))
                                .appendChild(
                                        Button.create("Default renderer")
                                                .addClickListener(
                                                        evt -> {
                                                            editor.setRenderer(new DominoMarkdownRenderer(List.of(createExtension())));
                                                            rendererBadge.setTextContent("Renderer : Default");
                                                        }))
                                .appendChild(
                                        Button.create("Trim sanitizer")
                                                .addClickListener(
                                                        evt -> {
                                                            editor.setSanitizer(html -> html == null ? "" : html.trim());
                                                            sanitizerBadge.setTextContent("Sanitizer : Trim");
                                                        }))
                                .appendChild(
                                        Button.create("Default sanitizer")
                                                .addClickListener(
                                                        evt -> {
                                                            editor.setSanitizer(defaultSanitizer);
                                                            sanitizerBadge.setTextContent("Sanitizer : Default");
                                                        }))

                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_items_center, dui_gap_2)
                                .appendChild(
                                        switchButton(
                                                "Live preview",
                                                livePreviewEnabled,
                                                enabled -> {
                                                    editor.setLivePreview(enabled);
                                                    livePreviewBadge.setTextContent("Live preview : " + (enabled ? "On" : "Off"));
                                                }))
                                .appendChild(
                                        switchButton(
                                                "Sync scroll",
                                                editor.isSyncScrollEnabled(),
                                                enabled -> {
                                                    editor.setSyncScrollEnabled(enabled);
                                                    syncScrollBadge.setTextContent("Sync scroll : " + (enabled ? "On" : "Off"));
                                                })
                                )
                        );

        this.element =
                div().addCss("dui-p-2")
                        .addCss(dui_flex, dui_flex_col, dui_gap_2, dui_w_full)
                        .appendChild(
                                div()
                                        .addCss(dui_flex, dui_items_center, dui_gap_2)
                                        .appendChild(rendererBadge)
                                        .appendChild(sanitizerBadge)
                                        .appendChild(debounceBadge)
                                        .appendChild(livePreviewBadge)
                                        .appendChild(syncScrollBadge)
                                        .appendChild(markdownCharsBadge)
                                        .appendChild(htmlCharsBadge))
                        .appendChild(controls)
                        .appendChild(editor)
                        .appendChild(preview);
        init(this);
    }

    private MarkdownClassExtension createExtension() {
        return MarkdownClassExtension.builder()
                .classes("markdown-playground")
                .nodeClasses(org.dominokit.markdown.node.Heading.class, "markdown-playground-heading")
                .tagClasses("h1", "markdown-playground-h1")
                .build();
    }

    private static int htmlLength(String html) {
        return html == null ? 0 : html.length();
    }

    private SwitchButton switchButton(String label, boolean checked, Consumer<Boolean> onChange) {
        SwitchButton switchButton =
                SwitchButton.create(label, "Off", "On")
                        .condenseLabels()
                        .withValue(checked)
                        .addCss(dui_max_w_48);
        switchButton.addChangeListener((oldValue, newValue) -> onChange.accept(newValue));
        return switchButton;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
