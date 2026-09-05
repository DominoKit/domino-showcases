# Enterprise Screen Blueprints Catalog

## Purpose

This document is the initial design catalog for a future `Blueprints` showcase category. It inventories reusable screen compositions commonly found in enterprise web applications. It is documentation only: this phase does not add navigation, routes, presenters, views, or working samples.

The catalog is organized by the job a screen performs rather than by business domain. A blueprint can therefore be reused for customers, products, employees, assets, invoices, policies, projects, or any other enterprise entity.

## How to read an entry

Every blueprint describes three things:

- **Layout:** the major regions and information hierarchy.
- **Interaction:** the primary user actions and transitions.
- **Variants:** useful changes in density, data volume, editing location, permissions, or responsive behavior.

The names are intentionally composition-oriented. A later showcase sample may give a blueprint a concrete domain, but the blueprint itself remains domain-neutral.

## Catalog

### 1. Application foundations and navigation

#### 1.1 Shell with persistent navigation

**Layout:** Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region. **Interaction:** Users switch modules from the navigation while the shell preserves context, theme, and session actions. **Variants:** Fixed or overlay navigation; compact icon rail; mobile drawer.

#### 1.2 Shell with contextual secondary navigation

**Layout:** Global shell plus a page-level tab or sub-navigation bar below the primary header. **Interaction:** Users move between related views without losing the selected parent record or module. **Variants:** Horizontal tabs, vertical section navigation, or a local navigation drawer.

#### 1.3 Workspace with resizable navigation pane

**Layout:** Main content is paired with a draggable navigation or folder pane. **Interaction:** Users resize, collapse, pin, and select nodes while the content pane updates. **Variants:** File tree, project tree, saved-search tree, or queue navigation.

#### 1.4 Breadcrumb and back-stack workspace

**Layout:** A compact breadcrumb and back control sit above content, with no permanent side navigation required. **Interaction:** Users traverse nested records and return to prior contexts without rebuilding the full search state. **Variants:** Breadcrumb-only, breadcrumb plus history menu, or breadcrumb plus split view.

#### 1.5 Command palette application

**Layout:** Minimal shell with a global command/search trigger and an optional keyboard-shortcut hint. **Interaction:** Users search for pages, records, actions, or settings and execute commands without navigating menus. **Variants:** Modal palette, inline command bar, or command palette with recent actions.

#### 1.6 Multi-workspace application

**Layout:** A global workspace switcher controls the active tenant, project, environment, or business unit. **Interaction:** Users switch contexts and the shell refreshes navigation, permissions, filters, and data. **Variants:** Dropdown switcher, tabbed workspaces, or recent-workspace launcher.

#### 1.7 Split-view navigation shell

**Layout:** A list or tree remains visible beside a detail/content pane. **Interaction:** Selecting an item updates the detail pane while preserving the navigation list and its scroll position. **Variants:** Fixed split, resizable split, or mobile drill-in with back navigation.

#### 1.8 Full-screen focused task shell

**Layout:** A reduced shell hides secondary navigation and gives one task or workflow most of the viewport. **Interaction:** Users complete, pause, save, or abandon the focused task. **Variants:** Wizard shell, review shell, or distraction-free editor.

### 2. Dashboards and overview screens

#### 2.1 KPI dashboard with responsive card grid

**Layout:** Page header and global filters lead into metric cards, small charts, and supporting tables. **Interaction:** Users change the time range, drill into a metric, reorder cards, or open a detailed report. **Variants:** Fixed executive layout, user-customizable grid, or mobile stacked cards.

#### 2.2 Operational command center

**Layout:** Dense summary strip, alerts, live status panels, trend charts, and an active-work queue. **Interaction:** Users monitor changing conditions, acknowledge alerts, filter by severity, and jump to remediation screens. **Variants:** Auto-refresh, wallboard mode, or manually refreshed snapshot.

#### 2.3 Role-based home dashboard

**Layout:** Personalized welcome area followed by role-specific shortcuts, assigned work, recent records, and metrics. **Interaction:** Users resume work, customize widgets, and dismiss or pin content. **Variants:** Employee, manager, administrator, or external-partner home.

#### 2.4 Drill-down analytics dashboard

**Layout:** High-level visualization occupies the upper region with supporting breakdowns beneath it. **Interaction:** Selecting a data point applies a filter to lower-level charts or opens a filtered record list. **Variants:** Click-through, brush-and-zoom, or breadcrumb-based drill path.

#### 2.5 Portfolio overview dashboard

**Layout:** Summary metrics, portfolio health indicators, grouped cards, and a comparison table cover many projects, products, or accounts. **Interaction:** Users compare entities, filter by owner/status, and open a selected portfolio member. **Variants:** Grid, table-first, or quadrant visualization.

