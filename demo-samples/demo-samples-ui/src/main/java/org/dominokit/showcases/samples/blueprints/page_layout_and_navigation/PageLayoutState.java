package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

public final class PageLayoutState {

  private final int maximumTaskStep;
  private String activeArea;
  private String workspace;
  private int taskStep;
  private boolean navigationCollapsed;

  private PageLayoutState(String activeArea, String workspace, int maximumTaskStep) {
    this.activeArea = activeArea;
    this.workspace = workspace;
    this.maximumTaskStep = Math.max(1, maximumTaskStep);
    this.taskStep = 1;
  }

  public static PageLayoutState create(
      String activeArea, String workspace, int maximumTaskStep) {
    return new PageLayoutState(activeArea, workspace, maximumTaskStep);
  }

  public String activeArea() {
    return activeArea;
  }

  public void selectArea(String area) {
    activeArea = area;
  }

  public String workspace() {
    return workspace;
  }

  public void selectWorkspace(String workspace) {
    this.workspace = workspace;
  }

  public boolean navigationCollapsed() {
    return navigationCollapsed;
  }

  public void toggleNavigation() {
    navigationCollapsed = !navigationCollapsed;
  }

  public int taskStep() {
    return taskStep;
  }

  public void advanceTask() {
    taskStep = Math.min(maximumTaskStep, taskStep + 1);
  }

  public void resetTask() {
    taskStep = 1;
  }
}
