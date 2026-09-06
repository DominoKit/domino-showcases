package org.dominokit.showcases.samples.blueprints.masterdetail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordFixtures;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordStore;
import org.junit.Before;
import org.junit.Test;

public class MasterDetailWorkspaceStateTest {

  private MasterDetailWorkspaceState state;

  @Before
  public void setUp() {
    state = MasterDetailWorkspaceState.create(
        CrudRecordStore.create(CrudRecordFixtures.longList()));
  }

  @Test
  public void selectionNavigationAndDetailModesAreBounded() {
    state.select("record-01");
    assertEquals("record-01", state.selectedRecord().get().id());

    state.selectPrevious();
    assertEquals("record-01", state.selectedRecord().get().id());
    state.selectNext();
    assertEquals("record-02", state.selectedRecord().get().id());
    state.setActiveTab("Activity");
    state.setEditMode(true);
    state.setInspectorPinned(true);

    assertEquals("Activity", state.activeTab());
    assertTrue(state.isEditMode());
    assertTrue(state.isInspectorPinned());
  }

  @Test
  public void comparisonHierarchyAndActivityStateAreInteractive() {
    state.toggleCompared("record-01");
    state.toggleCompared("record-02");
    state.toggleCompared("record-03");
    state.toggleCompared("record-04");
    assertEquals(3, state.comparedIds().size());

    state.toggleCompared("record-02");
    assertFalse(state.comparedIds().contains("record-02"));

    state.toggleExpanded("department");
    assertTrue(state.isExpanded("department"));
    state.toggleExpanded("department");
    assertFalse(state.isExpanded("department"));

    List<MasterDetailFixtures.ActivityEvent> matches = state.activityMatches("deploy");
    assertEquals(2, matches.size());
  }
}
