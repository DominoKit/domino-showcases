package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.tree.TreeView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TreePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TreePresenter extends ChildPresenter<ShellPresenter, TreeView>
    implements TreeView.TreeUiHandlers {

  public static final String ROUTE = "components/tree";
}
