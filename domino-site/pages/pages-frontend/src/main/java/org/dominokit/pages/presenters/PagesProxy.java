package org.dominokit.pages.presenters;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.ListenFor;
import org.dominokit.brix.annotations.OnActivated;
import org.dominokit.brix.annotations.OnReveal;
import org.dominokit.brix.annotations.OnStateChanged;
import org.dominokit.brix.api.BrixSlots;
import org.dominokit.brix.api.Presenter;
import org.dominokit.domino.history.DominoHistory;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.domino.history.StateHistoryToken;
import org.dominokit.pages.presenters.samples.SiteEvents;
import org.dominokit.pages.shared.events.SwitchVersionEvent;
import org.dominokit.pages.views.PagesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@BrixPresenter
@BrixRoute()
@BrixSlot(BrixSlots.BRIX_NO_CONTENT_SLOT)
public class PagesProxy extends Presenter<PagesView> implements PagesView.PagesUiHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(PagesProxy.class);

    private static final List<ContentLoader> loaders = new ArrayList<>(){{
        add(new MainNavigationContentLoader());
        add(new SolutionContentLoader());
    }};

    private DominoHistory.State previousState;

    @OnActivated
    public void onPagesInit() {
        updateContent();
    }

    @OnReveal
    public void onPagesRevealed() {
        view.enhance(unused -> {
            if(isNull(previousState) || isNotSameState(previousState, state)) {
                SiteEvents.fireContentEvent();
            }
        });
    }

    @OnStateChanged
    public void updateContent() {
        boolean shouldUpdateContent = isNull(previousState) || isNotSameState(previousState, state);
        if(shouldUpdateContent) {
            for (ContentLoader loader : loaders) {
                HistoryToken token = state.token();
                boolean b = loader.canLoad(token);
                if (b) {
                    loader.loadContent(state.token(), view);
                    this.previousState = state;
                    break;
                }
            }
        }
    }

    private boolean isNotSameState(DominoHistory.State previousState, DominoHistory.State state) {
        return !previousState.token().path().equals(state.token().path());
    }

    @ListenFor(SwitchVersionEvent.class)
    public void onVersionSwitch(SwitchVersionEvent event){
        StateHistoryToken token = new StateHistoryToken("solutions/" + event.getSolution() + "/" + event.getVersion() + "/docs/" + "/getting-started");
        SolutionNoDocsContentLoader solutionNoDocsContentLoader = new SolutionNoDocsContentLoader();
        if(solutionNoDocsContentLoader.canLoad(token)) {
            solutionNoDocsContentLoader.loadContent(token, view);
        }
    }
}