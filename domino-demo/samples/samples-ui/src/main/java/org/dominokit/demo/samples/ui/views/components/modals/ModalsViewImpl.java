package org.dominokit.demo.samples.ui.views.components.modals;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.modals.ModalsView;
        import org.dominokit.showcases.samples.components.modals.BasicModalsSample;
import org.dominokit.showcases.samples.components.modals.SheetModalsSample;
import org.dominokit.showcases.samples.components.modals.ColoredModalsSample;
import org.dominokit.showcases.samples.components.modals.WindowModalsSample;

        @UiView
        public class ModalsViewImpl extends SamplePageView<ModalsView.ModalsUiHandlers>
            implements ModalsView {

          @Inject
          public ModalsViewImpl() {
            super("Modals", "Modals examples rendered from the shared demo-samples module.");
    addSample(BasicModalsSample.class, BasicModalsSample::create);
    addSample(SheetModalsSample.class, SheetModalsSample::create);
    addSample(ColoredModalsSample.class, ColoredModalsSample::create);
    addSample(WindowModalsSample.class, WindowModalsSample::create);
            initPage();
          }
        }
