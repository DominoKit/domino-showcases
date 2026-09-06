package org.dominokit.showcases.samples.blueprints.crud;

import java.util.Objects;

public final class CrudRecord {

  private final String id;
  private final String name;
  private final String owner;
  private final String status;
  private final String description;

  private CrudRecord(String id, String name, String owner, String status, String description) {
    this.id = id;
    this.name = name;
    this.owner = owner;
    this.status = status;
    this.description = description;
  }

  public static CrudRecord create(
      String id, String name, String owner, String status, String description) {
    return new CrudRecord(
        Objects.requireNonNull(id),
        Objects.requireNonNull(name),
        Objects.requireNonNull(owner),
        Objects.requireNonNull(status),
        Objects.requireNonNull(description));
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public String owner() {
    return owner;
  }

  public String status() {
    return status;
  }

  public String description() {
    return description;
  }
}
