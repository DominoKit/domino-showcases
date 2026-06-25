package org.dominokit.pages.views;


import org.dominokit.brix.api.HasUiHandlers;
import org.dominokit.brix.api.UiHandlers;
import org.dominokit.brix.api.Viewable;

public interface ColorsView extends Viewable, HasUiHandlers<ColorsView.ColorsUiHandlers> {

        interface ColorsUiHandlers extends UiHandlers {
        }
}