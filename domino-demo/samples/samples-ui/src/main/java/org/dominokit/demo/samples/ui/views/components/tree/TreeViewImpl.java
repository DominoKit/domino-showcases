package org.dominokit.demo.samples.ui.views.components.tree;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.tree.TreeView;
        import org.dominokit.showcases.samples.components.tree.BasicTreeSample;
import org.dominokit.showcases.samples.components.tree.NestedTreeSample;
import org.dominokit.showcases.samples.components.tree.FeaturedTreeSample;

        @UiView
        public class TreeViewImpl extends SamplePageView<TreeView.TreeUiHandlers>
            implements TreeView {

          @Inject
          public TreeViewImpl() {
            super("Tree", "Tree examples rendered from the shared demo-samples module.");
    addSample(BasicTreeSample.class, BasicTreeSample::create);
    addSample(NestedTreeSample.class, NestedTreeSample::create);
    addSample(FeaturedTreeSample.class, FeaturedTreeSample::create);
            initPage();
          }
        }
