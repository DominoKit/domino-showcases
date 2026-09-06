package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.SingleSectionEntityFormView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.SingleSectionEntityFormSample;

@UiView
public class SingleSectionEntityFormViewImpl extends BlueprintSamplePageView<SingleSectionEntityFormView.SingleSectionEntityFormUiHandlers>
    implements SingleSectionEntityFormView {

  @Inject
  public SingleSectionEntityFormViewImpl() {
    super("Single-section entity form", "Layout: Page title, grouped fields, validation messages, and a clear save/cancel footer. Interaction: Users enter values, see inline validation, save, reset, or cancel. Variants: Inline page, dialog, drawer, or read-only-to-edit transition.");
    addSample("Single-section entity form", "Layout: Page title, grouped fields, validation messages, and a clear save/cancel footer. Interaction: Users enter values, see inline validation, save, reset, or cancel. Variants: Inline page, dialog, drawer, or read-only-to-edit transition.", SingleSectionEntityFormSample.class, SingleSectionEntityFormSample::create);
    initPage();
  }
}
