package org.dominokit.demo.samples.views.home;

import org.dominokit.brix.api.Viewable;
import org.dominokit.demo.samples.presenters.home.HomePresenterUiHandlers;

public interface HomeView extends Viewable {

  interface HomeUiHandlers extends HomePresenterUiHandlers {}
}