#### 2.6 Personal productivity dashboard

**Layout:** Today/next-up summary, tasks, calendar preview, notifications, and recently opened items. **Interaction:** Users complete, snooze, reschedule, or resume work directly from compact widgets. **Variants:** Focus mode, team mode, or calendar-first arrangement.

#### 2.7 Dashboard with saved views

**Layout:** Dashboard content is controlled by a saved-view selector beside filters and date controls. **Interaction:** Users apply, save, rename, share, or delete dashboard configurations. **Variants:** Personal-only views, team-shared views, or role-enforced defaults.

#### 2.8 Dashboard with commentary and annotations

**Layout:** Charts and metrics are paired with an activity/commentary rail. **Interaction:** Users annotate a metric, mention colleagues, resolve comments, and preserve commentary with a reporting period. **Variants:** Threaded comments, pin-to-chart annotations, or review-cycle notes.

### 3. Search, list, and CRUD screens

#### 3.1 Short-list CRUD with dialog editor

**Layout:** Page header, compact filter row, short table/list, and a primary add button; add/edit opens a modal dialog. **Interaction:** Users search, sort, add, edit, delete, and confirm changes without leaving the list. **Variants:** Confirm-before-delete, optimistic updates, or wizard dialog for complex records.

#### 3.2 Short-list CRUD with top-section editor

**Layout:** A form panel sits above a short list and is used for both add and edit. **Interaction:** Users select a row to load it into the form, save changes, clear the form, or start a new record. **Variants:** Always-visible form, collapsible form, or two-column form beside the list.

#### 3.3 Long-list CRUD with dialog editor

**Layout:** Toolbar, persistent filters, paginated or virtualized table, and modal editor for add/edit. **Interaction:** Users navigate pages, apply filters, perform row actions, and edit one record at a time in a dialog. **Variants:** Server-side search, bulk selection, or side-panel editor instead of modal.

#### 3.4 Long-list CRUD with persistent side-panel editor

**Layout:** Dense list occupies the main region while a right-side editor opens without removing the list. **Interaction:** Users select a row, edit it in context, save, and continue to another row. **Variants:** Resizable panel, read-only preview before edit, or stacked mobile drawer.

#### 3.5 Inline-editable table

**Layout:** Table rows or cells become editable in place with row-level save/cancel controls. **Interaction:** Users edit several fields quickly, validate, commit, or discard row changes. **Variants:** Single-cell editing, row editing, keyboard navigation, or draft autosave.

#### 3.6 Card-grid CRUD

**Layout:** Toolbar and filters lead into cards with summary fields, status, and action menu. **Interaction:** Users open, edit, archive, duplicate, or delete a card, with add handled by a dialog or form page. **Variants:** Kanban-like cards, image-heavy cards, or responsive grid/list toggle.

#### 3.7 Search-first record directory

**Layout:** Prominent search input with optional advanced filters; results appear only after a query or suggested search. **Interaction:** Users search by text, identifier, or facets and open a result. **Variants:** Typeahead, command-style search, or federated results across entity types.

#### 3.8 Advanced search builder

**Layout:** Search-builder panel exposes field/operator/value rows above a result table. **Interaction:** Users add conditions, group them with AND/OR, save a search, preview results, and reset criteria. **Variants:** Basic/advanced toggle, visual query builder, or natural-language search paired with filters.

#### 3.9 Faceted catalog browser

**Layout:** Facet sidebar, result count/sort toolbar, and a list or card grid. **Interaction:** Users combine facets, remove chips, sort, paginate, and open an item. **Variants:** Facets on the top for mobile, hierarchical facets, or instant result updates.

#### 3.10 List with bulk action toolbar

**Layout:** Selectable rows/cards and a toolbar that appears or changes when selection exists. **Interaction:** Users select individual/all records, apply a bulk operation, review impact, and confirm. **Variants:** Bulk edit, assign, archive, export, tag, or status transition.

#### 3.11 List with saved filters and views

**Layout:** Filter controls and a view selector sit above a reusable table/list. **Interaction:** Users save filter/sort/column configurations, share them, and set defaults. **Variants:** Personal/team scopes, pinned favorites, or permission-aware views.

#### 3.12 Read-only registry

**Layout:** Search/filter toolbar and a dense data table with no mutation controls. **Interaction:** Users inspect, sort, export, and open a read-only detail view. **Variants:** Audit registry, public directory, historical snapshot, or print-oriented layout.

#### 3.13 Comparison list

**Layout:** Results list includes selection controls and a comparison tray or compare button. **Interaction:** Users select a bounded number of records and compare shared fields side by side. **Variants:** Product comparison, policy comparison, or before/after version comparison.

#### 3.14 List with row expansion

