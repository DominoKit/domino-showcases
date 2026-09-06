package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.KnowledgeBaseBrowserView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.KnowledgeBaseBrowserSample;

@UiView
public class KnowledgeBaseBrowserViewImpl extends SamplePageView<KnowledgeBaseBrowserView.KnowledgeBaseBrowserUiHandlers>
    implements KnowledgeBaseBrowserView {

  @Inject
  public KnowledgeBaseBrowserViewImpl() {
    super("Knowledge base browser", "Layout: Category navigation, search, article list, and reading pane. Interaction: Users search, browse categories, bookmark, rate, report outdated content, and follow related articles. Variants: Public help center, internal knowledge base, or contextual help drawer.");
    addSample("Knowledge base browser", "Layout: Category navigation, search, article list, and reading pane. Interaction: Users search, browse categories, bookmark, rate, report outdated content, and follow related articles. Variants: Public help center, internal knowledge base, or contextual help drawer.", KnowledgeBaseBrowserSample.class, KnowledgeBaseBrowserSample::create);
    initPage();
  }
}
