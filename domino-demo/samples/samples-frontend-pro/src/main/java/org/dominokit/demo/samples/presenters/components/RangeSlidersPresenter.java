package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.sliders.RangeSlidersView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RangeSlidersPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RangeSlidersPresenter extends ChildPresenter<ShellPresenter, RangeSlidersView>
    implements RangeSlidersView.RangeSlidersUiHandlers {

  public static final String ROUTE = "components/range-slider";
}
