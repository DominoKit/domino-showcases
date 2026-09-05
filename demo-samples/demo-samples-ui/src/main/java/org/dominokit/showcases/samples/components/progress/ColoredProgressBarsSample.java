package org.dominokit.showcases.samples.components.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_brown;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_filled;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_minimal;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_subtle;
import static org.dominokit.domino.ui.utils.Domino.dui_error;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;

public class ColoredProgressBarsSample extends BaseDominoElement<HTMLDivElement, ColoredProgressBarsSample> {

    private DivElement element;

    public static ColoredProgressBarsSample create() {
        return new ColoredProgressBarsSample();
    }

    public ColoredProgressBarsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_success)
                                .addCss(dui_emphasis_filled)
                                .setValue(80))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_warning)
                                .addCss(dui_emphasis_subtle)
                                .setValue(60))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_info)
                                .addCss(dui_emphasis_minimal)
                                .setValue(70))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_error)
                                .setValue(30))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_pink)
                                .setValue(90))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_purple)
                                .setValue(60))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_teal)
                                .setValue(75))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_brown)
                                .setValue(40))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
