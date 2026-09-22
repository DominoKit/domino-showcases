package org.dominokit.showcases.samples.helpers.dynamiccss;

import com.google.gwt.junit.client.GWTTestCase;

public class DynamicCssSamplesTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.showcases.samples.DemoSamplesUI";
  }

  public void testLayoutSampleRendersRawAndTokenCompatibleUtilities() {
    DynamicCssLayoutSample sample = DynamicCssLayoutSample.create();

    assertEquals(2, sample.element().querySelectorAll(".dui-dynamic-css-layout-example").length);
    assertTrue(sample.element().textContent.contains("raw CSS value"));
    assertTrue(sample.element().textContent.contains("existing spacing token"));
  }

  public void testColorSampleRendersLiteralAndContextualSchemeExamples() {
    DynamicCssColorSample sample = DynamicCssColorSample.create();

    assertEquals(2, sample.element().querySelectorAll(".dui-dynamic-css-color-example").length);
    assertTrue(sample.element().textContent.contains("literal color"));
    assertTrue(sample.element().textContent.contains("contextual color scheme"));
  }
}
