package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ComparisonListView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ComparisonListSample;

@UiView
public class ComparisonListViewImpl extends SamplePageView<ComparisonListView.ComparisonListUiHandlers>
    implements ComparisonListView {

  @Inject
  public ComparisonListViewImpl() {
    super("Comparison list", "Layout: Results list includes selection controls and a comparison tray or compare button. Interaction: Users select a bounded number of records and compare shared fields side by side. Variants: Product comparison, policy comparison, or before/after version comparison.");
    addSample("Comparison list", "Layout: Results list includes selection controls and a comparison tray or compare button. Interaction: Users select a bounded number of records and compare shared fields side by side. Variants: Product comparison, policy comparison, or before/after version comparison.", ComparisonListSample.class, ComparisonListSample::create);
    initPage();
  }
}
