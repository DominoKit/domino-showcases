package org.dominokit.pages.ui.views.samples.components.pageheader;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.pageheader.PageHeaderSample;

@UiView
public class PageHeaderViewImpl extends SampleViewImpl {

  @Inject
  public PageHeaderViewImpl() {
    register(
        DemoSample.of(
            "page-header-overview",
            PageHeaderSample.class,
            LazyProvider.of(PageHeaderSample::create)));
  }
}
