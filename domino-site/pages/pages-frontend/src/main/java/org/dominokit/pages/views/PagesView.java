package org.dominokit.pages.views;

import org.dominokit.brix.api.HasUiHandlers;
import org.dominokit.brix.api.UiHandlers;
import org.dominokit.brix.api.Viewable;

import java.util.function.Consumer;

public interface PagesView extends Viewable, HasUiHandlers<PagesView.PagesUiHandlers> {

    void enhance(Consumer<Void> handler);
    void enhanceContent();

    void updateContent(String content);

    void replaceContent(String content, String targetElementId);

    void enhancePadding();

    void registerSlots();

    interface PagesUiHandlers extends UiHandlers {
    }
}