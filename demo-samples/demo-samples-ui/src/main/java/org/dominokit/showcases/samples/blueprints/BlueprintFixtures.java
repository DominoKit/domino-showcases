package org.dominokit.showcases.samples.blueprints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BlueprintFixtures {

  private BlueprintFixtures() {}

  public static List<BlueprintRecord> shortRecords() {
    return new ArrayList<>(
        Arrays.asList(
            record(1, "Northwind renewal", "Renewal", "Active", "Maya", "2026-09-02", "$18,400"),
            record(2, "Orion rollout", "Implementation", "Pending", "Omar", "2026-09-04", "$9,850"),
            record(3, "Atlas review", "Compliance", "Draft", "Lina", "2026-09-06", "$4,200"),
            record(4, "Harbor expansion", "Expansion", "Active", "Samir", "2026-09-08", "$27,100"),
            record(5, "Summit renewal", "Renewal", "Archived", "Nour", "2026-09-10", "$12,600"),
            record(6, "Cedar onboarding", "Onboarding", "Pending", "Rami", "2026-09-12", "$6,750")));
  }

  public static List<BlueprintRecord> longRecords() {
    List<BlueprintRecord> records = new ArrayList<>();
    for (int index = 1; index <= 36; index++) {
      records.add(
          record(
              index,
              "Enterprise record " + index,
              index % 3 == 0 ? "Compliance" : index % 2 == 0 ? "Implementation" : "Renewal",
              index % 5 == 0 ? "Pending" : index % 7 == 0 ? "Draft" : "Active",
              index % 2 == 0 ? "Omar" : "Maya",
              "2026-09-" + String.format("%02d", (index % 28) + 1),
              "$" + (index * 1250),
              "A fixture record used to demonstrate a dense enterprise list."));
    }
    return records;
  }

  public static List<AuditEvent> auditEvents() {
    return Arrays.asList(
        new AuditEvent("09:42", "Maya", "Updated", "Northwind renewal", "Low"),
        new AuditEvent("09:18", "Omar", "Approved", "Orion rollout", "Medium"),
        new AuditEvent("08:57", "Lina", "Exported", "Compliance report", "Low"),
        new AuditEvent("08:31", "Samir", "Changed owner", "Harbor expansion", "High"),
        new AuditEvent("Yesterday", "Nour", "Archived", "Summit renewal", "Medium"));
  }

  private static BlueprintRecord record(
      int id, String name, String category, String status, String owner, String date, String amount) {
    return record(id, name, category, status, owner, date, amount, "A reusable enterprise record fixture.");
  }

  private static BlueprintRecord record(
      int id,
      String name,
      String category,
      String status,
      String owner,
      String date,
      String amount,
      String description) {
    return new BlueprintRecord(id, name, category, status, owner, date, amount, description);
  }

  public static final class AuditEvent {
    private final String time;
    private final String actor;
    private final String action;
    private final String target;
    private final String severity;

    public AuditEvent(String time, String actor, String action, String target, String severity) {
      this.time = time;
      this.actor = actor;
      this.action = action;
      this.target = target;
      this.severity = severity;
    }

    public String getTime() {
      return time;
    }

    public String getActor() {
      return actor;
    }

    public String getAction() {
      return action;
    }

    public String getTarget() {
      return target;
    }

    public String getSeverity() {
      return severity;
    }
  }
}
