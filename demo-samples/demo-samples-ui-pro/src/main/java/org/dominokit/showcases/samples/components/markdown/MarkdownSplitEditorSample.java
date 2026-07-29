package org.dominokit.showcases.samples.components.markdown;

import static org.dominokit.domino.ui.style.FlexCss.dui_grow_1;
import static org.dominokit.domino.ui.style.SizingCss.dui_max_w_48;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_h_96;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;

import elemental2.dom.HTMLDivElement;

import java.util.function.Consumer;

import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.markdown.editor.MarkdownEditorConfig;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreviewConfig;
import org.dominokit.pro.domino.ui.markdown.split.SplitMarkdownEditor;
import org.dominokit.pro.domino.ui.markdown.split.SplitMarkdownEditorConfig;
import org.dominokit.pro.domino.ui.markdown.split.SplitMode;

public class MarkdownSplitEditorSample extends BaseDominoElement<HTMLDivElement, MarkdownSplitEditorSample> {

    private final DivElement element;

    public static MarkdownSplitEditorSample create() {
        return new MarkdownSplitEditorSample();
    }

    public MarkdownSplitEditorSample() {
        SplitMarkdownEditor splitEditor =
                SplitMarkdownEditor.from(
                        SplitMarkdownEditorConfig.builder()
                                .editorConfig(
                                        MarkdownEditorConfig.builder()
                                                .initialValue(MarkdownSamples.split())
                                                .syncScrollEnabled(true)
                                                .renderDebounceMillis(150)
                                                .build())
                                .previewConfig(
                                        MarkdownPreviewConfig.builder()
                                                .markdown(MarkdownSamples.split())
                                                .build())
                                .mode(SplitMode.SPLIT)
                                .build());
        Badge modeBadge = Badge.create("Mode : " + splitEditor.getMode().name());
        Badge syncBadge = Badge.create("Sync scroll : " + (splitEditor.getEditor().isSyncScrollEnabled() ? "On" : "Off"));

        DivElement controls =
                div()
                        .addCss(dui_flex, dui_items_center, dui_gap_2)
                        .appendChild(
                                Button.create("Split")
                                        .addClickListener(
                                                evt -> {
                                                    splitEditor.setMode(SplitMode.SPLIT);
                                                    modeBadge.setTextContent("Mode : " + splitEditor.getMode().name());
                                                }))
                        .appendChild(
                                Button.create("Edit only")
                                        .addClickListener(
                                                evt -> {
                                                    splitEditor.setMode(SplitMode.EDIT_ONLY);
                                                    modeBadge.setTextContent("Mode : " + splitEditor.getMode().name());
                                                }))
                        .appendChild(
                                Button.create("Preview only")
                                        .addClickListener(
                                                evt -> {
                                                    splitEditor.setMode(SplitMode.PREVIEW_ONLY);
                                                    modeBadge.setTextContent("Mode : " + splitEditor.getMode().name());
                                                }))
                        .appendChild(
                                Button.create("Render now")
                                        .addClickListener(evt -> splitEditor.renderNow()))
                        .appendChild(
                                switchButton(
                                        "Sync scroll",
                                        splitEditor.getEditor().isSyncScrollEnabled(),
                                        enabled -> {
                                            splitEditor.getEditor().setSyncScrollEnabled(enabled);
                                            syncBadge.setTextContent("Sync scroll : " + (enabled ? "On" : "Off"));
                                        }));
        this.element =
                div()
                        .addCss("dui-p-2")
                        .addCss(dui_flex, dui_flex_col, dui_gap_2, dui_w_full)
                        .appendChild(div().addCss(dui_flex, dui_items_center, dui_gap_2)
                                .appendChild(modeBadge).appendChild(syncBadge))
                        .appendChild(controls)
                        .appendChild(splitEditor.addCss(dui_grow_1, dui_h_96));
        init(this);
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
