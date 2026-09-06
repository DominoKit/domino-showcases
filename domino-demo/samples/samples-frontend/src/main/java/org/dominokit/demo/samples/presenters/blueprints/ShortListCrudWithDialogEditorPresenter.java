package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ShortListCrudWithDialogEditorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ShortListCrudWithDialogEditorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ShortListCrudWithDialogEditorPresenter extends ChildPresenter<ShellPresenter, ShortListCrudWithDialogEditorView>
    implements ShortListCrudWithDialogEditorView.ShortListCrudWithDialogEditorUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/short-list-crud-with-dialog-editor";
}