**Layout:** Compact list shows summary fields while expandable rows reveal secondary details. **Interaction:** Users expand one or several rows, perform row actions, and preserve expansion during sorting/filtering where possible. **Variants:** Nested table, inline timeline, or quick-edit expansion.

### 4. Master-detail and record workspaces

#### 4.1 Master-detail record page

**Layout:** Summary header and tabbed sections form the detail pane, usually reached from a list. **Interaction:** Users move between related sections, edit the record, and return to the originating list. **Variants:** Full page, split view, or nested route tabs.

#### 4.2 Master-detail with persistent record list

**Layout:** Searchable list remains on the left while the selected record fills the right pane. **Interaction:** Users move through records with next/previous controls or keyboard shortcuts. **Variants:** Email-like preview, ticket queue, or asset inspection.

#### 4.3 Record overview with related entities

**Layout:** Record header is followed by summary cards and related lists for contacts, transactions, files, or activities. **Interaction:** Users navigate among related entities, add related records, and return to the parent context. **Variants:** Tabs, stacked sections, or dashboard-like summary.

#### 4.4 Record page with activity timeline

**Layout:** Primary record details occupy one region and a chronological activity stream occupies another. **Interaction:** Users post notes, filter event types, expand events, and respond to tasks. **Variants:** Right rail, bottom timeline, or full-width activity tab.

#### 4.5 Record page with side inspector

**Layout:** Main content displays the record while a narrow inspector exposes metadata, ownership, permissions, or quick actions. **Interaction:** Users pin/unpin the inspector, change metadata, and execute contextual actions. **Variants:** Collapsible inspector, overlay inspector, or mobile bottom sheet.

#### 4.6 Multi-record comparison workspace

**Layout:** Two or more records appear in aligned columns with a shared toolbar. **Interaction:** Users switch compared records, highlight differences, and copy or reconcile values. **Variants:** Two-way, three-way, or version comparison.

#### 4.7 Record split view with preview and edit modes

**Layout:** Selected record is shown in a preview state and can transition to an edit state in the same pane. **Interaction:** Users preview, edit, save, cancel, and move between records without leaving the list. **Variants:** Inline edit, side panel, or full-screen edit escalation.

#### 4.8 Hierarchical entity explorer

**Layout:** Tree or nested list shows parent-child entities beside a detail pane. **Interaction:** Users expand nodes, add children, move/reorder nodes, and inspect the selected entity. **Variants:** Organization chart, category tree, folder hierarchy, or dependency graph.

### 5. Forms, configuration, and data-entry flows

#### 5.1 Single-section entity form

**Layout:** Page title, grouped fields, validation messages, and a clear save/cancel footer. **Interaction:** Users enter values, see inline validation, save, reset, or cancel. **Variants:** Inline page, dialog, drawer, or read-only-to-edit transition.

#### 5.2 Multi-section long form

**Layout:** Form is divided into titled sections with a summary or anchored section navigation. **Interaction:** Users navigate sections, see completion/validation status, save a draft, and submit. **Variants:** Accordion sections, sticky section nav, or progressive disclosure.

#### 5.3 Two-column form with contextual help

**Layout:** Fields occupy a primary column while descriptions, examples, or help occupy a secondary column. **Interaction:** Users fill fields while consulting inline help, tooltips, or documentation links. **Variants:** Help rail, inline expandable help, or responsive stacked layout.

#### 5.4 Form with conditional fields

**Layout:** Base fields are visible and dependent sections appear based on selections. **Interaction:** Users make choices that reveal, hide, enable, or reset related fields. **Variants:** Rule-driven forms, product configuration, or eligibility forms.

#### 5.5 Stepped wizard

**Layout:** Stepper indicates progress, with one focused form section per step and a final review. **Interaction:** Users move back and forward, save progress, validate each step, and submit at the end. **Variants:** Linear required steps, optional steps, or branching steps.

#### 5.6 Wizard with review-and-confirm step

**Layout:** Data-entry steps are followed by a read-only summary with grouped changes and warnings. **Interaction:** Users jump back to correct a section, confirm, and submit the complete operation. **Variants:** Pricing preview, policy acceptance, or batch creation.

#### 5.7 Repeatable collection form

**Layout:** One parent form contains repeatable child rows/cards or nested subforms. **Interaction:** Users add, remove, reorder, and validate child entries before saving the parent. **Variants:** Line items, addresses, contacts, or rule clauses.

#### 5.8 Form with draft/autosave state

**Layout:** Standard form plus visible draft status, last-saved time, and recovery controls. **Interaction:** Users edit continuously, recover a draft, manually save, or discard it. **Variants:** Local draft, server draft, multi-user draft, or offline-capable form.

