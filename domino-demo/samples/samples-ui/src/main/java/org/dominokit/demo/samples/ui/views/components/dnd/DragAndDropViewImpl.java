package org.dominokit.demo.samples.ui.views.components.dnd;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.components.dnd.DragAndDropView;
    import org.dominokit.showcases.samples.components.dnd.DragAndDropBasicSample;

    @UiView
    public class DragAndDropViewImpl extends SamplePageView<DragAndDropView.DragAndDropUiHandlers>
        implements DragAndDropView {

      @Inject
      public DragAndDropViewImpl() {
        super("Drag and Drop", "Drag and Drop examples rendered from the shared demo-samples module.");
addSample(DragAndDropBasicSample.class, DragAndDropBasicSample::create);
        initPage();
      }
    }
