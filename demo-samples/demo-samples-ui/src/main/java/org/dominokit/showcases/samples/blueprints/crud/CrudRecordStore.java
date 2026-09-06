package org.dominokit.showcases.samples.blueprints.crud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public final class CrudRecordStore {

  private final List<CrudRecord> records;
  private String selectedId;

  private CrudRecordStore(List<CrudRecord> initialRecords) {
    this.records = new ArrayList<>(initialRecords);
  }

  public static CrudRecordStore create(List<CrudRecord> initialRecords) {
    return new CrudRecordStore(initialRecords);
  }

  public List<CrudRecord> records() {
    return Collections.unmodifiableList(new ArrayList<>(records));
  }

  public List<CrudRecord> search(String query) {
    String normalizedQuery = normalize(query);
    if (normalizedQuery.isEmpty()) {
      return records();
    }
    List<CrudRecord> matches = new ArrayList<>();
    for (CrudRecord record : records) {
      if (contains(record.name(), normalizedQuery)
          || contains(record.owner(), normalizedQuery)
          || contains(record.status(), normalizedQuery)
          || contains(record.description(), normalizedQuery)) {
        matches.add(record);
      }
    }
    return Collections.unmodifiableList(matches);
  }

  public Page page(String query, int requestedPage, int pageSize) {
    if (pageSize <= 0) {
      throw new IllegalArgumentException("pageSize must be positive");
    }
    List<CrudRecord> matches = search(query);
    int pageCount = Math.max(1, (matches.size() + pageSize - 1) / pageSize);
    int pageIndex = Math.max(0, Math.min(requestedPage, pageCount - 1));
    if (requestedPage >= pageCount) {
      return new Page(Collections.emptyList(), pageIndex, pageCount, matches.size());
    }
    int start = pageIndex * pageSize;
    int end = Math.min(start + pageSize, matches.size());
    return new Page(matches.subList(start, end), pageIndex, pageCount, matches.size());
  }

  public Optional<CrudRecord> find(String id) {
    for (CrudRecord record : records) {
      if (record.id().equals(id)) {
        return Optional.of(record);
      }
    }
    return Optional.empty();
  }

  public boolean add(CrudRecord draft) {
    if (!valid(draft) || find(draft.id()).isPresent()) {
      return false;
    }
    records.add(draft);
    return true;
  }

  public boolean update(CrudRecord draft) {
    if (!valid(draft)) {
      return false;
    }
    for (int i = 0; i < records.size(); i++) {
      if (records.get(i).id().equals(draft.id())) {
        records.set(i, draft);
        return true;
      }
    }
    return false;
  }

  public boolean delete(String id) {
    boolean removed = records.removeIf(record -> record.id().equals(id));
    if (removed && id.equals(selectedId)) {
      selectedId = null;
    }
    return removed;
  }

  public Optional<String> selectedId() {
    return Optional.ofNullable(selectedId);
  }

  public void select(String id) {
    selectedId = find(id).isPresent() ? id : null;
  }

  private boolean valid(CrudRecord draft) {
    return draft != null && !normalize(draft.id()).isEmpty() && !normalize(draft.name()).isEmpty();
  }

  private boolean contains(String value, String query) {
    return normalize(value).contains(query);
  }

  private String normalize(String value) {
    return value == null ? "" : value.trim().toLowerCase(Locale.ROOT);
  }

  public static final class Page {
    private final List<CrudRecord> records;
    private final int pageIndex;
    private final int pageCount;
    private final int totalMatches;

    private Page(List<CrudRecord> records, int pageIndex, int pageCount, int totalMatches) {
      this.records = Collections.unmodifiableList(new ArrayList<>(records));
      this.pageIndex = pageIndex;
      this.pageCount = pageCount;
      this.totalMatches = totalMatches;
    }

    public List<CrudRecord> records() {
      return records;
    }

    public int pageIndex() {
      return pageIndex;
    }

    public int pageCount() {
      return pageCount;
    }

    public int totalMatches() {
      return totalMatches;
    }
  }
}
