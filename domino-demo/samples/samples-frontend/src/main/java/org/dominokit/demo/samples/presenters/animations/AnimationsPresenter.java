package org.dominokit.demo.samples.presenters.animations;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.animations.AnimationsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AnimationsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AnimationsPresenter extends ChildPresenter<ShellPresenter, AnimationsView>
    implements AnimationsView.AnimationsUiHandlers {

  public static final String ROUTE = "animations";
}