#### 5.9 Configuration screen with preview

**Layout:** Configuration controls occupy one region and a live or sample preview occupies another. **Interaction:** Users change settings, compare preview states, reset defaults, and publish/apply. **Variants:** Theme builder, notification template, report layout, or form designer.

#### 5.10 Import-backed data-entry form

**Layout:** Manual entry form is paired with upload/import controls and a preview of parsed values. **Interaction:** Users upload, map, validate, correct, and commit imported data. **Variants:** CSV, spreadsheet, pasted rows, or API payload preview.

### 6. Workflow, approvals, and task management

#### 6.1 Personal task inbox

**Layout:** Prioritized task list with status filters and a task detail pane or page. **Interaction:** Users claim, complete, delegate, snooze, or reject tasks. **Variants:** List-detail split, grouped by due date, or grouped by process.

#### 6.2 Team work queue

**Layout:** Queue table includes ownership, priority, age, SLA, and status columns. **Interaction:** Users assign, reassign, claim, bulk-update, and open work items. **Variants:** Round-robin queue, skill-based queue, or supervisor view.

#### 6.3 Approval request screen

**Layout:** Request summary, submitted values, supporting evidence, decision controls, and history. **Interaction:** Reviewers approve, reject, request changes, delegate, or add comments. **Variants:** Single approver, sequential approval chain, or parallel approvals.

#### 6.4 Approval matrix configuration

**Layout:** Rules, thresholds, roles, and escalation paths are shown in a structured editor. **Interaction:** Administrators add conditions, order approvers, test a rule, and publish changes. **Variants:** Table editor, visual rule builder, or nested policy editor.

#### 6.5 Case management workspace

**Layout:** Case header, status/priority summary, customer or subject details, activity timeline, tasks, and related records. **Interaction:** Users update status, assign owners, add notes, attach evidence, and resolve/escalate. **Variants:** Support case, compliance case, incident case, or investigation case.

#### 6.6 Kanban workflow board

**Layout:** Columns represent workflow states and cards represent work items. **Interaction:** Users drag cards between states, open details, assign owners, and filter the board. **Variants:** WIP limits, swimlanes, card grouping, or keyboard-accessible movement.

#### 6.7 Workflow timeline and milestone view

**Layout:** Process stages appear along a timeline with current state, owners, dates, and blockers. **Interaction:** Users open milestones, complete transitions, add evidence, and inspect history. **Variants:** Horizontal timeline, vertical timeline, or timeline plus task list.

#### 6.8 Exception review queue

**Layout:** Failed, suspicious, or incomplete items appear in a queue with reason and severity. **Interaction:** Users inspect evidence, correct data, retry processing, suppress, or escalate. **Variants:** Batch exception review, fraud review, or integration error queue.

#### 6.9 SLA and escalation monitor

**Layout:** Aging buckets, SLA indicators, breached items, and escalation controls summarize work health. **Interaction:** Users filter by risk, reassign work, extend deadlines with reason, and open the underlying item. **Variants:** Real-time monitor, daily management report, or team dashboard.

#### 6.10 Task detail with checklist

**Layout:** Task description and owner information are paired with a required/optional checklist and completion evidence. **Interaction:** Users check items, attach evidence, comment, and complete or return the task. **Variants:** Inspection checklist, onboarding checklist, or maintenance checklist.

### 7. Reporting, analytics, and data exploration

#### 7.1 Report viewer with parameter bar

**Layout:** Report title and parameter controls sit above a generated report surface. **Interaction:** Users set parameters, run, refresh, export, print, and save the report. **Variants:** Synchronous run, queued run, or paginated report viewer.

#### 7.2 Report builder

**Layout:** Fields, dimensions, measures, filters, and a preview table/chart occupy structured panels. **Interaction:** Users compose a report, reorder fields, preview results, save, and share it. **Variants:** Guided builder, drag-and-drop builder, or query-first builder.

#### 7.3 Ad hoc pivot analysis

**Layout:** Pivot configuration controls accompany a pivot table or chart. **Interaction:** Users drag dimensions/measures, expand groups, filter values, and export the result. **Variants:** Table-first, chart-first, or saved analysis workspace.

#### 7.4 Time-series analysis screen

**Layout:** Date controls, trend chart, comparison selector, and event markers form the page hierarchy. **Interaction:** Users zoom, compare periods, toggle series, and inspect data points. **Variants:** Single metric, multi-metric, or anomaly-focused analysis.

#### 7.5 Geographic/map analytics screen

**Layout:** Map or spatial canvas is paired with filters, legend, and a result/detail panel. **Interaction:** Users pan, zoom, select regions/markers, filter categories, and open records. **Variants:** Marker map, choropleth, route map, or map/list split.

#### 7.6 Metric definition and governance screen

