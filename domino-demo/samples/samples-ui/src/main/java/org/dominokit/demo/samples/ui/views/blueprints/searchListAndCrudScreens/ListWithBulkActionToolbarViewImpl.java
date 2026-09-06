package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ListWithBulkActionToolbarView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ListWithBulkActionToolbarSample;

@UiView
public class ListWithBulkActionToolbarViewImpl extends SamplePageView<ListWithBulkActionToolbarView.ListWithBulkActionToolbarUiHandlers>
    implements ListWithBulkActionToolbarView {

  @Inject
  public ListWithBulkActionToolbarViewImpl() {
    super("List with bulk action toolbar", "Layout: Selectable rows/cards and a toolbar that appears or changes when selection exists. Interaction: Users select individual/all records, apply a bulk operation, review impact, and confirm. Variants: Bulk edit, assign, archive, export, tag, or status transition.");
    addSample("List with bulk action toolbar", "Layout: Selectable rows/cards and a toolbar that appears or changes when selection exists. Interaction: Users select individual/all records, apply a bulk operation, review impact, and confirm. Variants: Bulk edit, assign, archive, export, tag, or status transition.", ListWithBulkActionToolbarSample.class, ListWithBulkActionToolbarSample::create);
    initPage();
  }
}
