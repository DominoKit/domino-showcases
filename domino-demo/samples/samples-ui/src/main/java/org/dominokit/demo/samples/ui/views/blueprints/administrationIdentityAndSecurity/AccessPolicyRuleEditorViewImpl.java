package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.AccessPolicyRuleEditorView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.AccessPolicyRuleEditorSample;

@UiView
public class AccessPolicyRuleEditorViewImpl extends SamplePageView<AccessPolicyRuleEditorView.AccessPolicyRuleEditorUiHandlers>
    implements AccessPolicyRuleEditorView {

  @Inject
  public AccessPolicyRuleEditorViewImpl() {
    super("Access policy rule editor", "Layout: Policy scope, conditions, effect, exceptions, and priority are edited in a rule-oriented form. Interaction: Users create rules, test a subject/resource combination, reorder precedence, and publish. Variants: Visual policy builder, JSON/code view, or guided form.");
    addSample("Access policy rule editor", "Layout: Policy scope, conditions, effect, exceptions, and priority are edited in a rule-oriented form. Interaction: Users create rules, test a subject/resource combination, reorder precedence, and publish. Variants: Visual policy builder, JSON/code view, or guided form.", AccessPolicyRuleEditorSample.class, AccessPolicyRuleEditorSample::create);
    initPage();
  }
}
