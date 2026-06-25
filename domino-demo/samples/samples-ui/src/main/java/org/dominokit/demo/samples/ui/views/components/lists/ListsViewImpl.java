package org.dominokit.demo.samples.ui.views.components.lists;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.lists.ListsView;
        import org.dominokit.showcases.samples.components.lists.SingleSelectListsSample;
import org.dominokit.showcases.samples.components.lists.MultiSelectListsSample;

        @UiView
        public class ListsViewImpl extends SamplePageView<ListsView.ListsUiHandlers>
            implements ListsView {

          @Inject
          public ListsViewImpl() {
            super("Lists", "Lists examples rendered from the shared demo-samples module.");
    addSample(SingleSelectListsSample.class, SingleSelectListsSample::create);
    addSample(MultiSelectListsSample.class, MultiSelectListsSample::create);
            initPage();
          }
        }
