package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.TwoColumnFormWithContextualHelpView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.TwoColumnFormWithContextualHelpSample;

@UiView
public class TwoColumnFormWithContextualHelpViewImpl extends SamplePageView<TwoColumnFormWithContextualHelpView.TwoColumnFormWithContextualHelpUiHandlers>
    implements TwoColumnFormWithContextualHelpView {

  @Inject
  public TwoColumnFormWithContextualHelpViewImpl() {
    super("Two-column form with contextual help", "Layout: Fields occupy a primary column while descriptions, examples, or help occupy a secondary column. Interaction: Users fill fields while consulting inline help, tooltips, or documentation links. Variants: Help rail, inline expandable help, or responsive stacked layout.");
    addSample("Two-column form with contextual help", "Layout: Fields occupy a primary column while descriptions, examples, or help occupy a secondary column. Interaction: Users fill fields while consulting inline help, tooltips, or documentation links. Variants: Help rail, inline expandable help, or responsive stacked layout.", TwoColumnFormWithContextualHelpSample.class, TwoColumnFormWithContextualHelpSample::create);
    initPage();
  }
}
