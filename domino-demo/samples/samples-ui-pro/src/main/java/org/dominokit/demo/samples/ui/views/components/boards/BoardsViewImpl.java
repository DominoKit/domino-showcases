package org.dominokit.demo.samples.ui.views.components.boards;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.boards.BoardsView;
        import org.dominokit.showcases.samples.components.boards.ColumnBoardsSample;
import org.dominokit.showcases.samples.components.boards.ListsBoardsSample;

        @UiView
        public class BoardsViewImpl extends SamplePageView<BoardsView.BoardsUiHandlers>
            implements BoardsView {

          @Inject
          public BoardsViewImpl() {
            super("Boards", "Boards examples rendered from the shared demo-samples module.");
    addSample(ColumnBoardsSample.class, ColumnBoardsSample::create);
    addSample(ListsBoardsSample.class, ListsBoardsSample::create);
            initPage();
          }
        }
