package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.InlineEditableTableView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.InlineEditableTableSample;

@UiView
public class InlineEditableTableViewImpl extends BlueprintSamplePageView<InlineEditableTableView.InlineEditableTableUiHandlers>
    implements InlineEditableTableView {

  @Inject
  public InlineEditableTableViewImpl() {
    super("Inline-editable table", "Layout: Table rows or cells become editable in place with row-level save/cancel controls. Interaction: Users edit several fields quickly, validate, commit, or discard row changes. Variants: Single-cell editing, row editing, keyboard navigation, or draft autosave.");
    addSample("Inline-editable table", "Layout: Table rows or cells become editable in place with row-level save/cancel controls. Interaction: Users edit several fields quickly, validate, commit, or discard row changes. Variants: Single-cell editing, row editing, keyboard navigation, or draft autosave.", InlineEditableTableSample.class, InlineEditableTableSample::create);
    initPage();
  }
}
