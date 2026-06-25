package org.dominokit.demo.samples.ui.views.components.alerts;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.components.alerts.AlertsView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.components.alerts.BasicAlertsSample;
import org.dominokit.showcases.samples.components.alerts.ContextAlertsSample;
import org.dominokit.showcases.samples.components.alerts.DismissibleAlertsSample;
import org.dominokit.showcases.samples.components.alerts.LinksAlertsSample;

@UiView
public class AlertsViewImpl extends BrixView<HTMLDivElement, AlertsView.AlertsUiHandlers>
    implements AlertsView {

  private final DivElement root;

  @Inject
  public AlertsViewImpl() {
    this.root =
        div()
            .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(
                BlockHeader.create(
                    "Alerts", "First migrated sample page in the new domino-demo rewrite."))
            .appendChild(
                SampleShowcase.create(
                    "Basic alerts",
                    "Color and shape variants from the Brix docs sample.",
                    BasicAlertsSample.class,
                    BasicAlertsSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Context alerts",
                    "Predefined success, info, warning, and error states.",
                    ContextAlertsSample.class,
                    ContextAlertsSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Dismissible alerts",
                    "Alerts that can be closed by the user.",
                    DismissibleAlertsSample.class,
                    DismissibleAlertsSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Links in alerts",
                    "Inline links and richer alert content.",
                    LinksAlertsSample.class,
                    LinksAlertsSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
