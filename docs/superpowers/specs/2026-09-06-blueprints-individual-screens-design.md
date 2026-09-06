# Blueprint Individual Screens Design

## Goal

Make every blueprint catalog entry an independently navigable showcase screen. Each third-level menu entry must resolve to one presenter and one view that render exactly one blueprint sample.

## Routing

Each sample uses a route with the category and a stable slug:

```text
blueprints/<category-slug>/<sample-slug>
```

The route is declared on the sample presenter with `@BrixRoute`. Existing category presenters and category view implementations are removed so they cannot also match the same path prefix and reveal competing content into the shell slot.

## Presenter/view ownership

Every catalog sample receives the normal three-file showcase structure:

1. A presenter in `samples-frontend` extending `ChildPresenter<ShellPresenter, SampleView>`.
2. A view contract in `samples-frontend` extending `Viewable`.
3. A `@UiView` implementation in `samples-ui` extending `SamplePageView` and adding exactly one `SampleShowcase`.

The existing sample class in `demo-samples-ui` remains the reusable visual implementation. Shared CRUD, master-detail, fixtures, and composition helpers remain shared; presenter/view ownership is never shared across blueprint entries.

## Navigation

The `Blueprints` root and its 13 category branches remain three levels deep. Each third-level leaf navigates directly to the full sample route instead of a category route with a hash anchor. Category labels are grouping items and do not render a multi-sample page.

## Compatibility

The work follows the existing Brix/Dagger conventions, uses the existing shell content slot, and preserves the approved blueprint names, descriptions, categories, and sample implementations.
