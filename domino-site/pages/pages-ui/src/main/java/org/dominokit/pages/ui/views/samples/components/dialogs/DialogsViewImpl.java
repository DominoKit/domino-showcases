package org.dominokit.pages.ui.views.samples.components.dialogs;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.dialogs.*;

@UiView
public class DialogsViewImpl extends SampleViewImpl {
    @Inject
    public DialogsViewImpl() {
        register(DemoSample.of("dialogs-basic", BasicDialogsSample.class, LazyProvider.of(BasicDialogsSample::create)));
    }
}