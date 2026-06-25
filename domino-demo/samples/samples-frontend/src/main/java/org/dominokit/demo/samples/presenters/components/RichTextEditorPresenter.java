package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.richtext.RichTextEditorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RichTextEditorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RichTextEditorPresenter
    extends ChildPresenter<ShellPresenter, RichTextEditorView>
    implements RichTextEditorView.RichTextEditorUiHandlers {

  public static final String ROUTE = "components/rich-text-editor";
}
