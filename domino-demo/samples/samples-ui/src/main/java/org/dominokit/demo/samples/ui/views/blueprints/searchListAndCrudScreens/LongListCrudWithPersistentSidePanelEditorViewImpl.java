package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.LongListCrudWithPersistentSidePanelEditorView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.LongListCrudWithPersistentSidePanelEditorSample;

@UiView
public class LongListCrudWithPersistentSidePanelEditorViewImpl extends SamplePageView<LongListCrudWithPersistentSidePanelEditorView.LongListCrudWithPersistentSidePanelEditorUiHandlers>
    implements LongListCrudWithPersistentSidePanelEditorView {

  @Inject
  public LongListCrudWithPersistentSidePanelEditorViewImpl() {
    super("Long-list CRUD with persistent side-panel editor", "Layout: Dense list occupies the main region while a right-side editor opens without removing the list. Interaction: Users select a row, edit it in context, save, and continue to another row. Variants: Resizable panel, read-only preview before edit, or stacked mobile drawer.");
    addSample("Long-list CRUD with persistent side-panel editor", "Layout: Dense list occupies the main region while a right-side editor opens without removing the list. Interaction: Users select a row, edit it in context, save, and continue to another row. Variants: Resizable panel, read-only preview before edit, or stacked mobile drawer.", LongListCrudWithPersistentSidePanelEditorSample.class, LongListCrudWithPersistentSidePanelEditorSample::create);
    initPage();
  }
}
