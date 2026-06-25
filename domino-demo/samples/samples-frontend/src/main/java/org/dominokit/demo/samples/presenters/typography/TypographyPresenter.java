package org.dominokit.demo.samples.presenters.typography;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.typography.TypographyView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TypographyPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TypographyPresenter extends ChildPresenter<ShellPresenter, TypographyView>
    implements TypographyView.TypographyUiHandlers {

  public static final String ROUTE = "typography";
}
