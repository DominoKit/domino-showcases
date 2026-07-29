# Markdown Showcases Design

## Goal
Add a new markdown documentation area under `resources` and a markdown sample page in both the site and demo apps, using the same visual style and routing conventions as the existing showcase content.

## Scope
- The `resources` docs section will gain a new `Markdown` branch with a nested menu and multiple pages.
- The markdown component sample area will be added to the Domino UI solution docs and the demo sample browser.
- Shared sample implementations will live in `demo-samples/demo-samples-ui-pro` so the site and demo wrappers render the same scenarios.
- The sample content is based on the current `domino-md`, `domino-ui-pro`, and temp sample app references, but rewritten to match this repository's style.

## Information Architecture

### Resources Docs
The `resources` docs area remains the main entry point for library/tooling documentation. The new markdown section will be a nested branch in the existing left menu with these pages:

- `resources/markdown`
- `resources/markdown/getting-started`
- `resources/markdown/parsing-and-asts`
- `resources/markdown/rendering`
- `resources/markdown/extensions`
- `resources/markdown/configuration`
- `resources/markdown/examples`
- `resources/markdown/api-reference`
- `resources/markdown/cookbook`

The pages will mirror the logical grouping in `domino-md/docs`, but each page will use the website's normal prose, headings, code blocks, and navigation layout.

### Markdown Samples
The markdown component samples will be exposed as a single markdown showcase page in each app, with multiple sections for the core scenarios:

- standalone editor
- standalone preview
- split editor
- custom binding
- playground
- class styling

The page content will be built from shared sample classes in `demo-samples/demo-samples-ui-pro`. The site and demo apps will each wrap those shared classes in their own presenter/view plumbing.

## Routing And Navigation
- The `resources` markdown pages will be served through the existing `LoadContentResource` path/page resolver.
- The solution docs page for markdown will live under `solutions/domino-ui/v2/docs/components/markdown`.
- The demo sample browser will expose the markdown page under its `components/markdown` route.
- The existing menu enhancers and route loaders should keep working without a new routing subsystem.

## Content Strategy
- Use the `domino-md` docs as the source of truth for technical coverage.
- Rewrite the material into the showcase site tone and formatting instead of copying raw repo docs.
- Include advanced user material on the website through `api-reference` and `cookbook` pages.
- Keep examples concise and focused on showing library usage in context.

## Risks
- The markdown component docs fragments are not yet vendored into the showcase site backend resources, so the solution docs page will need the generated HTML docs resources added alongside the new templates.
- The sample browser and site docs rely on different presenter/view wrapper conventions, so route names and sample IDs must stay consistent across both apps.
- Existing unrelated work is already present in the tree; changes must avoid touching those files unless required.
