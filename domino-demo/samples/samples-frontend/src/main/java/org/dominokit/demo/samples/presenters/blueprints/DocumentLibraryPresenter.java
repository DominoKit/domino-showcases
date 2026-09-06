package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.DocumentLibraryView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DocumentLibraryPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DocumentLibraryPresenter extends ChildPresenter<ShellPresenter, DocumentLibraryView>
    implements DocumentLibraryView.DocumentLibraryUiHandlers {

  public static final String ROUTE = "blueprints/content-files-communication-and-collaboration/document-library";
}
