package org.dominokit.pages.ui.views.samples.forms.suggest;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.suggest.*;

@UiView
public class SuggestBoxViewImpl extends SampleViewImpl {
    @Inject
    public SuggestBoxViewImpl() {
        register(DemoSample.of("suggest-box-sample", SuggestBoxSample.class, LazyProvider.of(SuggestBoxSample::create)));
        register(DemoSample.of("tag-box-sample", TagsInputSample.class, LazyProvider.of(TagsInputSample::create)));
    }
}