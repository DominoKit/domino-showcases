package org.dominokit.pages.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.Domino;
import org.dominokit.pages.views.SampleView;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

import static org.dominokit.domino.ui.utils.Domino.div;

public abstract class SampleViewImpl extends BrixView<HTMLDivElement, SampleView.SampleUiHandlers> implements SampleView {

    private final Map<String, DemoSample> samples = new HashMap<>();
    private DivElement root;

    public SampleViewImpl() {
        this.root = div();
        init(this);
    }

    @Override
    public void renderSamples() {
            DomGlobal.document.querySelectorAll("[dui-site-data='dui-sample-container']")
                .asList()
                .stream()
                .map(Domino::elementOf)
                .forEach(element -> {
                    if (element.hasAttribute("dui-sample-id")) {
                        String sampleId = element.getAttribute("dui-sample-id");
                        if (samples.containsKey(sampleId)) {
                            element.clearElement()
                                .appendChild(DemoComponent.create(samples.get(sampleId)));
                        }
                    }
                });
    }

    protected void register(DemoSample demoSample) {
        samples.put(demoSample.getSlot(), demoSample);
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}