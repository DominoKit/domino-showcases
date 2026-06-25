package org.dominokit.demo.samples.ui.views.forms.advanced;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.advanced.AdvancedFormElementsView;
        import org.dominokit.showcases.samples.forms.suggest.SuggestBoxSample;
import org.dominokit.showcases.samples.forms.suggest.TagsInputSample;
import org.dominokit.showcases.samples.forms.input.UploadBoxSample;
import org.dominokit.showcases.samples.forms.input.FileUploadSample;

        @UiView
        public class AdvancedFormElementsViewImpl extends SamplePageView<AdvancedFormElementsView.AdvancedFormElementsUiHandlers>
            implements AdvancedFormElementsView {

          @Inject
          public AdvancedFormElementsViewImpl() {
            super("Advanced Form Elements", "Advanced Form Elements examples rendered from the shared demo-samples module.");
    addSample(SuggestBoxSample.class, SuggestBoxSample::create);
    addSample(TagsInputSample.class, TagsInputSample::create);
    addSample(UploadBoxSample.class, UploadBoxSample::create);
    addSample(FileUploadSample.class, FileUploadSample::create);
            initPage();
          }
        }
