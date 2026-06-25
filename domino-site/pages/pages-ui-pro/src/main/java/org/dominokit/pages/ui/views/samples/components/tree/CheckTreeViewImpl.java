package org.dominokit.pages.ui.views.samples.components.tree;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.tree.*;

@UiView
public class CheckTreeViewImpl extends SampleViewImpl {
    @Inject
    public CheckTreeViewImpl() {
        register(DemoSample.of("check-tree-simple", SimpleCheckTreeSample.class, LazyProvider.of(SimpleCheckTreeSample::create)));
        register(DemoSample.of("check-tree-nested", NestedCheckTreeSample.class, LazyProvider.of(NestedCheckTreeSample::create)));
        register(DemoSample.of("check-tree-featured", FeaturedCheckTreeSample.class, LazyProvider.of(FeaturedCheckTreeSample::create)));
    }
}