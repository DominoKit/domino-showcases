/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.showcases.samples.components.unitvalue;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.HTMLElement;

public class UnitValueSampleTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.showcases.samples.DemoSamplesUI";
  }

  public void testSampleRendersTheSupportedUnitValueVariants() {
    UnitValueSample sample = UnitValueSample.create();

    assertEquals(5, sample.element().querySelectorAll(".dui-unit-value").length);
    assertEquals("603.455", valueAt(sample, 0));
    assertEquals("-293.517", valueAt(sample, 1));
    assertEquals("1,989.729", valueAt(sample, 2));
    assertEquals("78.661", valueAt(sample, 3));
    assertEquals("42", valueAt(sample, 4));
  }

  private String valueAt(UnitValueSample sample, int index) {
    return ((HTMLElement)
            sample.element().querySelectorAll(".dui-unit-value-value").item(index))
        .textContent;
  }
}
