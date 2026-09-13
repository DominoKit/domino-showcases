package org.dominokit.demo.samples.ui.views;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class FabViewArchitectureTest {

  private static final Path FAB_VIEW =
      Paths.get("src/main/java/org/dominokit/demo/samples/ui/views/components/fab/FabViewImpl.java");

  @Test
  public void floatingFabSampleIsMountedOutsideTheSampleCard() throws IOException {
    String fabView = Files.readString(FAB_VIEW);

    assertFalse(fabView.contains("addSample(FabSample.class"));
    assertTrue(fabView.contains("appendChild(FabSample.create())"));
    assertTrue(fabView.contains("SampleCodeCard.create(FabSample.class)"));
  }
}
