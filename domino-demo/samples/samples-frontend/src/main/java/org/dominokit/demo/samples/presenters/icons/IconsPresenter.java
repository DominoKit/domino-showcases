package org.dominokit.demo.samples.presenters.icons;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.OnReveal;
import org.dominokit.brix.annotations.OnStateChanged;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.icons.IconsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(IconsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class IconsPresenter extends ChildPresenter<ShellPresenter, IconsView>
    implements IconsView.IconsUiHandlers {

  public static final String ROUTE = "mdiicons";

  String tag;

  @Override
  public void setState() {
    if (state.token().paths().size() <= 1) {
      this.tag = null;
      return;
    }

    this.tag = String.join("/", state.token().paths().subList(1, state.token().paths().size()));
  }

  @OnReveal
  public void onReveal() {
    view.setTag(tag);
  }

  @OnStateChanged
  public void onTagChanged() {
    view.setTag(tag);
  }
}
