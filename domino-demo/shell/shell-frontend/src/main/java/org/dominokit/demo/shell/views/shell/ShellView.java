package org.dominokit.demo.shell.views.shell;

import org.dominokit.brix.api.Slot;
import org.dominokit.brix.api.Viewable;
import org.dominokit.demo.shell.presenters.shell.ShellPresenterUiHandlers;

public interface ShellView extends Viewable {

  Slot contentSlot(String slotKey);

  void startLoading();

  void stopLoading();

  void spanDown(boolean spanDown);

  void spanUp(boolean spanUp);

  void toggleRightPanel();

  ShellView showRightPanel();

  ShellView hideRightPanel();

  void toggleLeftPanel();

  ShellView showLeftPanel();

  ShellView hideLeftPanel();

  ShellView setTitle(String title);

  boolean isRightPanelVisible();

  ShellView fixLeftPanelPosition();

  ShellView unfixLeftPanelPosition();

  ShellView setLeftPanelSize(String size);

  ShellView scrollTop();

  interface ShellUiHandlers extends ShellPresenterUiHandlers {
  }
}