**Layout:** Metric metadata, formula, owner, lineage, thresholds, and usage references are grouped into tabs or sections. **Interaction:** Users edit definitions, validate formulas, approve changes, and inspect dependencies. **Variants:** Business glossary, KPI registry, or data catalog metric page.

#### 7.7 Scheduled report management

**Layout:** Report list includes schedule, recipients, delivery status, and last-run information. **Interaction:** Users create, pause, edit, test, duplicate, and monitor scheduled deliveries. **Variants:** Email delivery, file drop, dashboard refresh, or webhook delivery.

#### 7.8 Data quality scorecard

**Layout:** Quality dimensions, scores, trend charts, failing rules, and affected records are shown together. **Interaction:** Users drill into failures, assign remediation, acknowledge exceptions, and re-run checks. **Variants:** Dataset scorecard, domain scorecard, or executive summary.

### 8. Scheduling, calendars, and resource planning

#### 8.1 Personal calendar and agenda

**Layout:** Calendar grid or agenda list with mini-calendar, filters, and event detail. **Interaction:** Users create, move, resize, edit, cancel, and respond to events. **Variants:** Day/week/month, agenda-first, or compact mobile calendar.

#### 8.2 Shared team calendar

**Layout:** Multiple calendars or resource lanes are displayed with a shared toolbar. **Interaction:** Users toggle calendars, schedule events, resolve overlaps, and inspect availability. **Variants:** Team members, rooms, equipment, or service territories.

#### 8.3 Resource scheduler

**Layout:** Resources form rows/columns while time forms the opposing axis; bookings appear as blocks. **Interaction:** Users create, move, resize, split, and cancel bookings while seeing conflicts. **Variants:** Gantt-like, timeline, calendar grid, or list-plus-calendar.

#### 8.4 Appointment booking flow

**Layout:** Service/resource selection, availability picker, customer details, and confirmation summary form a guided flow. **Interaction:** Users choose a slot, enter details, confirm, reschedule, or cancel. **Variants:** Public booking, staff booking, or assisted booking.

#### 8.5 Shift planning board

**Layout:** Staff rows and time periods contain shift blocks, coverage indicators, and unfilled slots. **Interaction:** Planners assign, drag, swap, copy, publish, and resolve coverage warnings. **Variants:** Weekly roster, monthly roster, or location-based roster.

#### 8.6 Capacity planning screen

**Layout:** Demand, available capacity, allocation, and forecast are shown in aligned charts or tables. **Interaction:** Users change assumptions, allocate capacity, compare scenarios, and publish a plan. **Variants:** People, machines, budget, or support capacity.

#### 8.7 Recurring schedule editor

**Layout:** Schedule details are paired with recurrence rules, exceptions, preview dates, and timezone controls. **Interaction:** Users define recurrence, add exceptions, preview occurrences, and save the schedule. **Variants:** Calendar recurrence, batch job schedule, or notification schedule.

#### 8.8 Timeline planner with dependencies

**Layout:** Work items are represented on a time axis with dependency connectors and milestone markers. **Interaction:** Users adjust dates, create dependencies, assign owners, and identify critical-path changes. **Variants:** Project plan, release plan, or implementation plan.

### 9. Administration, identity, and security

#### 9.1 User directory and profile administration

**Layout:** Searchable user list with status, role, organization, and a profile editor/detail pane. **Interaction:** Administrators invite, edit, disable, reset, impersonate where permitted, and inspect activity. **Variants:** Employee directory, customer users, or service accounts.

#### 9.2 Role and permission matrix

**Layout:** Roles form one axis and permissions/resources form another, often with grouped rows and inheritance indicators. **Interaction:** Administrators grant, revoke, compare, search, and publish permission changes. **Variants:** Matrix table, role detail tabs, or resource-first hierarchy.

#### 9.3 Access policy rule editor

**Layout:** Policy scope, conditions, effect, exceptions, and priority are edited in a rule-oriented form. **Interaction:** Users create rules, test a subject/resource combination, reorder precedence, and publish. **Variants:** Visual policy builder, JSON/code view, or guided form.

#### 9.4 Organization and tenant administration

**Layout:** Organization tree, tenant metadata, membership summary, and configuration tabs form the workspace. **Interaction:** Administrators add units, move members, configure defaults, and switch scope. **Variants:** Company hierarchy, multi-tenant console, or franchise hierarchy.

#### 9.5 Audit log explorer

**Layout:** Filterable event table with timestamp, actor, action, target, and expandable payload/detail. **Interaction:** Users search by actor/action/record, inspect before-after values, and export evidence. **Variants:** Security log, business audit, or compliance evidence view.

#### 9.6 API key and integration management

