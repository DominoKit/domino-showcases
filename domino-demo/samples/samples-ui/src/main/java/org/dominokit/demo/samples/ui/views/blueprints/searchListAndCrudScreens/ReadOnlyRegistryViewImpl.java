package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ReadOnlyRegistryView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ReadOnlyRegistrySample;

@UiView
public class ReadOnlyRegistryViewImpl extends BlueprintSamplePageView<ReadOnlyRegistryView.ReadOnlyRegistryUiHandlers>
    implements ReadOnlyRegistryView {

  @Inject
  public ReadOnlyRegistryViewImpl() {
    super("Read-only registry", "Layout: Search/filter toolbar and a dense data table with no mutation controls. Interaction: Users inspect, sort, export, and open a read-only detail view. Variants: Audit registry, public directory, historical snapshot, or print-oriented layout.");
    addSample("Read-only registry", "Layout: Search/filter toolbar and a dense data table with no mutation controls. Interaction: Users inspect, sort, export, and open a read-only detail view. Variants: Audit registry, public directory, historical snapshot, or print-oriented layout.", ReadOnlyRegistrySample.class, ReadOnlyRegistrySample::create);
    initPage();
  }
}
