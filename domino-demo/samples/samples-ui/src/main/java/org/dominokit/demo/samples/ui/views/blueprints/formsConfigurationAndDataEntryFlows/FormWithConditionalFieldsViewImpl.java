package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.FormWithConditionalFieldsView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.FormWithConditionalFieldsSample;

@UiView
public class FormWithConditionalFieldsViewImpl extends SamplePageView<FormWithConditionalFieldsView.FormWithConditionalFieldsUiHandlers>
    implements FormWithConditionalFieldsView {

  @Inject
  public FormWithConditionalFieldsViewImpl() {
    super("Form with conditional fields", "Layout: Base fields are visible and dependent sections appear based on selections. Interaction: Users make choices that reveal, hide, enable, or reset related fields. Variants: Rule-driven forms, product configuration, or eligibility forms.");
    addSample("Form with conditional fields", "Layout: Base fields are visible and dependent sections appear based on selections. Interaction: Users make choices that reveal, hide, enable, or reset related fields. Variants: Rule-driven forms, product configuration, or eligibility forms.", FormWithConditionalFieldsSample.class, FormWithConditionalFieldsSample::create);
    initPage();
  }
}
