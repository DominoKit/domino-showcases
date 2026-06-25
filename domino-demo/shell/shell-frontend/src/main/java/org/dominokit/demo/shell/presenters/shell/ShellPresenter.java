package org.dominokit.demo.shell.presenters.shell;

import org.dominokit.brix.Brix;
import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.UiHandler;
import org.dominokit.brix.api.BrixSlots;
import org.dominokit.brix.api.Presenter;
import org.dominokit.demo.shell.views.shell.ShellView;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.domino.history.StateToken;

@BrixPresenter
@BrixRoute
@BrixSlot(BrixSlots.BRIX_BODY_SLOT)
public abstract class ShellPresenter extends Presenter<ShellView> implements ShellView.ShellUiHandlers {

  public static final String CONTENT_SLOT = "shell-content";

  @Override
  protected void registerSlots() {
    registerSlot(view.contentSlot(CONTENT_SLOT));
  }

  @UiHandler
  public void onLocked() {
    view.fixLeftPanelPosition();
  }

  @UiHandler
  public void onUnLocked() {
    view.unfixLeftPanelPosition();
    view.hideLeftPanel();
  }

  @UiHandler
  public void onXLargeMedia() {
    view.fixLeftPanelPosition();
  }

  @UiHandler
  public void onLargeMedia() {
    view.fixLeftPanelPosition();
  }

  @UiHandler
  public void onMediumMedia() {
    view.unfixLeftPanelPosition();
    view.hideLeftPanel();
  }

  @UiHandler
  public void onSmallMedia() {
    view.unfixLeftPanelPosition();
    view.hideLeftPanel();
  }

  @UiHandler
  public void onXSmallMedia() {
    view.unfixLeftPanelPosition();
    view.hideLeftPanel();
  }

  @UiHandler
  public void onMenuItemSelected(String token) {
    view.scrollTop();
    HistoryToken currentToken = Brix.get().router().currentToken();
    StateToken nextToken = currentToken == null
        ? StateToken.of(token)
        : StateToken.of(currentToken.replaceAllPaths(token));
    Brix.get().router().fireState(nextToken);
  }

  @UiHandler
  public void onSpanDown(boolean spanDown) {
    view.spanDown(spanDown);
  }

  @UiHandler
  public void onSpanUp(boolean spanUp) {
    view.spanUp(spanUp);
  }
}
