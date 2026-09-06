package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.SearchListAndCrudScreensView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ShortListCrudWithDialogEditorSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ShortListCrudWithTopSectionEditorSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.LongListCrudWithDialogEditorSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.LongListCrudWithPersistentSidePanelEditorSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.InlineEditableTableSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.CardGridCrudSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.SearchFirstRecordDirectorySample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.AdvancedSearchBuilderSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.FacetedCatalogBrowserSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ListWithBulkActionToolbarSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ListWithSavedFiltersAndViewsSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ReadOnlyRegistrySample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ComparisonListSample;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.ListWithRowExpansionSample;

@UiView
public class SearchListAndCrudScreensViewImpl extends BrixView<HTMLDivElement, SearchListAndCrudScreensView.SearchListAndCrudScreensUiHandlers>
    implements SearchListAndCrudScreensView {

  private final DivElement root;

  @Inject
  public SearchListAndCrudScreensViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Search, list, and CRUD screens",
            "Catalog category with 14 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Short-list CRUD with dialog editor",
                    "Layout: Page header, compact filter row, short table/list, and a primary add button; add/edit opens a modal dialog. Interaction: Users search, sort, add, edit, delete, and confirm changes without leaving the list. Variants: Confirm-before-delete, optimistic updates, or wizard dialog for complex records.",
                    ShortListCrudWithDialogEditorSample.class,
                    ShortListCrudWithDialogEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Short-list CRUD with top-section editor",
                    "Layout: A form panel sits above a short list and is used for both add and edit. Interaction: Users select a row to load it into the form, save changes, clear the form, or start a new record. Variants: Always-visible form, collapsible form, or two-column form beside the list.",
                    ShortListCrudWithTopSectionEditorSample.class,
                    ShortListCrudWithTopSectionEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Long-list CRUD with dialog editor",
                    "Layout: Toolbar, persistent filters, paginated or virtualized table, and modal editor for add/edit. Interaction: Users navigate pages, apply filters, perform row actions, and edit one record at a time in a dialog. Variants: Server-side search, bulk selection, or side-panel editor instead of modal.",
                    LongListCrudWithDialogEditorSample.class,
                    LongListCrudWithDialogEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Long-list CRUD with persistent side-panel editor",
                    "Layout: Dense list occupies the main region while a right-side editor opens without removing the list. Interaction: Users select a row, edit it in context, save, and continue to another row. Variants: Resizable panel, read-only preview before edit, or stacked mobile drawer.",
                    LongListCrudWithPersistentSidePanelEditorSample.class,
                    LongListCrudWithPersistentSidePanelEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Inline-editable table",
                    "Layout: Table rows or cells become editable in place with row-level save/cancel controls. Interaction: Users edit several fields quickly, validate, commit, or discard row changes. Variants: Single-cell editing, row editing, keyboard navigation, or draft autosave.",
                    InlineEditableTableSample.class,
                    InlineEditableTableSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Card-grid CRUD",
                    "Layout: Toolbar and filters lead into cards with summary fields, status, and action menu. Interaction: Users open, edit, archive, duplicate, or delete a card, with add handled by a dialog or form page. Variants: Kanban-like cards, image-heavy cards, or responsive grid/list toggle.",
                    CardGridCrudSample.class,
                    CardGridCrudSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Search-first record directory",
                    "Layout: Prominent search input with optional advanced filters; results appear only after a query or suggested search. Interaction: Users search by text, identifier, or facets and open a result. Variants: Typeahead, command-style search, or federated results across entity types.",
                    SearchFirstRecordDirectorySample.class,
                    SearchFirstRecordDirectorySample::create))
            .appendChild(
                SampleShowcase.create(
                    "Advanced search builder",
                    "Layout: Search-builder panel exposes field/operator/value rows above a result table. Interaction: Users add conditions, group them with AND/OR, save a search, preview results, and reset criteria. Variants: Basic/advanced toggle, visual query builder, or natural-language search paired with filters.",
                    AdvancedSearchBuilderSample.class,
                    AdvancedSearchBuilderSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Faceted catalog browser",
                    "Layout: Facet sidebar, result count/sort toolbar, and a list or card grid. Interaction: Users combine facets, remove chips, sort, paginate, and open an item. Variants: Facets on the top for mobile, hierarchical facets, or instant result updates.",
                    FacetedCatalogBrowserSample.class,
                    FacetedCatalogBrowserSample::create))
            .appendChild(
                SampleShowcase.create(
                    "List with bulk action toolbar",
                    "Layout: Selectable rows/cards and a toolbar that appears or changes when selection exists. Interaction: Users select individual/all records, apply a bulk operation, review impact, and confirm. Variants: Bulk edit, assign, archive, export, tag, or status transition.",
                    ListWithBulkActionToolbarSample.class,
                    ListWithBulkActionToolbarSample::create))
            .appendChild(
                SampleShowcase.create(
                    "List with saved filters and views",
                    "Layout: Filter controls and a view selector sit above a reusable table/list. Interaction: Users save filter/sort/column configurations, share them, and set defaults. Variants: Personal/team scopes, pinned favorites, or permission-aware views.",
                    ListWithSavedFiltersAndViewsSample.class,
                    ListWithSavedFiltersAndViewsSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Read-only registry",
                    "Layout: Search/filter toolbar and a dense data table with no mutation controls. Interaction: Users inspect, sort, export, and open a read-only detail view. Variants: Audit registry, public directory, historical snapshot, or print-oriented layout.",
                    ReadOnlyRegistrySample.class,
                    ReadOnlyRegistrySample::create))
            .appendChild(
                SampleShowcase.create(
                    "Comparison list",
                    "Layout: Results list includes selection controls and a comparison tray or compare button. Interaction: Users select a bounded number of records and compare shared fields side by side. Variants: Product comparison, policy comparison, or before/after version comparison.",
                    ComparisonListSample.class,
                    ComparisonListSample::create))
            .appendChild(
                SampleShowcase.create(
                    "List with row expansion",
                    "Layout: Compact list shows summary fields while expandable rows reveal secondary details. Interaction: Users expand one or several rows, perform row actions, and preserve expansion during sorting/filtering where possible. Variants: Nested table, inline timeline, or quick-edit expansion.",
                    ListWithRowExpansionSample.class,
                    ListWithRowExpansionSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
