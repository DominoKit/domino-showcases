package org.dominokit.showcases.samples.components.pageheader;

import com.google.gwt.junit.client.GWTTestCase;

public class PageHeaderSampleTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.showcases.samples.DemoSamplesUI";
  }

  public void testSampleRendersAPageHeaderWithTitleDescriptionAndActions() {
    PageHeaderSample sample = PageHeaderSample.create();

    assertEquals(1, sample.element().querySelectorAll(".dui-page-header").length);
    assertTrue(sample.element().textContent.contains("Orders"));
    assertTrue(sample.element().textContent.contains("Review and manage your customer orders."));
    assertEquals(1, sample.element().querySelectorAll("button").length);
  }
}
