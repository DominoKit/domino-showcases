package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.SecurityEventResponseScreenView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.SecurityEventResponseScreenSample;

@UiView
public class SecurityEventResponseScreenViewImpl extends SamplePageView<SecurityEventResponseScreenView.SecurityEventResponseScreenUiHandlers>
    implements SecurityEventResponseScreenView {

  @Inject
  public SecurityEventResponseScreenViewImpl() {
    super("Security event response screen", "Layout: Alert summary, affected identities/resources, evidence, timeline, and response actions. Interaction: Analysts acknowledge, investigate, contain, assign, and close an event. Variants: Incident response, suspicious login review, or policy violation review.");
    addSample("Security event response screen", "Layout: Alert summary, affected identities/resources, evidence, timeline, and response actions. Interaction: Analysts acknowledge, investigate, contain, assign, and close an event. Variants: Incident response, suspicious login review, or policy violation review.", SecurityEventResponseScreenSample.class, SecurityEventResponseScreenSample::create);
    initPage();
  }
}
