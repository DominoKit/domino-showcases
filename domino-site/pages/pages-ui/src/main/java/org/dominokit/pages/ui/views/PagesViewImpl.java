package org.dominokit.pages.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import org.dominokit.brix.Brix;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.ElementIdSlot;
import org.dominokit.brix.impl.NoContentView;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.Domino;
import org.dominokit.pages.views.PagesView;

import javax.inject.Inject;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.elementOf;

@UiView
public class PagesViewImpl extends NoContentView<PagesView.PagesUiHandlers> implements PagesView, DominoCss {

    @Inject
    public PagesViewImpl() {
    }

    @Override
    public void enhance(Consumer<Void> handler) {
        DomGlobal.setTimeout(p0 -> {
            NavigationEnhancer.enhance();
            NavigationEnhancer.enhanceContent();
            NavigationEnhancer.enhancePadding();
            registerSlots();
            handler.accept(null);
            Brix.get().router().fireState(StateToken.of(Brix.get().router().currentToken()));
        }, 0);

    }

    @Override
    public void enhanceContent() {
        DomGlobal.setTimeout(p0 -> {
            NavigationEnhancer.enhanceContent();
        });
    }

    @Override
    public void updateContent(String content) {

    }

    @Override
    public void replaceContent(String content, String targetElementId) {
        Element mainBody = DomGlobal.document.getElementById(targetElementId);
        elementOf(mainBody).setInnerHtml(content);
        DomGlobal.setTimeout(p0 -> {
            enhanceContent();
        }, 0);
    }

    @Override
    public void enhancePadding() {
        DomGlobal.setTimeout(p0 -> {
            NavigationEnhancer.enhancePadding();
        });
    }

    @Override
    public void registerSlots() {
        Element slot = DomGlobal.document.getElementById("dui-demo-sample-slot");
        if(nonNull(slot)) {
            Brix.get().slots().unRegister(ElementIdSlot.of("dui-demo-sample-slot"));
            Brix.get().slots().register(ElementIdSlot.of("dui-demo-sample-slot"));
        }
    }
}