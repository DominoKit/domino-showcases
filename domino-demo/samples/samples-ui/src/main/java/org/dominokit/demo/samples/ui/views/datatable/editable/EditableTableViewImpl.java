package org.dominokit.demo.samples.ui.views.datatable.editable;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.editable.EditableTableView;
    import org.dominokit.showcases.samples.datatable.editable.EditableTableSample;

    @UiView
    public class EditableTableViewImpl extends SamplePageView<EditableTableView.EditableTableUiHandlers>
        implements EditableTableView {

      @Inject
      public EditableTableViewImpl() {
        super("Editable Table", "Editable Table examples rendered from the shared demo-samples module.");
addSample(EditableTableSample.class, EditableTableSample::create);
        initPage();
      }
    }
