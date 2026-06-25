package org.dominokit.pages.ui.views.samples.components.dnd;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.dnd.*;

@UiView
public class DragAndDropViewImpl extends SampleViewImpl {
    @Inject
    public DragAndDropViewImpl() {
        register(DemoSample.of("drag-and-drop-basic", DragAndDropBasicSample.class, LazyProvider.of(DragAndDropBasicSample::create)));
    }
}