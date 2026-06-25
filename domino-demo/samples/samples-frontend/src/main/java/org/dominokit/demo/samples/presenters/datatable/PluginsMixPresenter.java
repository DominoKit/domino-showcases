package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.mix.PluginsMixView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(PluginsMixPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class PluginsMixPresenter extends ChildPresenter<ShellPresenter, PluginsMixView>
    implements PluginsMixView.PluginsMixUiHandlers {

  public static final String ROUTE = "datatable/mix-plugins";
}
