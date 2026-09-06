package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.AdvancedSearchBuilderView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.AdvancedSearchBuilderSample;

@UiView
public class AdvancedSearchBuilderViewImpl extends BlueprintSamplePageView<AdvancedSearchBuilderView.AdvancedSearchBuilderUiHandlers>
    implements AdvancedSearchBuilderView {

  @Inject
  public AdvancedSearchBuilderViewImpl() {
    super("Advanced search builder", "Layout: Search-builder panel exposes field/operator/value rows above a result table. Interaction: Users add conditions, group them with AND/OR, save a search, preview results, and reset criteria. Variants: Basic/advanced toggle, visual query builder, or natural-language search paired with filters.");
    addSample("Advanced search builder", "Layout: Search-builder panel exposes field/operator/value rows above a result table. Interaction: Users add conditions, group them with AND/OR, save a search, preview results, and reset criteria. Variants: Basic/advanced toggle, visual query builder, or natural-language search paired with filters.", AdvancedSearchBuilderSample.class, AdvancedSearchBuilderSample::create);
    initPage();
  }
}
