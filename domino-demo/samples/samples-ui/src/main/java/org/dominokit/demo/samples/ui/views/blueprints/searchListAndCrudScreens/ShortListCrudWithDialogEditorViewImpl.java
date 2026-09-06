package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ShortListCrudWithDialogEditorView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ShortListCrudWithDialogEditorSample;

@UiView
public class ShortListCrudWithDialogEditorViewImpl extends BlueprintSamplePageView<ShortListCrudWithDialogEditorView.ShortListCrudWithDialogEditorUiHandlers>
    implements ShortListCrudWithDialogEditorView {

  @Inject
  public ShortListCrudWithDialogEditorViewImpl() {
    super("Short-list CRUD with dialog editor", "Layout: Page header, compact filter row, short table/list, and a primary add button; add/edit opens a modal dialog. Interaction: Users search, sort, add, edit, delete, and confirm changes without leaving the list. Variants: Confirm-before-delete, optimistic updates, or wizard dialog for complex records.");
    addSample("Short-list CRUD with dialog editor", "Layout: Page header, compact filter row, short table/list, and a primary add button; add/edit opens a modal dialog. Interaction: Users search, sort, add, edit, delete, and confirm changes without leaving the list. Variants: Confirm-before-delete, optimistic updates, or wizard dialog for complex records.", ShortListCrudWithDialogEditorSample.class, ShortListCrudWithDialogEditorSample::create);
    initPage();
  }
}
