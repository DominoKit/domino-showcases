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
package org.dominokit.demo.samples.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.demo.samples.presenters.components.BrixUnitValuePresenterModule_;
import org.dominokit.demo.samples.presenters.components.UnitValuePresenter;
import org.dominokit.demo.samples.presenters.components.UnitValuePresenterProvider;
import org.dominokit.demo.samples.ui.views.components.unitvalue.BrixUnitValueViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = UnitValuePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixUnitValuePresenterModule_.class,
        BrixUnitValueViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface UnitValueComponent
    extends IsBrixComponent, HasPresenterProvider<UnitValuePresenterProvider> {

  ComponentProvider<UnitValueComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected UnitValueComponent newInstance() {
          return DaggerUnitValueComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