**Layout:** Credential/integration list with status, scopes, last-used information, and detail editor. **Interaction:** Users create, rotate, revoke, test, and restrict credentials. **Variants:** API keys, OAuth clients, webhooks, or service connections.

#### 9.7 Feature flag management

**Layout:** Flag list includes status, environment, targeting, owner, and rollout percentage. **Interaction:** Users enable, disable, target audiences, schedule changes, and inspect evaluation history. **Variants:** Environment matrix, gradual rollout, or experiment assignment.

#### 9.8 System settings hub

**Layout:** Settings navigation groups configuration pages with search and a save/apply area. **Interaction:** Users find settings, edit values, restore defaults, preview impact, and publish. **Variants:** Section tabs, category cards, or searchable settings registry.

#### 9.9 Security event response screen

**Layout:** Alert summary, affected identities/resources, evidence, timeline, and response actions. **Interaction:** Analysts acknowledge, investigate, contain, assign, and close an event. **Variants:** Incident response, suspicious login review, or policy violation review.

#### 9.10 Environment/configuration comparison

**Layout:** Two environments or configuration versions are shown in aligned sections with differences highlighted. **Interaction:** Users compare, select changes, promote, rollback, or export a diff. **Variants:** Dev/test/prod, tenant-to-tenant, or version-to-version comparison.

### 10. Content, files, communication, and collaboration

#### 10.1 Document library

**Layout:** Folder/tree navigation, file list or cards, search/filter toolbar, and preview/detail panel. **Interaction:** Users upload, move, rename, download, share, archive, and preview files. **Variants:** Grid/list toggle, versioned documents, or permissions-aware library.

#### 10.2 File upload and processing workspace

**Layout:** Drop zone, upload queue, validation results, and completed-file list. **Interaction:** Users add files, monitor progress, retry failures, remove items, and continue processing. **Variants:** Single upload, multi-file batch, or resumable upload.

#### 10.3 Rich content editor

**Layout:** Editor canvas with formatting toolbar, metadata panel, preview, and publish controls. **Interaction:** Users draft, format, insert media, preview, autosave, and publish or schedule content. **Variants:** Knowledge article, email template, announcement, or policy document.

#### 10.4 Versioned document editor

**Layout:** Editor is paired with version history, status, reviewers, and change metadata. **Interaction:** Users save versions, compare revisions, restore, submit for review, and publish. **Variants:** Side-by-side diff, inline diff, or review comments.

#### 10.5 Message center

**Layout:** Conversation or notification list beside a message/detail pane and composer. **Interaction:** Users read, reply, forward, archive, search, and mark messages. **Variants:** Internal inbox, customer messages, or system notifications.

#### 10.6 Announcement and broadcast composer

**Layout:** Audience selector, message editor, scheduling controls, preview, and delivery summary. **Interaction:** Users target audiences, preview channels, schedule, send, cancel, and inspect delivery. **Variants:** In-app, email, SMS, or multi-channel broadcast.

#### 10.7 Comments and collaboration panel

**Layout:** Primary record/content is accompanied by threaded comments and mentions. **Interaction:** Users comment, mention, react, resolve, reopen, and filter threads. **Variants:** Right rail, inline anchored comments, or activity tab.

#### 10.8 Knowledge base browser

**Layout:** Category navigation, search, article list, and reading pane. **Interaction:** Users search, browse categories, bookmark, rate, report outdated content, and follow related articles. **Variants:** Public help center, internal knowledge base, or contextual help drawer.

### 11. Operations, monitoring, and exception handling

#### 11.1 Service health dashboard

**Layout:** Service status cards, dependency map, incidents, latency/error charts, and recent deploys. **Interaction:** Operators filter services, inspect incidents, acknowledge alerts, and open runbooks. **Variants:** Executive health, engineering operations, or tenant-specific health.

#### 11.2 Incident management workspace

**Layout:** Incident header, severity/status, timeline, responders, communication log, and action checklist. **Interaction:** Responders assign roles, update status, add events, publish updates, and resolve/postmortem. **Variants:** War-room view, incident detail, or command-center split view.

#### 11.3 Job and batch monitor

**Layout:** Job list with status, schedule, duration, logs, retries, and run detail. **Interaction:** Users start, pause, retry, cancel, inspect logs, and compare runs. **Variants:** ETL jobs, scheduled reports, or background processing.

#### 11.4 Integration monitor

**Layout:** Integration endpoints, message counts, latency, failures, and recent payloads appear in a monitoring workspace. **Interaction:** Users inspect failures, replay messages, pause/resume endpoints, and test connections. **Variants:** API integration, event stream, or file exchange.

#### 11.5 Alert triage screen

