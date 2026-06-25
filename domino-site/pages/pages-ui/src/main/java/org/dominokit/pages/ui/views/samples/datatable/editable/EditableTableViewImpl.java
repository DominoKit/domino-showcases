package org.dominokit.pages.ui.views.samples.datatable.editable;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.editable.*;

@UiView
public class EditableTableViewImpl extends SampleViewImpl {
    @Inject
    public EditableTableViewImpl() {
        register(DemoSample.of("datatable-editable", EditableTableSample.class, LazyProvider.of(EditableTableSample::create)));
    }
}