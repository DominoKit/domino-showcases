package org.dominokit.pages.views;

import org.dominokit.brix.api.HasUiHandlers;
import org.dominokit.brix.api.UiHandlers;
import org.dominokit.brix.api.Viewable;

public interface SampleView extends Viewable, HasUiHandlers<SampleView.SampleUiHandlers> {

    void renderSamples();

    interface SampleUiHandlers extends UiHandlers {
    }
}