**Layout:** Alert queue with severity, source, age, owner, and a detail/evidence panel. **Interaction:** Users acknowledge, suppress, group, assign, escalate, and resolve alerts. **Variants:** Security, infrastructure, business-rule, or data-quality alerts.

#### 11.6 Log explorer

**Layout:** Query/filter bar, time-series summary, log stream, and selected-entry detail. **Interaction:** Users search, refine queries, expand context, bookmark queries, and export results. **Variants:** Structured logs, application logs, or audit events.

#### 11.7 Transaction reconciliation screen

**Layout:** Matched, unmatched, and exception records are grouped with amount/date/reference summaries. **Interaction:** Users match records, split/merge candidates, accept differences, and post adjustments. **Variants:** Bank reconciliation, inventory reconciliation, or integration reconciliation.

#### 11.8 Operational checklist and inspection

**Layout:** Asset/location summary, checklist sections, measurements, evidence, and sign-off area. **Interaction:** Users complete checks, record exceptions, attach photos/files, and sign or escalate. **Variants:** Field inspection, safety inspection, or opening/closing checklist.

### 12. Import, export, migration, and bulk operations

#### 12.1 Import wizard with mapping

**Layout:** Upload step, column-mapping step, validation preview, and commit summary. **Interaction:** Users upload data, map source fields, resolve invalid rows, and start the import. **Variants:** CSV, spreadsheet, JSON, or copied tabular data.

#### 12.2 Import validation and correction queue

**Layout:** Valid rows and invalid rows are summarized with an error table and correction editor. **Interaction:** Users fix values inline, download errors, revalidate, and continue or cancel. **Variants:** Row-level correction, cell-level correction, or rules-assisted correction.

#### 12.3 Export builder

**Layout:** Dataset selection, columns, filters, format, and delivery options are arranged as a short flow or form. **Interaction:** Users configure, preview, generate, download, or schedule an export. **Variants:** Immediate download, queued export, or recurring export.

#### 12.4 Bulk edit review screen

**Layout:** Selected records, proposed field changes, validation warnings, and impact summary appear before commit. **Interaction:** Users edit a shared value, review per-record exceptions, confirm, and monitor completion. **Variants:** Synchronous update, background job, or approval-required bulk change.

#### 12.5 Migration project dashboard

**Layout:** Migration phases, source/target summaries, validation counts, blockers, and run history. **Interaction:** Users configure mappings, run dry-runs, resolve issues, execute phases, and rollback where supported. **Variants:** Tenant migration, system migration, or data-version migration.

#### 12.6 Data cleanup workspace

**Layout:** Duplicate/invalid candidates, matching rules, previewed merges, and action history are presented together. **Interaction:** Users review candidates, merge/suppress, apply rules, and undo where possible. **Variants:** Duplicate contacts, catalog cleanup, or master-data cleanup.

#### 12.7 Batch operation monitor

**Layout:** A submitted bulk operation has progress, counts, failures, logs, and cancellation controls. **Interaction:** Users monitor, pause/cancel, retry failures, download results, and open affected records. **Variants:** Bulk email, recalculation, reindexing, or mass status update.

#### 12.8 Data exchange status center

**Layout:** Inbound/outbound exchanges are listed with direction, schedule, status, volume, and last successful run. **Interaction:** Users inspect an exchange, retry, download artifacts, and configure notifications. **Variants:** Partner exchange, regulatory submission, or scheduled feed.

### 13. Special states and constrained compositions

#### 13.1 Empty-state-first screen

**Layout:** The normal page shell is present but the primary content area explains the absence of records and offers a clear next action. **Interaction:** Users create the first record, import data, adjust filters, or learn more. **Variants:** First-use empty state, filtered-empty state, or permission-empty state.

#### 13.2 Loading and progressive-content screen

**Layout:** Stable page structure appears immediately while cards, rows, and detail sections load progressively. **Interaction:** Users can use ready regions while slower regions resolve or retry. **Variants:** Skeleton loading, staged panels, or table placeholder rows.

#### 13.3 Error recovery screen

**Layout:** Failed content is localized with a clear explanation, affected region, retry action, and optional diagnostic detail. **Interaction:** Users retry, change filters, report the issue, or continue with unaffected content. **Variants:** Full-page failure, partial panel failure, or failed mutation recovery.

#### 13.4 Read-only permission variant

**Layout:** Editing controls are removed or replaced with explanatory permission messaging while the information hierarchy remains intact. **Interaction:** Users inspect, copy, export where allowed, or request access. **Variants:** Field-level masking, section-level read-only, or complete read-only page.

#### 13.5 Unsaved-changes protection

**Layout:** Editable screen includes dirty-state indicators and an explicit save/cancel footer or toolbar. **Interaction:** Users save, discard, continue editing, or resolve navigation/unload warnings. **Variants:** Single form, multi-tab form, or multi-record editing.

