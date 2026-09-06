package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.ReadOnlyPermissionVariantView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ReadOnlyPermissionVariantPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ReadOnlyPermissionVariantPresenter extends ChildPresenter<ShellPresenter, ReadOnlyPermissionVariantView>
    implements ReadOnlyPermissionVariantView.ReadOnlyPermissionVariantUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/read-only-permission-variant";
}
