package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ShortListCrudWithTopSectionEditorView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ShortListCrudWithTopSectionEditorSample;

@UiView
public class ShortListCrudWithTopSectionEditorViewImpl extends BlueprintSamplePageView<ShortListCrudWithTopSectionEditorView.ShortListCrudWithTopSectionEditorUiHandlers>
    implements ShortListCrudWithTopSectionEditorView {

  @Inject
  public ShortListCrudWithTopSectionEditorViewImpl() {
    super("Short-list CRUD with top-section editor", "Layout: A form panel sits above a short list and is used for both add and edit. Interaction: Users select a row to load it into the form, save changes, clear the form, or start a new record. Variants: Always-visible form, collapsible form, or two-column form beside the list.");
    addSample("Short-list CRUD with top-section editor", "Layout: A form panel sits above a short list and is used for both add and edit. Interaction: Users select a row to load it into the form, save changes, clear the form, or start a new record. Variants: Always-visible form, collapsible form, or two-column form beside the list.", ShortListCrudWithTopSectionEditorSample.class, ShortListCrudWithTopSectionEditorSample::create);
    initPage();
  }
}
