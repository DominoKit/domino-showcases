package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

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
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.SpecialStatesAndConstrainedCompositionsView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.EmptyStateFirstScreenSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.LoadingAndProgressiveContentScreenSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ErrorRecoveryScreenSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ReadOnlyPermissionVariantSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.UnsavedChangesProtectionSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ConflictResolutionScreenSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.ResponsiveDensityTransformationSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.PrintExportOrientedScreenSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.OfflineOrReconnectingWorkspaceSample;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.GuidedFirstRunExperienceSample;

@UiView
public class SpecialStatesAndConstrainedCompositionsViewImpl extends BrixView<HTMLDivElement, SpecialStatesAndConstrainedCompositionsView.SpecialStatesAndConstrainedCompositionsUiHandlers>
    implements SpecialStatesAndConstrainedCompositionsView {

  private final DivElement root;

  @Inject
  public SpecialStatesAndConstrainedCompositionsViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Special states and constrained compositions",
            "Catalog category with 10 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Empty-state-first screen",
                    "Layout: The normal page shell is present but the primary content area explains the absence of records and offers a clear next action. Interaction: Users create the first record, import data, adjust filters, or learn more. Variants: First-use empty state, filtered-empty state, or permission-empty state.",
                    EmptyStateFirstScreenSample.class,
                    EmptyStateFirstScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Loading and progressive-content screen",
                    "Layout: Stable page structure appears immediately while cards, rows, and detail sections load progressively. Interaction: Users can use ready regions while slower regions resolve or retry. Variants: Skeleton loading, staged panels, or table placeholder rows.",
                    LoadingAndProgressiveContentScreenSample.class,
                    LoadingAndProgressiveContentScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Error recovery screen",
                    "Layout: Failed content is localized with a clear explanation, affected region, retry action, and optional diagnostic detail. Interaction: Users retry, change filters, report the issue, or continue with unaffected content. Variants: Full-page failure, partial panel failure, or failed mutation recovery.",
                    ErrorRecoveryScreenSample.class,
                    ErrorRecoveryScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Read-only permission variant",
                    "Layout: Editing controls are removed or replaced with explanatory permission messaging while the information hierarchy remains intact. Interaction: Users inspect, copy, export where allowed, or request access. Variants: Field-level masking, section-level read-only, or complete read-only page.",
                    ReadOnlyPermissionVariantSample.class,
                    ReadOnlyPermissionVariantSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Unsaved-changes protection",
                    "Layout: Editable screen includes dirty-state indicators and an explicit save/cancel footer or toolbar. Interaction: Users save, discard, continue editing, or resolve navigation/unload warnings. Variants: Single form, multi-tab form, or multi-record editing.",
                    UnsavedChangesProtectionSample.class,
                    UnsavedChangesProtectionSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Conflict-resolution screen",
                    "Layout: Local changes and current server values are shown side by side or in a field-level conflict list. Interaction: Users keep local, accept remote, merge fields, and retry the save. Variants: Record conflict, document conflict, or concurrent bulk-change conflict.",
                    ConflictResolutionScreenSample.class,
                    ConflictResolutionScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Responsive density transformation",
                    "Layout: Desktop table/panel composition transforms into cards, drawers, stacked sections, or prioritized fields on narrow screens. Interaction: Users retain the same task flow through mobile-friendly navigation and action placement. Variants: Table-to-card, split-to-drill-in, or toolbar-to-bottom-action-bar.",
                    ResponsiveDensityTransformationSample.class,
                    ResponsiveDensityTransformationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Print/export-oriented screen",
                    "Layout: Screen prioritizes a stable document-like hierarchy, print controls, and export metadata over interactive chrome. Interaction: Users preview, print, download, or select output options. Variants: Invoice, report, certificate, or audit evidence.",
                    PrintExportOrientedScreenSample.class,
                    PrintExportOrientedScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Offline or reconnecting workspace",
                    "Layout: Main content remains usable with visible connection state, queued changes, and synchronization status. Interaction: Users continue work, retry synchronization, inspect conflicts, and recover failed operations. Variants: Field app, intermittent network, or browser-local draft.",
                    OfflineOrReconnectingWorkspaceSample.class,
                    OfflineOrReconnectingWorkspaceSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Guided first-run experience",
                    "Layout: Empty or lightly populated workspace is paired with onboarding steps, contextual tips, and sample actions. Interaction: Users complete setup, skip or resume guidance, and reach the first meaningful result. Variants: Product onboarding, tenant setup, or feature-specific tour.",
                    GuidedFirstRunExperienceSample.class,
                    GuidedFirstRunExperienceSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
