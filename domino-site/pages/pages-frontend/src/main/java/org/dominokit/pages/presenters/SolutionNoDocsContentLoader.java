package org.dominokit.pages.presenters;

import org.dominokit.brix.Brix;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.domino.history.StateToken;
import org.dominokit.pages.presenters.samples.SiteEvents;
import org.dominokit.pages.views.PagesView;

public class SolutionNoDocsContentLoader implements ContentLoader {

    @Override
    public boolean canLoad(HistoryToken token) {
        return token.paths().size() > 1 && "solutions".equalsIgnoreCase(token.paths().get(0));
    }

    @Override
    public void loadContent(HistoryToken token, PagesView view) {
        String page = token.paths().get(token.paths().size() - 1);
        getContent(token.path(), page, false, content -> {
            view.replaceContent(content, "dui-content-container");
            view.enhancePadding();
            view.registerSlots();
            SiteEvents.fireContentEvent();
            Brix.get().router().pushState(StateToken.of(token.value()));
        });
    }
}
