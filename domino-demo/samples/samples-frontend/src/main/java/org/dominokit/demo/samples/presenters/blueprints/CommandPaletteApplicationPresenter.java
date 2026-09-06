package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.CommandPaletteApplicationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(CommandPaletteApplicationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class CommandPaletteApplicationPresenter extends ChildPresenter<ShellPresenter, CommandPaletteApplicationView>
    implements CommandPaletteApplicationView.CommandPaletteApplicationUiHandlers {

  public static final String ROUTE = "blueprints/page-layout-and-navigation/command-palette-application";
}
