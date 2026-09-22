package org.dominokit.showcases.samples.themes;

import com.google.gwt.junit.client.GWTTestCase;

public class ThemeCatalogSampleTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.showcases.samples.DemoSamplesUI";
  }

  public void testCatalogListsTheBuiltInThemeFamilies() {
    ThemeCatalogSample sample = ThemeCatalogSample.create();

    assertEquals(18, sample.element().querySelectorAll(".dui-theme-catalog-identity li").length);
    assertEquals(11, sample.element().querySelectorAll(".dui-theme-catalog-character li").length);
    assertEquals(4, sample.element().querySelectorAll(".dui-theme-catalog-surface li").length);
  }

  public void testSurfaceSampleDescribesIndependentSurfaceTreatments() {
    ThemeSurfaceSample sample = ThemeSurfaceSample.create();

    assertEquals(4, sample.element().querySelectorAll(".dui-theme-surface-treatment").length);
    assertTrue(sample.element().textContent.contains("independently"));
  }
}
