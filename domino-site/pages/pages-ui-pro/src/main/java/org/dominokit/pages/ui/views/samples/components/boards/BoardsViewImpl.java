package org.dominokit.pages.ui.views.samples.components.boards;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.boards.*;

@UiView
public class BoardsViewImpl extends SampleViewImpl {
    @Inject
    public BoardsViewImpl() {
        register(DemoSample.of("boards-column", ColumnBoardsSample.class, LazyProvider.of(ColumnBoardsSample::create)));
        register(DemoSample.of("boards-list", ListsBoardsSample.class, LazyProvider.of(ListsBoardsSample::create)));
    }
}