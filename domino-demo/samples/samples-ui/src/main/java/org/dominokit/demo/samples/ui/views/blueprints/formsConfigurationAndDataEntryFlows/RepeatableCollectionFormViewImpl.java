package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.RepeatableCollectionFormView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.RepeatableCollectionFormSample;

@UiView
public class RepeatableCollectionFormViewImpl extends SamplePageView<RepeatableCollectionFormView.RepeatableCollectionFormUiHandlers>
    implements RepeatableCollectionFormView {

  @Inject
  public RepeatableCollectionFormViewImpl() {
    super("Repeatable collection form", "Layout: One parent form contains repeatable child rows/cards or nested subforms. Interaction: Users add, remove, reorder, and validate child entries before saving the parent. Variants: Line items, addresses, contacts, or rule clauses.");
    addSample("Repeatable collection form", "Layout: One parent form contains repeatable child rows/cards or nested subforms. Interaction: Users add, remove, reorder, and validate child entries before saving the parent. Variants: Line items, addresses, contacts, or rule clauses.", RepeatableCollectionFormSample.class, RepeatableCollectionFormSample::create);
    initPage();
  }
}
