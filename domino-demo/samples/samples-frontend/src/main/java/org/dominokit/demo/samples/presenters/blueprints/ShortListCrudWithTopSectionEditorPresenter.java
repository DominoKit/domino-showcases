package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ShortListCrudWithTopSectionEditorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ShortListCrudWithTopSectionEditorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ShortListCrudWithTopSectionEditorPresenter extends ChildPresenter<ShellPresenter, ShortListCrudWithTopSectionEditorView>
    implements ShortListCrudWithTopSectionEditorView.ShortListCrudWithTopSectionEditorUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/short-list-crud-with-top-section-editor";
}
