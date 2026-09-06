package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

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
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DashboardsAndOverviewScreensView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.KpiDashboardWithResponsiveCardGridSample;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.OperationalCommandCenterSample;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.RoleBasedHomeDashboardSample;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.DrillDownAnalyticsDashboardSample;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.PortfolioOverviewDashboardSample;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.PersonalProductivityDashboardSample;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.DashboardWithSavedViewsSample;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.DashboardWithCommentaryAndAnnotationsSample;

@UiView
public class DashboardsAndOverviewScreensViewImpl extends BrixView<HTMLDivElement, DashboardsAndOverviewScreensView.DashboardsAndOverviewScreensUiHandlers>
    implements DashboardsAndOverviewScreensView {

  private final DivElement root;

  @Inject
  public DashboardsAndOverviewScreensViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Dashboards and overview screens",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "KPI dashboard with responsive card grid",
                    "Layout: Page header and global filters lead into metric cards, small charts, and supporting tables. Interaction: Users change the time range, drill into a metric, reorder cards, or open a detailed report. Variants: Fixed executive layout, user-customizable grid, or mobile stacked cards.",
                    KpiDashboardWithResponsiveCardGridSample.class,
                    KpiDashboardWithResponsiveCardGridSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Operational command center",
                    "Layout: Dense summary strip, alerts, live status panels, trend charts, and an active-work queue. Interaction: Users monitor changing conditions, acknowledge alerts, filter by severity, and jump to remediation screens. Variants: Auto-refresh, wallboard mode, or manually refreshed snapshot.",
                    OperationalCommandCenterSample.class,
                    OperationalCommandCenterSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Role-based home dashboard",
                    "Layout: Personalized welcome area followed by role-specific shortcuts, assigned work, recent records, and metrics. Interaction: Users resume work, customize widgets, and dismiss or pin content. Variants: Employee, manager, administrator, or external-partner home.",
                    RoleBasedHomeDashboardSample.class,
                    RoleBasedHomeDashboardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Drill-down analytics dashboard",
                    "Layout: High-level visualization occupies the upper region with supporting breakdowns beneath it. Interaction: Selecting a data point applies a filter to lower-level charts or opens a filtered record list. Variants: Click-through, brush-and-zoom, or breadcrumb-based drill path.",
                    DrillDownAnalyticsDashboardSample.class,
                    DrillDownAnalyticsDashboardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Portfolio overview dashboard",
                    "Layout: Summary metrics, portfolio health indicators, grouped cards, and a comparison table cover many projects, products, or accounts. Interaction: Users compare entities, filter by owner/status, and open a selected portfolio member. Variants: Grid, table-first, or quadrant visualization.",
                    PortfolioOverviewDashboardSample.class,
                    PortfolioOverviewDashboardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Personal productivity dashboard",
                    "Layout: Today/next-up summary, tasks, calendar preview, notifications, and recently opened items. Interaction: Users complete, snooze, reschedule, or resume work directly from compact widgets. Variants: Focus mode, team mode, or calendar-first arrangement.",
                    PersonalProductivityDashboardSample.class,
                    PersonalProductivityDashboardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Dashboard with saved views",
                    "Layout: Dashboard content is controlled by a saved-view selector beside filters and date controls. Interaction: Users apply, save, rename, share, or delete dashboard configurations. Variants: Personal-only views, team-shared views, or role-enforced defaults.",
                    DashboardWithSavedViewsSample.class,
                    DashboardWithSavedViewsSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Dashboard with commentary and annotations",
                    "Layout: Charts and metrics are paired with an activity/commentary rail. Interaction: Users annotate a metric, mention colleagues, resolve comments, and preserve commentary with a reporting period. Variants: Threaded comments, pin-to-chart annotations, or review-cycle notes.",
                    DashboardWithCommentaryAndAnnotationsSample.class,
                    DashboardWithCommentaryAndAnnotationsSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
