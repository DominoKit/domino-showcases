package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ListWithRowExpansionView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ListWithRowExpansionSample;

@UiView
public class ListWithRowExpansionViewImpl extends BlueprintSamplePageView<ListWithRowExpansionView.ListWithRowExpansionUiHandlers>
    implements ListWithRowExpansionView {

  @Inject
  public ListWithRowExpansionViewImpl() {
    super("List with row expansion", "Layout: Compact list shows summary fields while expandable rows reveal secondary details. Interaction: Users expand one or several rows, perform row actions, and preserve expansion during sorting/filtering where possible. Variants: Nested table, inline timeline, or quick-edit expansion.");
    addSample("List with row expansion", "Layout: Compact list shows summary fields while expandable rows reveal secondary details. Interaction: Users expand one or several rows, perform row actions, and preserve expansion during sorting/filtering where possible. Variants: Nested table, inline timeline, or quick-edit expansion.", ListWithRowExpansionSample.class, ListWithRowExpansionSample::create);
    initPage();
  }
}
