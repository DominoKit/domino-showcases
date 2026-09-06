package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.OperationalChecklistAndInspectionView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.OperationalChecklistAndInspectionSample;

@UiView
public class OperationalChecklistAndInspectionViewImpl extends SamplePageView<OperationalChecklistAndInspectionView.OperationalChecklistAndInspectionUiHandlers>
    implements OperationalChecklistAndInspectionView {

  @Inject
  public OperationalChecklistAndInspectionViewImpl() {
    super("Operational checklist and inspection", "Layout: Asset/location summary, checklist sections, measurements, evidence, and sign-off area. Interaction: Users complete checks, record exceptions, attach photos/files, and sign or escalate. Variants: Field inspection, safety inspection, or opening/closing checklist.");
    addSample("Operational checklist and inspection", "Layout: Asset/location summary, checklist sections, measurements, evidence, and sign-off area. Interaction: Users complete checks, record exceptions, attach photos/files, and sign or escalate. Variants: Field inspection, safety inspection, or opening/closing checklist.", OperationalChecklistAndInspectionSample.class, OperationalChecklistAndInspectionSample::create);
    initPage();
  }
}
