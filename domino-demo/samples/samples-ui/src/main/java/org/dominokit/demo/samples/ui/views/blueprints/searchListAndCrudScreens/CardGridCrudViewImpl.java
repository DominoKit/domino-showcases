package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.CardGridCrudView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.CardGridCrudSample;

@UiView
public class CardGridCrudViewImpl extends SamplePageView<CardGridCrudView.CardGridCrudUiHandlers>
    implements CardGridCrudView {

  @Inject
  public CardGridCrudViewImpl() {
    super("Card-grid CRUD", "Layout: Toolbar and filters lead into cards with summary fields, status, and action menu. Interaction: Users open, edit, archive, duplicate, or delete a card, with add handled by a dialog or form page. Variants: Kanban-like cards, image-heavy cards, or responsive grid/list toggle.");
    addSample("Card-grid CRUD", "Layout: Toolbar and filters lead into cards with summary fields, status, and action menu. Interaction: Users open, edit, archive, duplicate, or delete a card, with add handled by a dialog or form page. Variants: Kanban-like cards, image-heavy cards, or responsive grid/list toggle.", CardGridCrudSample.class, CardGridCrudSample::create);
    initPage();
  }
}
