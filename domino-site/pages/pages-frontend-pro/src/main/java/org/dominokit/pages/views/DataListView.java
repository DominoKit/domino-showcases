package org.dominokit.pages.views;

import org.dominokit.brix.api.HasUiHandlers;
import org.dominokit.brix.api.UiHandlers;
import org.dominokit.brix.api.Viewable;

public interface DataListView extends Viewable, HasUiHandlers<DataListView.DataListUiHandlers> {

  interface DataListUiHandlers extends UiHandlers {}
}
