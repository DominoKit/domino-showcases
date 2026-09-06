package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.MultiSectionLongFormView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.MultiSectionLongFormSample;

@UiView
public class MultiSectionLongFormViewImpl extends SamplePageView<MultiSectionLongFormView.MultiSectionLongFormUiHandlers>
    implements MultiSectionLongFormView {

  @Inject
  public MultiSectionLongFormViewImpl() {
    super("Multi-section long form", "Layout: Form is divided into titled sections with a summary or anchored section navigation. Interaction: Users navigate sections, see completion/validation status, save a draft, and submit. Variants: Accordion sections, sticky section nav, or progressive disclosure.");
    addSample("Multi-section long form", "Layout: Form is divided into titled sections with a summary or anchored section navigation. Interaction: Users navigate sections, see completion/validation status, save a draft, and submit. Variants: Accordion sections, sticky section nav, or progressive disclosure.", MultiSectionLongFormSample.class, MultiSectionLongFormSample::create);
    initPage();
  }
}
