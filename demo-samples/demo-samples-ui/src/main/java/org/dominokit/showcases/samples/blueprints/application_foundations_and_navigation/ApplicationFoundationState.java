package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

public final class ApplicationFoundationState {

  private final int maximumTaskStep;
  private String activeArea;
  private String workspace;
  private int taskStep;
  private boolean navigationCollapsed;

  private ApplicationFoundationState(String activeArea, String workspace, int maximumTaskStep) {
    this.activeArea = activeArea;
    this.workspace = workspace;
    this.maximumTaskStep = Math.max(1, maximumTaskStep);
    this.taskStep = 1;
  }

  public static ApplicationFoundationState create(
      String activeArea, String workspace, int maximumTaskStep) {
    return new ApplicationFoundationState(activeArea, workspace, maximumTaskStep);
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
