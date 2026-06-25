package org.dominokit.showcases.samples.forms.input;

import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.PasswordBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.text;

public class BasicFormsInputSample extends BaseDominoElement<HTMLDivElement, BasicFormsInputSample> {

    private DivElement element;

    public static BasicFormsInputSample create() {
        return new BasicFormsInputSample();
    }

    public BasicFormsInputSample() {
        CheckBox textBox = CheckBox.create("Test");

        textBox.withValue(true);

        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Basic Example"))
                .appendChild(Row.create()
                        .appendChild(Button.create("test").addClickListener(this::handleEvent))
                        .span12(textBox.setLabel("User name")
//                                .setPlaceholder("Username")
                        )

                )
                .appendChild(Row.create()
                        .span12(PasswordBox.create().setLabel("Password").setPlaceholder("Password"))
                )
                .appendChild(BlockHeader.create("Different Widths"))
                .appendChild(Row.create()
                        .span6(TextBox.create().setPlaceholder("col-sm-6"))
                        .span6(TextBox.create().setPlaceholder("col-sm-6"))
                )
                .appendChild(Row.create()
                        .span4(TextBox.create().setPlaceholder("col-sm-4"))
                        .span4(TextBox.create().setPlaceholder("col-sm-4"))
                        .span4(TextBox.create().setPlaceholder("col-sm-4"))
                )
                .appendChild(Row.create()
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                        .span3(TextBox.create().setPlaceholder("col-sm-3"))
                )
                .appendChild(BlockHeader.create("Input Status"))
                .appendChild(Row.create()
                        .span4(TextBox.create("Focused").withValue("Focused"))
                        .span4(TextBox.create("Disabled")
                                        .withValue("disabled")
                                        .disable())
                        .span4(TextBox.create("Read only")
                                        .withValue("Sample value")
                                        .setReadOnly(true))
                )
        ;
        init(this);
    }

    private void logMessage() {
        DomGlobal.console.log("This is a test message");
    }

    private void logAnotherMessage() {
        DomGlobal.console.log("This is a test message");
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }

    private void handleEvent(Event evt) {
        logAnotherMessage();
    }

    private void onValueChanged(Boolean old, Boolean newValue) {
        logMessage();
    }
}
