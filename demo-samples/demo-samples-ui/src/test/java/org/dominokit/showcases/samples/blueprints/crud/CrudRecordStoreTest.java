package org.dominokit.showcases.samples.blueprints.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CrudRecordStoreTest {

  private CrudRecordStore store;

  @Before
  public void setUp() {
    store = CrudRecordStore.create(CrudRecordFixtures.longList());
  }

  @Test
  public void searchIsCaseInsensitiveAndPageBeyondEndIsEmpty() {
    assertEquals(3, store.search("ALPHA").size());

    CrudRecordStore.Page page = store.page("", 99, 10);
    assertEquals(2, page.pageIndex());
    assertTrue(page.records().isEmpty());
  }

  @Test
  public void crudOperationsValidateAndMaintainSelection() {
    CrudRecord first = store.records().get(0);
    store.select(first.id());

    assertTrue(store.add(CrudRecord.create("new", "New record", "Ava", "Draft", "New")));
    assertTrue(store.update(CrudRecord.create(first.id(), "Renamed record", first.owner(), "Active", first.description())));
    assertEquals("Renamed record", store.find(first.id()).get().name());
    assertTrue(store.delete(first.id()));
    assertTrue(store.selectedId().isEmpty());
    assertTrue(store.add(CrudRecord.create("", "   ", "Ava", "Draft", "Invalid")) == false);
  }
}
