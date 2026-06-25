package org.dominokit.demo.samples.ui.components;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_p_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.demo.samples.shared.service.LoadSourceServiceFactory;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoNavigator;
import org.dominokit.domino.ui.utils.PostfixAddOn;

public class SampleCodeCard
    extends BaseDominoElement<HTMLDivElement, SampleCodeCard> {

  private final Card card;
  private final DivElement codeContainer;

  private String sourceCode;
  private boolean sourceLoaded;
  private boolean sourceFailed;

  public static SampleCodeCard create(Class<?> sampleClass) {
    return new SampleCodeCard(sampleClass);
  }

  public SampleCodeCard(Class<?> sampleClass) {
    this.codeContainer = div().addCss(dui_p_4).textContent("Loading source code...");
    this.card =
        Card.create("Source code", "Loaded from the sample implementation class.PPP")
            .setCollapsible(true)
            .withBody((self, body) -> body.addCss(dui_p_0))
            .withHeader(
                (self, header) ->
                    header.appendChild(
                        PostfixAddOn.of(
                            Icons.content_copy()
                                .clickable()
                                .setTooltip("Copy code")
                                .addClickListener(evt -> copySourceCode()))))
            .appendChild(codeContainer);

    this.card.collapse();

    LoadSourceServiceFactory.INSTANCE
        .getSourceCode(sampleClass.getCanonicalName())
        .onSuccess(this::onSourceLoaded)
        .onFailed(
            failedResponse -> {
              sourceFailed = true;
              codeContainer
                  .clearElement()
                  .appendChild(div().addCss(dui_p_4).textContent("Failed to load code."));
            })
        .send();

    init(this);
  }

  private void onSourceLoaded(String code) {
    sourceCode = code;
    sourceLoaded = true;
    sourceFailed = false;
    codeContainer.clearElement().appendChild(DemoCode.create(code));
  }

  private void copySourceCode() {
    if (!sourceLoaded) {
      Notification.create(sourceFailed ? "Source code is not available." : "Code is still loading.")
          .addCss(dui_info)
          .show();
      return;
    }

    Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator).clipboard.writeText(sourceCode);
    Notification.create("Code copied to clipboard").addCss(dui_info).show();
  }

  @Override
  public HTMLDivElement element() {
    return card.element();
  }
}
