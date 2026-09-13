package org.dominokit.demo.samples.ui.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class BlueprintSamplePageViewArchitectureTest {

  private static final Path BLUEPRINT_VIEWS =
      Paths.get("src/main/java/org/dominokit/demo/samples/ui/views/blueprints");
  private static final Path BLUEPRINT_PAGE_VIEW =
      Paths.get(
          "src/main/java/org/dominokit/demo/samples/ui/views/BlueprintSamplePageView.java");

  @Test
  public void blueprintViewsUseTheNavBarPageHeaderBase() throws IOException {
    assertTrue(
        "BlueprintSamplePageView must exist",
        Files.exists(BLUEPRINT_PAGE_VIEW));

    String blueprintPageView = Files.readString(BLUEPRINT_PAGE_VIEW);
    assertTrue(
        "BlueprintSamplePageView must create a NavBar",
        blueprintPageView.contains("NavBar.create"));
    String samplePageView =
        Files.readString(
            Paths.get("src/main/java/org/dominokit/demo/samples/ui/views/SamplePageView.java"));
    assertTrue(
        "The shared non-blueprint page view must use PageHeader",
        samplePageView.contains("PageHeader.create"));
    assertTrue(
        "The shared non-blueprint page view must not use BlockHeader",
        !samplePageView.contains("BlockHeader"));

    List<Path> blueprintViews =
        Files.walk(BLUEPRINT_VIEWS)
            .filter(path -> path.toString().endsWith("ViewImpl.java"))
            .collect(Collectors.toList());
    assertEquals(118, blueprintViews.size());
    for (Path blueprintView : blueprintViews) {
      assertTrue(
          blueprintView + " must use BlueprintSamplePageView",
          Files.readString(blueprintView).contains("extends BlueprintSamplePageView<"));
    }
  }
}
