package org.dominokit.pages.ui.views.samples.theming;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.themes.EmphasisCardsSample;
import org.dominokit.showcases.samples.themes.EmphasisComponentsSample;
import org.dominokit.showcases.samples.themes.EmphasisGroupsSample;
import org.dominokit.showcases.samples.themes.ThemeCatalogSample;
import org.dominokit.showcases.samples.themes.ThemeCompositionSample;
import org.dominokit.showcases.samples.themes.ThemeSurfaceSample;

@UiView
public class ThemingViewImpl extends SampleViewImpl {

  @Inject
  public ThemingViewImpl() {
    register(
        DemoSample.of(
            "theming-composition",
            ThemeCompositionSample.class,
            LazyProvider.of(ThemeCompositionSample::create)));
    register(
        DemoSample.of(
            "theming-catalog", ThemeCatalogSample.class, LazyProvider.of(ThemeCatalogSample::create)));
    register(
        DemoSample.of(
            "theming-surfaces", ThemeSurfaceSample.class, LazyProvider.of(ThemeSurfaceSample::create)));
    register(
        DemoSample.of(
            "theming-emphasis-components",
            EmphasisComponentsSample.class,
            LazyProvider.of(EmphasisComponentsSample::create)));
    register(
        DemoSample.of(
            "theming-emphasis-groups",
            EmphasisGroupsSample.class,
            LazyProvider.of(EmphasisGroupsSample::create)));
    register(
        DemoSample.of(
            "theming-emphasis-cards",
            EmphasisCardsSample.class,
            LazyProvider.of(EmphasisCardsSample::create)));
  }
}
