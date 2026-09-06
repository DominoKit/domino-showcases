package org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.OfflineOrReconnectingWorkspaceView;
import org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions.OfflineOrReconnectingWorkspaceSample;

@UiView
public class OfflineOrReconnectingWorkspaceViewImpl extends SamplePageView<OfflineOrReconnectingWorkspaceView.OfflineOrReconnectingWorkspaceUiHandlers>
    implements OfflineOrReconnectingWorkspaceView {

  @Inject
  public OfflineOrReconnectingWorkspaceViewImpl() {
    super("Offline or reconnecting workspace", "Layout: Main content remains usable with visible connection state, queued changes, and synchronization status. Interaction: Users continue work, retry synchronization, inspect conflicts, and recover failed operations. Variants: Field app, intermittent network, or browser-local draft.");
    addSample("Offline or reconnecting workspace", "Layout: Main content remains usable with visible connection state, queued changes, and synchronization status. Interaction: Users continue work, retry synchronization, inspect conflicts, and recover failed operations. Variants: Field app, intermittent network, or browser-local draft.", OfflineOrReconnectingWorkspaceSample.class, OfflineOrReconnectingWorkspaceSample::create);
    initPage();
  }
}
