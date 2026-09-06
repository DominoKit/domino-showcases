package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ListWithSavedFiltersAndViewsView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ListWithSavedFiltersAndViewsSample;

@UiView
public class ListWithSavedFiltersAndViewsViewImpl extends SamplePageView<ListWithSavedFiltersAndViewsView.ListWithSavedFiltersAndViewsUiHandlers>
    implements ListWithSavedFiltersAndViewsView {

  @Inject
  public ListWithSavedFiltersAndViewsViewImpl() {
    super("List with saved filters and views", "Layout: Filter controls and a view selector sit above a reusable table/list. Interaction: Users save filter/sort/column configurations, share them, and set defaults. Variants: Personal/team scopes, pinned favorites, or permission-aware views.");
    addSample("List with saved filters and views", "Layout: Filter controls and a view selector sit above a reusable table/list. Interaction: Users save filter/sort/column configurations, share them, and set defaults. Variants: Personal/team scopes, pinned favorites, or permission-aware views.", ListWithSavedFiltersAndViewsSample.class, ListWithSavedFiltersAndViewsSample::create);
    initPage();
  }
}
