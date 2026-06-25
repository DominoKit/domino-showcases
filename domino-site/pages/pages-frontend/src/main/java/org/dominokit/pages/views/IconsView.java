package org.dominokit.pages.views;

import org.dominokit.brix.api.HasUiHandlers;
import org.dominokit.brix.api.UiHandlers;
import org.dominokit.brix.api.Viewable;

public interface IconsView  extends Viewable, HasUiHandlers<IconsView.IconsUiHandlers> {

        interface IconsUiHandlers extends UiHandlers {
        }
        void setTag(String tag);
}