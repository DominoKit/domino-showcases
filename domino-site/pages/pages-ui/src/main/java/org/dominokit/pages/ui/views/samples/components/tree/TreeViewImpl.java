package org.dominokit.pages.ui.views.samples.components.tree;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.tree.*;

@UiView
public class TreeViewImpl extends SampleViewImpl {
    @Inject
    public TreeViewImpl() {
        register(DemoSample.of("tree-basic", BasicTreeSample.class, LazyProvider.of(BasicTreeSample::create)));
        register(DemoSample.of("tree-nested", NestedTreeSample.class, LazyProvider.of(NestedTreeSample::create)));
        register(DemoSample.of("tree-featured", FeaturedTreeSample.class, LazyProvider.of(FeaturedTreeSample::create)));
    }
}