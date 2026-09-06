package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

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
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.FormsConfigurationAndDataEntryFlowsView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.SingleSectionEntityFormSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.MultiSectionLongFormSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.TwoColumnFormWithContextualHelpSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.FormWithConditionalFieldsSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.SteppedWizardSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.WizardWithReviewAndConfirmStepSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.RepeatableCollectionFormSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.FormWithDraftAutosaveStateSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.ConfigurationScreenWithPreviewSample;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.ImportBackedDataEntryFormSample;

@UiView
public class FormsConfigurationAndDataEntryFlowsViewImpl extends BrixView<HTMLDivElement, FormsConfigurationAndDataEntryFlowsView.FormsConfigurationAndDataEntryFlowsUiHandlers>
    implements FormsConfigurationAndDataEntryFlowsView {

  private final DivElement root;

  @Inject
  public FormsConfigurationAndDataEntryFlowsViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Forms, configuration, and data-entry flows",
            "Catalog category with 10 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Single-section entity form",
                    "Layout: Page title, grouped fields, validation messages, and a clear save/cancel footer. Interaction: Users enter values, see inline validation, save, reset, or cancel. Variants: Inline page, dialog, drawer, or read-only-to-edit transition.",
                    SingleSectionEntityFormSample.class,
                    SingleSectionEntityFormSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Multi-section long form",
                    "Layout: Form is divided into titled sections with a summary or anchored section navigation. Interaction: Users navigate sections, see completion/validation status, save a draft, and submit. Variants: Accordion sections, sticky section nav, or progressive disclosure.",
                    MultiSectionLongFormSample.class,
                    MultiSectionLongFormSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Two-column form with contextual help",
                    "Layout: Fields occupy a primary column while descriptions, examples, or help occupy a secondary column. Interaction: Users fill fields while consulting inline help, tooltips, or documentation links. Variants: Help rail, inline expandable help, or responsive stacked layout.",
                    TwoColumnFormWithContextualHelpSample.class,
                    TwoColumnFormWithContextualHelpSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Form with conditional fields",
                    "Layout: Base fields are visible and dependent sections appear based on selections. Interaction: Users make choices that reveal, hide, enable, or reset related fields. Variants: Rule-driven forms, product configuration, or eligibility forms.",
                    FormWithConditionalFieldsSample.class,
                    FormWithConditionalFieldsSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Stepped wizard",
                    "Layout: Stepper indicates progress, with one focused form section per step and a final review. Interaction: Users move back and forward, save progress, validate each step, and submit at the end. Variants: Linear required steps, optional steps, or branching steps.",
                    SteppedWizardSample.class,
                    SteppedWizardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Wizard with review-and-confirm step",
                    "Layout: Data-entry steps are followed by a read-only summary with grouped changes and warnings. Interaction: Users jump back to correct a section, confirm, and submit the complete operation. Variants: Pricing preview, policy acceptance, or batch creation.",
                    WizardWithReviewAndConfirmStepSample.class,
                    WizardWithReviewAndConfirmStepSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Repeatable collection form",
                    "Layout: One parent form contains repeatable child rows/cards or nested subforms. Interaction: Users add, remove, reorder, and validate child entries before saving the parent. Variants: Line items, addresses, contacts, or rule clauses.",
                    RepeatableCollectionFormSample.class,
                    RepeatableCollectionFormSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Form with draft/autosave state",
                    "Layout: Standard form plus visible draft status, last-saved time, and recovery controls. Interaction: Users edit continuously, recover a draft, manually save, or discard it. Variants: Local draft, server draft, multi-user draft, or offline-capable form.",
                    FormWithDraftAutosaveStateSample.class,
                    FormWithDraftAutosaveStateSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Configuration screen with preview",
                    "Layout: Configuration controls occupy one region and a live or sample preview occupies another. Interaction: Users change settings, compare preview states, reset defaults, and publish/apply. Variants: Theme builder, notification template, report layout, or form designer.",
                    ConfigurationScreenWithPreviewSample.class,
                    ConfigurationScreenWithPreviewSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Import-backed data-entry form",
                    "Layout: Manual entry form is paired with upload/import controls and a preview of parsed values. Interaction: Users upload, map, validate, correct, and commit imported data. Variants: CSV, spreadsheet, pasted rows, or API payload preview.",
                    ImportBackedDataEntryFormSample.class,
                    ImportBackedDataEntryFormSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
