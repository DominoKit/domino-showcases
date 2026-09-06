package org.dominokit.showcases.samples.blueprints.masterdetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecord;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordStore;

public final class MasterDetailWorkspaceState {

  private static final int MAX_COMPARED_RECORDS = 3;

  private final CrudRecordStore recordStore;
  private final Set<String> comparedIds = new LinkedHashSet<>();
  private final Set<String> expandedIds = new LinkedHashSet<>();
  private String activeTab = "Summary";
  private boolean editMode;
  private boolean inspectorPinned;

  private MasterDetailWorkspaceState(CrudRecordStore recordStore) {
    this.recordStore = recordStore;
  }

  public static MasterDetailWorkspaceState create(CrudRecordStore recordStore) {
    if (recordStore == null) {
      throw new IllegalArgumentException("recordStore is required");
    }
    return new MasterDetailWorkspaceState(recordStore);
  }

  public CrudRecordStore recordStore() {
    return recordStore;
  }

  public Optional<CrudRecord> selectedRecord() {
    return recordStore.selectedId().flatMap(recordStore::find);
  }

  public void select(String id) {
    recordStore.select(id);
  }

  public void selectNext() {
    moveSelection(1);
  }

  public void selectPrevious() {
    moveSelection(-1);
  }

  public void setActiveTab(String tab) {
    if (tab != null && !tab.trim().isEmpty()) {
      activeTab = tab;
    }
  }

  public String activeTab() {
    return activeTab;
  }

  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public void setInspectorPinned(boolean inspectorPinned) {
    this.inspectorPinned = inspectorPinned;
  }

  public boolean isInspectorPinned() {
    return inspectorPinned;
  }

  public void toggleCompared(String id) {
    if (!recordStore.find(id).isPresent()) {
      return;
    }
    if (!comparedIds.add(id)) {
      comparedIds.remove(id);
    } else if (comparedIds.size() > MAX_COMPARED_RECORDS) {
      comparedIds.remove(id);
    }
  }

  public Set<String> comparedIds() {
    return Collections.unmodifiableSet(new LinkedHashSet<>(comparedIds));
  }

  public void toggleExpanded(String id) {
    if (!expandedIds.add(id)) {
      expandedIds.remove(id);
    }
  }

  public boolean isExpanded(String id) {
    return expandedIds.contains(id);
  }

  public List<MasterDetailFixtures.ActivityEvent> activityMatches(String query) {
    String normalizedQuery = normalize(query);
    List<MasterDetailFixtures.ActivityEvent> matches = new ArrayList<>();
    for (MasterDetailFixtures.ActivityEvent event : MasterDetailFixtures.activityEvents()) {
      if (normalizedQuery.isEmpty()
          || contains(event.summary(), normalizedQuery)
          || contains(event.type(), normalizedQuery)
          || contains(event.actor(), normalizedQuery)) {
        matches.add(event);
      }
    }
    return Collections.unmodifiableList(matches);
  }

  private void moveSelection(int direction) {
    List<CrudRecord> records = recordStore.records();
    if (records.isEmpty()) {
      recordStore.select(null);
      return;
    }
    int currentIndex = indexOfSelected(records);
    int nextIndex;
    if (currentIndex < 0) {
      nextIndex = direction < 0 ? records.size() - 1 : 0;
    } else {
      nextIndex = Math.max(0, Math.min(records.size() - 1, currentIndex + direction));
    }
    recordStore.select(records.get(nextIndex).id());
  }

  private int indexOfSelected(List<CrudRecord> records) {
    Optional<String> selectedId = recordStore.selectedId();
    if (!selectedId.isPresent()) {
      return -1;
    }
    for (int i = 0; i < records.size(); i++) {
      if (records.get(i).id().equals(selectedId.get())) {
        return i;
      }
    }
    return -1;
  }

  private boolean contains(String value, String query) {
    return normalize(value).contains(query);
  }

  private String normalize(String value) {
    return value == null ? "" : value.trim().toLowerCase(Locale.ROOT);
  }
}
