package org.dominokit.showcases.samples.blueprints.crud;

import java.util.ArrayList;
import java.util.List;

public final class CrudRecordFixtures {

  private CrudRecordFixtures() {}

  public static List<CrudRecord> shortList() {
    return longList().subList(0, 6);
  }

  public static List<CrudRecord> longList() {
    List<CrudRecord> records = new ArrayList<>();
    records.add(CrudRecord.create("record-01", "Alpha Hub", "Ava", "Active", "Primary service directory"));
    records.add(CrudRecord.create("record-02", "Northwind Queue", "Noah", "Draft", "Pending ownership review"));
    records.add(CrudRecord.create("record-03", "Alpha Edge", "Emma", "Active", "Regional operations workspace"));
    records.add(CrudRecord.create("record-04", "Summit Registry", "Sam", "Paused", "Awaiting compliance evidence"));
    records.add(CrudRecord.create("record-05", "Harbor Accounts", "Hana", "Active", "Customer account directory"));
    records.add(CrudRecord.create("record-06", "Alpha Labs", "Liam", "Draft", "Experimental workflow catalog"));
    records.add(CrudRecord.create("record-07", "Cedar Requests", "Cara", "Active", "Incoming service requests"));
    records.add(CrudRecord.create("record-08", "Atlas Inventory", "Amir", "Active", "Stock and availability records"));
    records.add(CrudRecord.create("record-09", "Beacon Policies", "Bea", "Review", "Policy change proposals"));
    records.add(CrudRecord.create("record-10", "Delta Partners", "Diego", "Active", "Partner relationship records"));
    records.add(CrudRecord.create("record-11", "Elm Contracts", "Elena", "Draft", "Contract renewal workspace"));
    records.add(CrudRecord.create("record-12", "Fjord Services", "Finn", "Active", "Service entitlement records"));
    records.add(CrudRecord.create("record-13", "Granite Sites", "Grace", "Paused", "Site rollout planning"));
    records.add(CrudRecord.create("record-14", "Horizon Teams", "Hugo", "Active", "Team membership registry"));
    records.add(CrudRecord.create("record-15", "Indigo Plans", "Iris", "Review", "Planning cycle submissions"));
    records.add(CrudRecord.create("record-16", "Juniper Vendors", "Jules", "Active", "Vendor onboarding records"));
    records.add(CrudRecord.create("record-17", "Keystone Assets", "Kira", "Draft", "Asset ownership records"));
    records.add(CrudRecord.create("record-18", "Lumen Billing", "Leo", "Active", "Billing exception queue"));
    records.add(CrudRecord.create("record-19", "Metro Offices", "Maya", "Active", "Office and location records"));
    records.add(CrudRecord.create("record-20", "Nimbus Access", "Nora", "Review", "Access request records"));
    records.add(CrudRecord.create("record-21", "Orchard Products", "Omar", "Active", "Product catalog records"));
    records.add(CrudRecord.create("record-22", "Pioneer Cases", "Priya", "Paused", "Case management records"));
    records.add(CrudRecord.create("record-23", "Quartz Billing", "Quinn", "Active", "Invoice reconciliation records"));
    records.add(CrudRecord.create("record-24", "Riverside Plans", "Rita", "Draft", "Long-range planning records"));
    return records;
  }
}
