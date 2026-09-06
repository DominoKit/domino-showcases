package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.LongListCrudWithPersistentSidePanelEditorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(LongListCrudWithPersistentSidePanelEditorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class LongListCrudWithPersistentSidePanelEditorPresenter extends ChildPresenter<ShellPresenter, LongListCrudWithPersistentSidePanelEditorView>
    implements LongListCrudWithPersistentSidePanelEditorView.LongListCrudWithPersistentSidePanelEditorUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/long-list-crud-with-persistent-side-panel-editor";
}
