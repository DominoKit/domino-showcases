package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PageLayoutStateTest {

  @Test
  public void tracksNavigationWorkspaceAndTaskProgress() {
    PageLayoutState state = PageLayoutState.create("Dashboard", "Operations", 3);

    assertEquals("Dashboard", state.activeArea());
    assertEquals("Operations", state.workspace());
    assertEquals(1, state.taskStep());
    assertFalse(state.navigationCollapsed());

    state.selectArea("Work queue");
    state.selectWorkspace("Finance");
    state.toggleNavigation();
    state.advanceTask();
    state.advanceTask();
    state.advanceTask();

    assertEquals("Work queue", state.activeArea());
    assertEquals("Finance", state.workspace());
    assertTrue(state.navigationCollapsed());
    assertEquals(3, state.taskStep());
  }
}
