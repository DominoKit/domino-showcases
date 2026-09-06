package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.LongListCrudWithDialogEditorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(LongListCrudWithDialogEditorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class LongListCrudWithDialogEditorPresenter extends ChildPresenter<ShellPresenter, LongListCrudWithDialogEditorView>
    implements LongListCrudWithDialogEditorView.LongListCrudWithDialogEditorUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/long-list-crud-with-dialog-editor";
}
