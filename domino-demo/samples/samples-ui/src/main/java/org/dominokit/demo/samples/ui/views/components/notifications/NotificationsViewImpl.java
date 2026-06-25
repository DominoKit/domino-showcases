package org.dominokit.demo.samples.ui.views.components.notifications;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.notifications.NotificationsView;
        import org.dominokit.showcases.samples.components.notifications.BasicNotificationsSample;
import org.dominokit.showcases.samples.components.notifications.ContextNotificationsSample;
import org.dominokit.showcases.samples.components.notifications.ColoredNotificationsSample;
import org.dominokit.showcases.samples.components.notifications.NotificationsAnimationSample;

        @UiView
        public class NotificationsViewImpl extends SamplePageView<NotificationsView.NotificationsUiHandlers>
            implements NotificationsView {

          @Inject
          public NotificationsViewImpl() {
            super("Notifications", "Notifications examples rendered from the shared demo-samples module.");
    addSample(BasicNotificationsSample.class, BasicNotificationsSample::create);
    addSample(ContextNotificationsSample.class, ContextNotificationsSample::create);
    addSample(ColoredNotificationsSample.class, ColoredNotificationsSample::create);
    addSample(NotificationsAnimationSample.class, NotificationsAnimationSample::create);
            initPage();
          }
        }
