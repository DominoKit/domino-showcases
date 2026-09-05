package org.dominokit.demo.samples.ui.views.emphasis;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.emphasis.EmphasisView;
import org.dominokit.showcases.samples.themes.EmphasisCardsSample;
import org.dominokit.showcases.samples.themes.EmphasisComponentsSample;
import org.dominokit.showcases.samples.themes.EmphasisGroupsSample;

@UiView
public class EmphasisViewImpl extends SamplePageView<EmphasisView.EmphasisUiHandlers>
    implements EmphasisView {

  @Inject
  public EmphasisViewImpl() {
    super(
        "Emphasis modifiers",
        "Use filled, subtle, and minimal emphasis styles on individual components or groups.");
    addSample(
        "Component emphasis",
        "Apply filled, subtle, or minimal emphasis directly to supported components.",
        EmphasisComponentsSample.class,
        EmphasisComponentsSample::create);
    addSample(
        "Group emphasis",
        "Apply an emphasis modifier to a parent and let supported children inherit it.",
        EmphasisGroupsSample.class,
        EmphasisGroupsSample::create);
    addSample(
        "Card emphasis",
        "Use filled, subtle, or minimal emphasis styles with cards.",
        EmphasisCardsSample.class,
        EmphasisCardsSample::create);
    initPage();
  }
}
