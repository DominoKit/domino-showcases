package org.dominokit.pages.ui.views.samples.forms.input;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.forms.input.*;

@UiView
public class FileUploadViewImpl extends SampleViewImpl {
    @Inject
    public FileUploadViewImpl() {
        register(DemoSample.of("upload-box-sample", UploadBoxSample.class, LazyProvider.of(UploadBoxSample::create)));
        register(DemoSample.of("drag-drop-upload-sample", FileUploadSample.class, LazyProvider.of(FileUploadSample::create)));
    }
}