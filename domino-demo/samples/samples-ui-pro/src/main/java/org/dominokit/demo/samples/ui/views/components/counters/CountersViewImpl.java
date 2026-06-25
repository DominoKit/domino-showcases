package org.dominokit.demo.samples.ui.views.components.counters;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.counters.CountersView;
        import org.dominokit.showcases.samples.components.counters.SimpleCountersSample;
import org.dominokit.showcases.samples.components.counters.AutoCountersSample;
import org.dominokit.showcases.samples.components.counters.DateCountDownSample;

        @UiView
        public class CountersViewImpl extends SamplePageView<CountersView.CountersUiHandlers>
            implements CountersView {

          @Inject
          public CountersViewImpl() {
            super("Counters", "Counters examples rendered from the shared demo-samples module.");
    addSample(SimpleCountersSample.class, SimpleCountersSample::create);
    addSample(AutoCountersSample.class, AutoCountersSample::create);
    addSample(DateCountDownSample.class, DateCountDownSample::create);
            initPage();
          }
        }
