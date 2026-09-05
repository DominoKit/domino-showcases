package org.dominokit.showcases.samples.blueprints;

public class BlueprintRecord {

  private final int id;
  private String name;
  private String category;
  private String status;
  private String owner;
  private String date;
  private String amount;
  private String description;

  public BlueprintRecord(
      int id,
      String name,
      String category,
      String status,
      String owner,
      String date,
      String amount,
      String description) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.status = status;
    this.owner = owner;
    this.date = date;
    this.amount = amount;
    this.description = description;
  }

  public BlueprintRecord copy() {
    return new BlueprintRecord(id, name, category, status, owner, date, amount, description);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
