package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.ImportBackedDataEntryFormView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.ImportBackedDataEntryFormSample;

@UiView
public class ImportBackedDataEntryFormViewImpl extends BlueprintSamplePageView<ImportBackedDataEntryFormView.ImportBackedDataEntryFormUiHandlers>
    implements ImportBackedDataEntryFormView {

  @Inject
  public ImportBackedDataEntryFormViewImpl() {
    super("Import-backed data-entry form", "Layout: Manual entry form is paired with upload/import controls and a preview of parsed values. Interaction: Users upload, map, validate, correct, and commit imported data. Variants: CSV, spreadsheet, pasted rows, or API payload preview.");
    addSample("Import-backed data-entry form", "Layout: Manual entry form is paired with upload/import controls and a preview of parsed values. Interaction: Users upload, map, validate, correct, and commit imported data. Variants: CSV, spreadsheet, pasted rows, or API payload preview.", ImportBackedDataEntryFormSample.class, ImportBackedDataEntryFormSample::create);
    initPage();
  }
}
