package org.dominokit.demo.samples.ui.views.components.dialogs;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.components.dialogs.DialogsView;
    import org.dominokit.showcases.samples.components.dialogs.BasicDialogsSample;

    @UiView
    public class DialogsViewImpl extends SamplePageView<DialogsView.DialogsUiHandlers>
        implements DialogsView {

      @Inject
      public DialogsViewImpl() {
        super("Dialogs", "Dialogs examples rendered from the shared demo-samples module.");
addSample(BasicDialogsSample.class, BasicDialogsSample::create);
        initPage();
      }
    }
