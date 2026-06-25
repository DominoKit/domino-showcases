package org.dominokit.pages.ui.views.samples.components.cards;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.cards.*;

@UiView
public class CardsViewImpl extends SampleViewImpl {
    @Inject
    public CardsViewImpl() {
        register(DemoSample.of("cards-no-header", NoHeaderCardsSample.class, LazyProvider.of(NoHeaderCardsSample::create)));
        register(DemoSample.of("cards-headers", CardsWithHeadersSample.class, LazyProvider.of(CardsWithHeadersSample::create)));
        register(DemoSample.of("cards-colored", ColoredCardsSample.class, LazyProvider.of(ColoredCardsSample::create)));
        register(DemoSample.of("cards-collapsible", CollapsibleCardsSample.class, LazyProvider.of(CollapsibleCardsSample::create)));
        register(DemoSample.of("cards-logo", CardLogoSample.class, LazyProvider.of(CardLogoSample::create)));
        register(DemoSample.of("cards-subheader", CardSubHeaderSample.class, LazyProvider.of(CardSubHeaderSample::create)));
    }
}