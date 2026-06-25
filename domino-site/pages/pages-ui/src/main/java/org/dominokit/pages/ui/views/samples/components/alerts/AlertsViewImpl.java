package org.dominokit.pages.ui.views.samples.components.alerts;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.alerts.BasicAlertsSample;
import org.dominokit.showcases.samples.components.alerts.ContextAlertsSample;
import org.dominokit.showcases.samples.components.alerts.DismissibleAlertsSample;
import org.dominokit.showcases.samples.components.alerts.LinksAlertsSample;

@UiView
public class AlertsViewImpl extends SampleViewImpl {
    @Inject
    public AlertsViewImpl() {
        register(DemoSample.of("alerts-basic", BasicAlertsSample.class, LazyProvider.of(BasicAlertsSample::create)));
        register(DemoSample.of("alerts-context", ContextAlertsSample.class, LazyProvider.of(ContextAlertsSample::create)));
        register(DemoSample.of("alerts-dismissible", DismissibleAlertsSample.class, LazyProvider.of(DismissibleAlertsSample::create)));
        register(DemoSample.of("alerts-links", LinksAlertsSample.class, LazyProvider.of(LinksAlertsSample::create)));
    }
}
