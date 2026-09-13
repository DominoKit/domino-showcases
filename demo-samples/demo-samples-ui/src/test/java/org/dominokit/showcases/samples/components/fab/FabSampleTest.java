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
package org.dominokit.showcases.samples.components.fab;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.Element;
import elemental2.dom.MouseEvent;
import static elemental2.dom.DomGlobal.document;

public class FabSampleTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.showcases.samples.DemoSamplesUI";
  }

  public void testSampleRendersAControlCardWithoutEmbeddingAFab() {
    FabSample sample = FabSample.create();

    assertEquals(0, sample.element().querySelectorAll(".dui-fab").length);
    assertEquals(2, sample.element().querySelectorAll("button").length);
    assertTrue(sample.element().textContent.contains("Single FAB"));
    assertTrue(sample.element().textContent.contains("Expanded FAB"));
  }

  public void testSelectingFabModeMountsOnlyTheSelectedFabOnTheDocumentBody() {
    FabSample sample = FabSample.create();
    Element controls = sample.element().querySelector("button");

    controls.dispatchEvent(new MouseEvent("click"));

    assertEquals(1, document.body.querySelectorAll(".dui-fab").length);
    assertEquals(0, document.body.querySelectorAll(".dui-fab-actions").length);

    Element expandedControl = sample.element().querySelectorAll("button").item(1);
    expandedControl.dispatchEvent(new MouseEvent("click"));

    assertEquals(1, document.body.querySelectorAll(".dui-fab").length);
    assertEquals(1, document.body.querySelectorAll(".dui-fab-actions").length);
  }
}
