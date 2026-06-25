package org.dominokit.pages.presenters;

import org.dominokit.brix.Brix;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.domino.history.StateToken;
import org.dominokit.pages.presenters.samples.SiteEvents;
import org.dominokit.pages.views.PagesView;

public class MainNavigationContentLoader implements ContentLoader {

    @Override
    public boolean canLoad(HistoryToken token) {
        return token.endsWithPath("home")
         || token.endsWithPath("services")
         || token.endsWithPath("solutions")
         || token.endsWithPath("solutions/domino-ui/v2")
         || token.endsWithPath("solutions/domino-brix")
         || token.endsWithPath("solutions/domino-jackson/v1")
         || token.endsWithPath("solutions/domino-rest/v1")
         || token.endsWithPath("solutions/domino-history/v1")
         || token.endsWithPath("support/donation")
         || token.endsWithPath("resources")
         || (token.paths().size() > 1 && "resources".equalsIgnoreCase(token.paths().get(0)))
         || token.endsWithPath("news")
         || token.endsWithPath("about-us")
                ;
    }

    @Override
    public void loadContent(HistoryToken token, PagesView view) {
        String page = token.paths().get(token.paths().size() - 1);
        String path = token.path();
        if (token.endsWithPath("resources")) {
            path = "resources/domino-cli";
            page = "domino-cli";
        }
        getContent(path, page, false , content -> {
            view.replaceContent(content, "dui-content-container");
            view.enhancePadding();
            view.registerSlots();
            SiteEvents.fireContentEvent();
            Brix.get().router().fireState(StateToken.of(Brix.get().router().currentToken()));
        });
    }
}
