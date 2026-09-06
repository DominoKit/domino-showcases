package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

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
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.AdministrationIdentityAndSecurityView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.UserDirectoryAndProfileAdministrationSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.RoleAndPermissionMatrixSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.AccessPolicyRuleEditorSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.OrganizationAndTenantAdministrationSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.AuditLogExplorerSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.ApiKeyAndIntegrationManagementSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.FeatureFlagManagementSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.SystemSettingsHubSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.SecurityEventResponseScreenSample;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.EnvironmentConfigurationComparisonSample;

@UiView
public class AdministrationIdentityAndSecurityViewImpl extends BrixView<HTMLDivElement, AdministrationIdentityAndSecurityView.AdministrationIdentityAndSecurityUiHandlers>
    implements AdministrationIdentityAndSecurityView {

  private final DivElement root;

  @Inject
  public AdministrationIdentityAndSecurityViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Administration, identity, and security",
            "Catalog category with 10 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "User directory and profile administration",
                    "Layout: Searchable user list with status, role, organization, and a profile editor/detail pane. Interaction: Administrators invite, edit, disable, reset, impersonate where permitted, and inspect activity. Variants: Employee directory, customer users, or service accounts.",
                    UserDirectoryAndProfileAdministrationSample.class,
                    UserDirectoryAndProfileAdministrationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Role and permission matrix",
                    "Layout: Roles form one axis and permissions/resources form another, often with grouped rows and inheritance indicators. Interaction: Administrators grant, revoke, compare, search, and publish permission changes. Variants: Matrix table, role detail tabs, or resource-first hierarchy.",
                    RoleAndPermissionMatrixSample.class,
                    RoleAndPermissionMatrixSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Access policy rule editor",
                    "Layout: Policy scope, conditions, effect, exceptions, and priority are edited in a rule-oriented form. Interaction: Users create rules, test a subject/resource combination, reorder precedence, and publish. Variants: Visual policy builder, JSON/code view, or guided form.",
                    AccessPolicyRuleEditorSample.class,
                    AccessPolicyRuleEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Organization and tenant administration",
                    "Layout: Organization tree, tenant metadata, membership summary, and configuration tabs form the workspace. Interaction: Administrators add units, move members, configure defaults, and switch scope. Variants: Company hierarchy, multi-tenant console, or franchise hierarchy.",
                    OrganizationAndTenantAdministrationSample.class,
                    OrganizationAndTenantAdministrationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Audit log explorer",
                    "Layout: Filterable event table with timestamp, actor, action, target, and expandable payload/detail. Interaction: Users search by actor/action/record, inspect before-after values, and export evidence. Variants: Security log, business audit, or compliance evidence view.",
                    AuditLogExplorerSample.class,
                    AuditLogExplorerSample::create))
            .appendChild(
                SampleShowcase.create(
                    "API key and integration management",
                    "Layout: Credential/integration list with status, scopes, last-used information, and detail editor. Interaction: Users create, rotate, revoke, test, and restrict credentials. Variants: API keys, OAuth clients, webhooks, or service connections.",
                    ApiKeyAndIntegrationManagementSample.class,
                    ApiKeyAndIntegrationManagementSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Feature flag management",
                    "Layout: Flag list includes status, environment, targeting, owner, and rollout percentage. Interaction: Users enable, disable, target audiences, schedule changes, and inspect evaluation history. Variants: Environment matrix, gradual rollout, or experiment assignment.",
                    FeatureFlagManagementSample.class,
                    FeatureFlagManagementSample::create))
            .appendChild(
                SampleShowcase.create(
                    "System settings hub",
                    "Layout: Settings navigation groups configuration pages with search and a save/apply area. Interaction: Users find settings, edit values, restore defaults, preview impact, and publish. Variants: Section tabs, category cards, or searchable settings registry.",
                    SystemSettingsHubSample.class,
                    SystemSettingsHubSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Security event response screen",
                    "Layout: Alert summary, affected identities/resources, evidence, timeline, and response actions. Interaction: Analysts acknowledge, investigate, contain, assign, and close an event. Variants: Incident response, suspicious login review, or policy violation review.",
                    SecurityEventResponseScreenSample.class,
                    SecurityEventResponseScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Environment/configuration comparison",
                    "Layout: Two environments or configuration versions are shown in aligned sections with differences highlighted. Interaction: Users compare, select changes, promote, rollback, or export a diff. Variants: Dev/test/prod, tenant-to-tenant, or version-to-version comparison.",
                    EnvironmentConfigurationComparisonSample.class,
                    EnvironmentConfigurationComparisonSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
