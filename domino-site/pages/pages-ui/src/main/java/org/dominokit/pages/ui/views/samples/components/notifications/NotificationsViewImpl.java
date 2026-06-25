package org.dominokit.pages.ui.views.samples.components.notifications;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.notifications.*;

@UiView
public class NotificationsViewImpl extends SampleViewImpl {
    @Inject
    public NotificationsViewImpl() {
        register(DemoSample.of("notifications-basic", BasicNotificationsSample.class, LazyProvider.of(BasicNotificationsSample::create)));
        register(DemoSample.of("notifications-context", ContextNotificationsSample.class, LazyProvider.of(ContextNotificationsSample::create)));
        register(DemoSample.of("notifications-colored", ColoredNotificationsSample.class, LazyProvider.of(ColoredNotificationsSample::create)));
        register(DemoSample.of("notifications-animation", NotificationsAnimationSample.class, LazyProvider.of(NotificationsAnimationSample::create)));
    }
}