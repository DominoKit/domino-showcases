package org.dominokit.demo.samples.ui.views.components.tree;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.tree.CheckTreeView;
        import org.dominokit.showcases.samples.components.tree.SimpleCheckTreeSample;
import org.dominokit.showcases.samples.components.tree.NestedCheckTreeSample;
import org.dominokit.showcases.samples.components.tree.FeaturedCheckTreeSample;

        @UiView
        public class CheckTreeViewImpl extends SamplePageView<CheckTreeView.CheckTreeUiHandlers>
            implements CheckTreeView {

          @Inject
          public CheckTreeViewImpl() {
            super("Check Tree", "Check Tree examples rendered from the shared demo-samples module.");
    addSample(SimpleCheckTreeSample.class, SimpleCheckTreeSample::create);
    addSample(NestedCheckTreeSample.class, NestedCheckTreeSample::create);
    addSample(FeaturedCheckTreeSample.class, FeaturedCheckTreeSample::create);
            initPage();
          }
        }
