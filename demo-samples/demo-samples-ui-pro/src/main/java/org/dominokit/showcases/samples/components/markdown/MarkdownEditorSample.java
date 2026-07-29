package org.dominokit.showcases.samples.components.markdown;

import static org.dominokit.domino.ui.style.SizingCss.dui_max_w_24;
import static org.dominokit.domino.ui.style.SizingCss.dui_max_w_32;
import static org.dominokit.domino.ui.style.SizingCss.dui_max_w_48;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;

import elemental2.dom.HTMLDivElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.markdown.editor.MarkdownEditor;
import org.dominokit.pro.domino.ui.markdown.editor.MarkdownEditorConfig;

public class MarkdownEditorSample extends BaseDominoElement<HTMLDivElement, MarkdownEditorSample> {

    private final DivElement element;

    public static MarkdownEditorSample create() {
        return new MarkdownEditorSample();
    }

    public MarkdownEditorSample() {
        MarkdownEditor editor =
            MarkdownEditor.from(
                MarkdownEditorConfig.builder()
                    .initialValue(MarkdownSamples.editor())
                    .placeholder("Write markdown here...")
                    .livePreview(false)
                    .toolbarEnabled(true)
                    .syncScrollEnabled(false)
                    .renderDebounceMillis(150)
                    .build());
        DivElement controls =
            div()
                .addCss(dui_flex, dui_items_center, dui_gap_2)
                .appendChild(
                    switchButton("Toolbar", editor.isToolbarEnabled(), editor::setToolbarEnabled).addCss(dui_max_w_48))
                .appendChild(switchButton("Read only", editor.isReadOnly(), editor::setReadOnly).addCss(dui_max_w_48))
                .appendChild(switchButton("Disabled", editor.isEditorDisabled(), editor::setDisabled).addCss(dui_max_w_48))
                .appendChild(
                    Button.create("Reset content")
                        .addClickListener(evt -> editor.withValue(MarkdownSamples.editor())));
        this.element =
            div()
                .addCss("dui-p-2")
                .addCss(dui_flex, dui_flex_col, dui_gap_2, dui_w_full)
                .appendChild(controls)
                .appendChild(editor);
        init(this);
    }

    private SwitchButton switchButton(String label, boolean checked, Consumer<Boolean> onChange) {
        SwitchButton switchButton =
            SwitchButton.create(label, "Off", "On")
                .condenseLabels()
                .withValue(checked);
        switchButton.addChangeListener((oldValue, newValue) -> onChange.accept(newValue));
        return switchButton;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
