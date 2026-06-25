package org.dominokit.demo.samples.views.icons;

import org.dominokit.brix.api.Viewable;
import org.dominokit.demo.samples.presenters.icons.IconsPresenterUiHandlers;

public interface IconsView extends Viewable {

  void setTag(String tag);

  interface IconsUiHandlers extends IconsPresenterUiHandlers {}
}
