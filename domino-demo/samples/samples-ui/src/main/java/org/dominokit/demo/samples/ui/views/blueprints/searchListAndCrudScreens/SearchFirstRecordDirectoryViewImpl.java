package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.SearchFirstRecordDirectoryView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.SearchFirstRecordDirectorySample;

@UiView
public class SearchFirstRecordDirectoryViewImpl extends BlueprintSamplePageView<SearchFirstRecordDirectoryView.SearchFirstRecordDirectoryUiHandlers>
    implements SearchFirstRecordDirectoryView {

  @Inject
  public SearchFirstRecordDirectoryViewImpl() {
    super("Search-first record directory", "Layout: Prominent search input with optional advanced filters; results appear only after a query or suggested search. Interaction: Users search by text, identifier, or facets and open a result. Variants: Typeahead, command-style search, or federated results across entity types.");
    addSample("Search-first record directory", "Layout: Prominent search input with optional advanced filters; results appear only after a query or suggested search. Interaction: Users search by text, identifier, or facets and open a result. Variants: Typeahead, command-style search, or federated results across entity types.", SearchFirstRecordDirectorySample.class, SearchFirstRecordDirectorySample::create);
    initPage();
  }
}
