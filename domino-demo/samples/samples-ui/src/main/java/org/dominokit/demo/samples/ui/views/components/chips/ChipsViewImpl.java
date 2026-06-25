package org.dominokit.demo.samples.ui.views.components.chips;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.chips.ChipsView;
        import org.dominokit.showcases.samples.components.chips.BasicChipsSample;
import org.dominokit.showcases.samples.components.chips.RemovableChipsSample;
import org.dominokit.showcases.samples.components.chips.ChipsWithIconsAndImagesSample;
import org.dominokit.showcases.samples.components.chips.ChipsWithLettersSample;
import org.dominokit.showcases.samples.components.chips.SelectableChipsSample;

        @UiView
        public class ChipsViewImpl extends SamplePageView<ChipsView.ChipsUiHandlers>
            implements ChipsView {

          @Inject
          public ChipsViewImpl() {
            super("Chips", "Chips examples rendered from the shared demo-samples module.");
    addSample(BasicChipsSample.class, BasicChipsSample::create);
    addSample(RemovableChipsSample.class, RemovableChipsSample::create);
    addSample(ChipsWithIconsAndImagesSample.class, ChipsWithIconsAndImagesSample::create);
    addSample(ChipsWithLettersSample.class, ChipsWithLettersSample::create);
    addSample(SelectableChipsSample.class, SelectableChipsSample::create);
            initPage();
          }
        }
