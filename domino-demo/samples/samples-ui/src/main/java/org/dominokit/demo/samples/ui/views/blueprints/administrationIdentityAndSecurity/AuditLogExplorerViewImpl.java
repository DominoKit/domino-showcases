package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.AuditLogExplorerView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.AuditLogExplorerSample;

@UiView
public class AuditLogExplorerViewImpl extends SamplePageView<AuditLogExplorerView.AuditLogExplorerUiHandlers>
    implements AuditLogExplorerView {

  @Inject
  public AuditLogExplorerViewImpl() {
    super("Audit log explorer", "Layout: Filterable event table with timestamp, actor, action, target, and expandable payload/detail. Interaction: Users search by actor/action/record, inspect before-after values, and export evidence. Variants: Security log, business audit, or compliance evidence view.");
    addSample("Audit log explorer", "Layout: Filterable event table with timestamp, actor, action, target, and expandable payload/detail. Interaction: Users search by actor/action/record, inspect before-after values, and export evidence. Variants: Security log, business audit, or compliance evidence view.", AuditLogExplorerSample.class, AuditLogExplorerSample::create);
    initPage();
  }
}
