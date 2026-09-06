package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.FormWithDraftAutosaveStateView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.FormWithDraftAutosaveStateSample;

@UiView
public class FormWithDraftAutosaveStateViewImpl extends BlueprintSamplePageView<FormWithDraftAutosaveStateView.FormWithDraftAutosaveStateUiHandlers>
    implements FormWithDraftAutosaveStateView {

  @Inject
  public FormWithDraftAutosaveStateViewImpl() {
    super("Form with draft/autosave state", "Layout: Standard form plus visible draft status, last-saved time, and recovery controls. Interaction: Users edit continuously, recover a draft, manually save, or discard it. Variants: Local draft, server draft, multi-user draft, or offline-capable form.");
    addSample("Form with draft/autosave state", "Layout: Standard form plus visible draft status, last-saved time, and recovery controls. Interaction: Users edit continuously, recover a draft, manually save, or discard it. Variants: Local draft, server draft, multi-user draft, or offline-capable form.", FormWithDraftAutosaveStateSample.class, FormWithDraftAutosaveStateSample::create);
    initPage();
  }
}