#### 13.6 Conflict-resolution screen

**Layout:** Local changes and current server values are shown side by side or in a field-level conflict list. **Interaction:** Users keep local, accept remote, merge fields, and retry the save. **Variants:** Record conflict, document conflict, or concurrent bulk-change conflict.

#### 13.7 Responsive density transformation

**Layout:** Desktop table/panel composition transforms into cards, drawers, stacked sections, or prioritized fields on narrow screens. **Interaction:** Users retain the same task flow through mobile-friendly navigation and action placement. **Variants:** Table-to-card, split-to-drill-in, or toolbar-to-bottom-action-bar.

#### 13.8 Print/export-oriented screen

**Layout:** Screen prioritizes a stable document-like hierarchy, print controls, and export metadata over interactive chrome. **Interaction:** Users preview, print, download, or select output options. **Variants:** Invoice, report, certificate, or audit evidence.

#### 13.9 Offline or reconnecting workspace

**Layout:** Main content remains usable with visible connection state, queued changes, and synchronization status. **Interaction:** Users continue work, retry synchronization, inspect conflicts, and recover failed operations. **Variants:** Field app, intermittent network, or browser-local draft.

#### 13.10 Guided first-run experience

**Layout:** Empty or lightly populated workspace is paired with onboarding steps, contextual tips, and sample actions. **Interaction:** Users complete setup, skip or resume guidance, and reach the first meaningful result. **Variants:** Product onboarding, tenant setup, or feature-specific tour.

## Cross-cutting composition dimensions

These dimensions should be used to describe and compare future blueprint samples. They are orthogonal to the catalog sections; a single blueprint can have one value from several dimensions.

### Data volume

- Short list: a small set of visible records with little or no pagination.
- Medium list: paginated records with ordinary filtering and sorting.
- Long list: server-side search, pagination, virtualization, or queued operations.
- Hierarchical data: tree, nested rows, parent-child navigation, or dependency graph.
- High-frequency data: live updates, auto-refresh, streaming, or operational monitoring.

### Editing location

- Inline cell or row editing.
- Top-section or bottom-section form.
- Modal dialog.
- Side drawer or persistent inspector.
- Full-page editor.
- Focused wizard or task shell.

### Navigation model

- Single-page form.
- Tabs within one record.
- List-detail split view.
- Breadcrumb/drill-down navigation.
- Tree plus detail pane.
- Board, calendar, timeline, or map canvas.

### Interaction intensity

- Browse and inspect.
- Search and filter.
- Single-record create/edit.
- Multi-record bulk operation.
- Long-running/background operation.
- Collaborative/review interaction.
- Workflow transition or approval.

### Density

- Spacious, guided, and form-oriented.
- Balanced dashboard or detail layout.
- Dense table or queue.
- High-density operational console.

### State model

- Draft, submitted, pending review, approved, rejected, archived, or deleted.
- Loading, empty, partial failure, full failure, or reconnecting.
- Read-only, field-masked, permission-denied, or approval-locked.
- Dirty, conflicted, queued, processing, completed, or failed.

### Responsive transformation

- Preserve the desktop grid and allow horizontal scroll.
- Convert table rows to cards.
- Convert split view to drill-in navigation.
- Convert side panel to drawer or bottom sheet.
- Move filters into a modal or expandable panel.
- Move primary actions into a sticky bottom action bar.

## State and permission checklist for future samples

Each future implementation should explicitly decide which of these states it demonstrates:

- Initial loading and delayed loading.
- First-use empty state and filtered-empty state.
- Validation errors and server-side mutation errors.
- Read-only and restricted actions.
- Unsaved changes and navigation protection.
- Long-running operation with progress.
- Conflict or stale-record handling.
- Archived/inactive records.
- Mobile or narrow-width behavior.
- Keyboard/focus behavior for the primary task.

## Suggested future sampling roadmap

When implementation begins, the first wave should maximize pattern coverage rather than domain count:

1. Short-list CRUD with dialog editor.
2. Short-list CRUD with top-section editor.
3. Long-list CRUD with side-panel editor.
4. Search-first directory with advanced filters.
5. Master-detail record workspace with activity timeline.
6. Multi-section form with draft/autosave.
7. Approval request with history and decision panel.
8. Team work queue with bulk actions.
9. KPI dashboard with drill-down.
10. Resource scheduler with conflict handling.
11. Document library with preview and upload.
12. Import wizard with mapping and validation.
13. Audit log explorer.
14. Incident management workspace.
15. Empty/loading/error/read-only state showcase.

This roadmap is intentionally separate from the catalog. It identifies representative compositions for future implementation without limiting the eventual breadth of the `Blueprints` category.
