package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.infobox.InfoBoxView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(InfoBoxPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class InfoBoxPresenter extends ChildPresenter<ShellPresenter, InfoBoxView>
    implements InfoBoxView.InfoBoxUiHandlers {

  public static final String ROUTE = "components/infobox";
}
