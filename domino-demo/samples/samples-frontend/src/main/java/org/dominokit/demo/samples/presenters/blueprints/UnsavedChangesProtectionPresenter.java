package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.UnsavedChangesProtectionView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(UnsavedChangesProtectionPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class UnsavedChangesProtectionPresenter extends ChildPresenter<ShellPresenter, UnsavedChangesProtectionView>
    implements UnsavedChangesProtectionView.UnsavedChangesProtectionUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/unsaved-changes-protection";
}
