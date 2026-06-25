package org.dominokit.showcases.samples.components.alerts;

import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.strong;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class LinksAlertsSample extends BaseDominoElement<HTMLDivElement, LinksAlertsSample> {

  private DivElement element;

  public static LinksAlertsSample create() {
    return new LinksAlertsSample();
  }

  public LinksAlertsSample() {
    this.element = div().addCss(dui_p_2)
        .appendChild(Alert.success()
            .addCss(dui_m_b_4)
            .appendChild(strong().textContent("Well done! "))
            .appendChild("You successfully read ")
            .appendChild(a("this important alert message.", "#")))
        .appendChild(Alert.info()
            .addCss(dui_m_b_4)
            .appendChild(strong().textContent("Heads up! "))
            .appendChild("This alert needs your ")
            .appendChild(a("attention", "#"))
            .appendChild(", but it's not super important."))
        .appendChild(Alert.warning()
            .addCss(dui_m_b_4)
            .appendChild(strong().textContent("Warning! "))
            .appendChild("Better check yourself, you're ")
            .appendChild(a("not looking too good", "#"))
            .appendChild("."))
        .appendChild(Alert.error()
            .addCss(dui_m_b_4)
            .appendChild(strong().textContent("Oh snap! "))
            .appendChild(a("Change a few things up", "#"))
            .appendChild(" and try submitting again."));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return this.element.element();
  }
}
