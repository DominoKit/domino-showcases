package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.RichContentEditorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RichContentEditorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RichContentEditorPresenter extends ChildPresenter<ShellPresenter, RichContentEditorView>
    implements RichContentEditorView.RichContentEditorUiHandlers {

  public static final String ROUTE = "blueprints/content-files-communication-and-collaboration/rich-content-editor";
}
