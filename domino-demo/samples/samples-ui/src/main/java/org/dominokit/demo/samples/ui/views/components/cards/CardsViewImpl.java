package org.dominokit.demo.samples.ui.views.components.cards;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.cards.CardsView;
        import org.dominokit.showcases.samples.components.cards.NoHeaderCardsSample;
import org.dominokit.showcases.samples.components.cards.CardsWithHeadersSample;
import org.dominokit.showcases.samples.components.cards.ColoredCardsSample;
import org.dominokit.showcases.samples.components.cards.CollapsibleCardsSample;
import org.dominokit.showcases.samples.components.cards.CardLogoSample;
import org.dominokit.showcases.samples.components.cards.CardSubHeaderSample;

        @UiView
        public class CardsViewImpl extends SamplePageView<CardsView.CardsUiHandlers>
            implements CardsView {

          @Inject
          public CardsViewImpl() {
            super("Cards", "Cards examples rendered from the shared demo-samples module.");
    addSample(NoHeaderCardsSample.class, NoHeaderCardsSample::create);
    addSample(CardsWithHeadersSample.class, CardsWithHeadersSample::create);
    addSample(ColoredCardsSample.class, ColoredCardsSample::create);
    addSample(CollapsibleCardsSample.class, CollapsibleCardsSample::create);
    addSample(CardLogoSample.class, CardLogoSample::create);
    addSample(CardSubHeaderSample.class, CardSubHeaderSample::create);
            initPage();
          }
        }
