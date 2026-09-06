package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordPageWithActivityTimelineView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordPageWithActivityTimelineSample;

@UiView
public class RecordPageWithActivityTimelineViewImpl extends SamplePageView<RecordPageWithActivityTimelineView.RecordPageWithActivityTimelineUiHandlers>
    implements RecordPageWithActivityTimelineView {

  @Inject
  public RecordPageWithActivityTimelineViewImpl() {
    super("Record page with activity timeline", "Layout: Primary record details occupy one region and a chronological activity stream occupies another. Interaction: Users post notes, filter event types, expand events, and respond to tasks. Variants: Right rail, bottom timeline, or full-width activity tab.");
    addSample("Record page with activity timeline", "Layout: Primary record details occupy one region and a chronological activity stream occupies another. Interaction: Users post notes, filter event types, expand events, and respond to tasks. Variants: Right rail, bottom timeline, or full-width activity tab.", RecordPageWithActivityTimelineSample.class, RecordPageWithActivityTimelineSample::create);
    initPage();
  }
}
