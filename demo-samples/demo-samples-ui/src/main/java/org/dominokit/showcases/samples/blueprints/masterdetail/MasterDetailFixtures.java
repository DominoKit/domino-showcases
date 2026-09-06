package org.dominokit.showcases.samples.blueprints.masterdetail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MasterDetailFixtures {

  private MasterDetailFixtures() {}

  public static List<ActivityEvent> activityEvents() {
    return Arrays.asList(
        ActivityEvent.create("Deployment approved", "Deployment", "Ava", "Today, 09:42"),
        ActivityEvent.create("Ownership review requested", "Review", "Noah", "Yesterday, 16:18"),
        ActivityEvent.create("Deployment completed", "Deployment", "Emma", "Yesterday, 11:05"),
        ActivityEvent.create("Description updated", "Change", "Sam", "Monday, 14:26"),
        ActivityEvent.create("Access policy checked", "Security", "Hana", "Friday, 10:12"),
        ActivityEvent.create("Record created", "Created", "Liam", "May 28, 08:30"));
  }

  public static List<RelatedEntity> relatedEntities(String recordId) {
    String suffix = recordId == null ? "record" : recordId;
    return Arrays.asList(
        RelatedEntity.create(suffix + "-owner", "Owner profile", "Person", "Ava Morgan"),
        RelatedEntity.create(suffix + "-service", "Service catalog", "Service", "Operations Hub"),
        RelatedEntity.create(suffix + "-policy", "Access policy", "Policy", "Standard internal"));
  }

  public static List<HierarchyNode> hierarchy() {
    return Arrays.asList(
        HierarchyNode.create(
            "department",
            "Operations department",
            Arrays.asList(
                HierarchyNode.create(
                    "service-delivery",
                    "Service delivery",
                    Arrays.asList(
                        HierarchyNode.create("alpha-hub", "Alpha Hub", Collections.emptyList()),
                        HierarchyNode.create("northwind-queue", "Northwind Queue", Collections.emptyList()))),
                HierarchyNode.create(
                    "customer-success",
                    "Customer success",
                    Arrays.asList(
                        HierarchyNode.create("harbor-accounts", "Harbor Accounts", Collections.emptyList()),
                        HierarchyNode.create("cedar-requests", "Cedar Requests", Collections.emptyList()))))));
  }

  public static final class ActivityEvent {
    private final String summary;
    private final String type;
    private final String actor;
    private final String timestamp;

    private ActivityEvent(String summary, String type, String actor, String timestamp) {
      this.summary = summary;
      this.type = type;
      this.actor = actor;
      this.timestamp = timestamp;
    }

    public static ActivityEvent create(String summary, String type, String actor, String timestamp) {
      return new ActivityEvent(summary, type, actor, timestamp);
    }

    public String summary() {
      return summary;
    }

    public String type() {
      return type;
    }

    public String actor() {
      return actor;
    }

    public String timestamp() {
      return timestamp;
    }
  }

  public static final class RelatedEntity {
    private final String id;
    private final String label;
    private final String kind;
    private final String detail;

    private RelatedEntity(String id, String label, String kind, String detail) {
      this.id = id;
      this.label = label;
      this.kind = kind;
      this.detail = detail;
    }

    public static RelatedEntity create(String id, String label, String kind, String detail) {
      return new RelatedEntity(id, label, kind, detail);
    }

    public String id() {
      return id;
    }

    public String label() {
      return label;
    }

    public String kind() {
      return kind;
    }

    public String detail() {
      return detail;
    }
  }

  public static final class HierarchyNode {
    private final String id;
    private final String label;
    private final List<HierarchyNode> children;

    private HierarchyNode(String id, String label, List<HierarchyNode> children) {
      this.id = id;
      this.label = label;
      this.children = Collections.unmodifiableList(new ArrayList<>(children));
    }

    public static HierarchyNode create(String id, String label, List<HierarchyNode> children) {
      return new HierarchyNode(id, label, children);
    }

    public String id() {
      return id;
    }

    public String label() {
      return label;
    }

    public List<HierarchyNode> children() {
      return children;
    }

    public boolean hasChildren() {
      return !children.isEmpty();
    }
  }
}
