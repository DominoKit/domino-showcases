package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.LongListCrudWithDialogEditorView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.LongListCrudWithDialogEditorSample;

@UiView
public class LongListCrudWithDialogEditorViewImpl extends BlueprintSamplePageView<LongListCrudWithDialogEditorView.LongListCrudWithDialogEditorUiHandlers>
    implements LongListCrudWithDialogEditorView {

  @Inject
  public LongListCrudWithDialogEditorViewImpl() {
    super("Long-list CRUD with dialog editor", "Layout: Toolbar, persistent filters, paginated or virtualized table, and modal editor for add/edit. Interaction: Users navigate pages, apply filters, perform row actions, and edit one record at a time in a dialog. Variants: Server-side search, bulk selection, or side-panel editor instead of modal.");
    addSample("Long-list CRUD with dialog editor", "Layout: Toolbar, persistent filters, paginated or virtualized table, and modal editor for add/edit. Interaction: Users navigate pages, apply filters, perform row actions, and edit one record at a time in a dialog. Variants: Server-side search, bulk selection, or side-panel editor instead of modal.", LongListCrudWithDialogEditorSample.class, LongListCrudWithDialogEditorSample::create);
    initPage();
  }
}
