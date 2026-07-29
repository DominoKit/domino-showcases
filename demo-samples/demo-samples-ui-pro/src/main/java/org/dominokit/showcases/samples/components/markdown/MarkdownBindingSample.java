package org.dominokit.showcases.samples.components.markdown;

import static org.dominokit.domino.ui.style.SizingCss.dui_max_w_48;
import static org.dominokit.domino.ui.style.SizingCss.dui_w_48;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;

import elemental2.dom.HTMLDivElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.markdown.editor.MarkdownEditor;
import org.dominokit.pro.domino.ui.markdown.editor.MarkdownEditorConfig;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreview;
import org.dominokit.pro.domino.ui.markdown.preview.MarkdownPreviewConfig;

public class MarkdownBindingSample extends BaseDominoElement<HTMLDivElement, MarkdownBindingSample> {

    private final DivElement element;

    public static MarkdownBindingSample create() {
        return new MarkdownBindingSample();
    }

    public MarkdownBindingSample() {
        MarkdownEditor editor =
            MarkdownEditor.from(
                MarkdownEditorConfig.builder()
                    .initialValue(MarkdownSamples.binding())
                    .syncScrollEnabled(true)
                    .renderDebounceMillis(100)
                    .build());
        MarkdownPreview preview =
            MarkdownPreview.from(
                MarkdownPreviewConfig.builder()
                    .markdown(MarkdownSamples.binding())
                    .build());
        Badge bindingBadge = Badge.create("Binding : Active");
        Badge syncScrollBadge = Badge.create("Sync scroll : " + (editor.isSyncScrollEnabled() ? "On" : "Off"));

        DivElement controls =
            div()
                .addCss(dui_flex, dui_items_center, dui_gap_2)
                .appendChild(
                    Button.create("Bind preview")
                        .addClickListener(
                            evt -> {
                                editor.bindPreview(preview);
                                bindingBadge.setTextContent("Binding : Active");
                            }))
                .appendChild(
                    Button.create("Unbind preview")
                        .addClickListener(
                            evt -> {
                                editor.unbindPreview();
                                bindingBadge.setTextContent("Binding : None");
                            }))
                .appendChild(
                    Button.create("Render now")
                        .addClickListener(evt -> editor.renderNow()))
                .appendChild(
                    switchButton(
                        "Sync scroll",
                        editor.isSyncScrollEnabled(),
                        enabled -> {
                            editor.setSyncScrollEnabled(enabled);
                            syncScrollBadge.setTextContent("Sync scroll : " + (enabled ? "On" : "Off"));
                        }));
        editor.bindPreview(preview);
        this.element =
            div().addCss("dui-p-2")
                .addCss(dui_flex, dui_flex_col, dui_gap_2, dui_w_full)
                .appendChild(div().addCss(dui_flex, dui_items_center, dui_gap_2).appendChild(bindingBadge).appendChild(syncScrollBadge))
                .appendChild(controls)
                .appendChild(editor)
                .appendChild(preview);
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
