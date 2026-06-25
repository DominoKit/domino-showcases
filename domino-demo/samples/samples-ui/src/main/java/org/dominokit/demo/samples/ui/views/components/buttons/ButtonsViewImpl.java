package org.dominokit.demo.samples.ui.views.components.buttons;

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
import org.dominokit.demo.samples.views.components.buttons.ButtonsView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.components.buttons.ButtonsBasicSample;
import org.dominokit.showcases.samples.components.buttons.ButtonsDropDownSample;
import org.dominokit.showcases.samples.components.buttons.ButtonsGroupsSample;
import org.dominokit.showcases.samples.components.buttons.ButtonsSizeSample;

@UiView
public class ButtonsViewImpl extends BrixView<HTMLDivElement, ButtonsView.ButtonsUiHandlers>
    implements ButtonsView {

  private final DivElement root;

  @Inject
  public ButtonsViewImpl() {
    this.root =
        div()
            .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
            .appendChild(
                BlockHeader.create(
                    "Buttons", "Brix sample page built inside the shared samples module."))
            .appendChild(
                SampleShowcase.create(
                    "Basic buttons",
                    "Baseline button, icon, and disabled states.",
                    ButtonsBasicSample.class,
                    ButtonsBasicSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Button sizes",
                    "Sizing variants for text and icon buttons.",
                    ButtonsSizeSample.class,
                    ButtonsSizeSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Button groups",
                    "Group, vertical, and toolbar examples.",
                    ButtonsGroupsSample.class,
                    ButtonsGroupsSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Dropdown and split buttons",
                    "Directional menus and split-button setups.",
                    ButtonsDropDownSample.class,
                    ButtonsDropDownSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
