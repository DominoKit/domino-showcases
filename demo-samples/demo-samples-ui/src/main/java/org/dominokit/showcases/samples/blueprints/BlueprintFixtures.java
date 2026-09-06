package org.dominokit.showcases.samples.blueprints;

import java.util.Arrays;
import java.util.List;

public final class BlueprintFixtures {

  private BlueprintFixtures() {}

  public static List<String> records() {
    return Arrays.asList("Northwind account", "Contoso renewal", "Fabrikam request", "Adventure Works");
  }

  public static List<String> statuses() {
    return Arrays.asList("Ready", "In progress", "Needs review", "Completed");
  }

  public static List<String> metrics() {
    return Arrays.asList("42", "87%", "1,284", "$2.4M");
  }
}
