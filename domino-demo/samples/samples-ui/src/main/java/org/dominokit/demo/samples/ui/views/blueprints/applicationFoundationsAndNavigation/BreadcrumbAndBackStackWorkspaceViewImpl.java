package org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.BreadcrumbAndBackStackWorkspaceView;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.BreadcrumbAndBackStackWorkspaceSample;

@UiView
public class BreadcrumbAndBackStackWorkspaceViewImpl extends SamplePageView<BreadcrumbAndBackStackWorkspaceView.BreadcrumbAndBackStackWorkspaceUiHandlers>
    implements BreadcrumbAndBackStackWorkspaceView {

  @Inject
  public BreadcrumbAndBackStackWorkspaceViewImpl() {
    super("Breadcrumb and back-stack workspace", "Layout: A compact breadcrumb and back control sit above content, with no permanent side navigation required. Interaction: Users traverse nested records and return to prior contexts without rebuilding the full search state. Variants: Breadcrumb-only, breadcrumb plus history menu, or breadcrumb plus split view.");
    addSample("Breadcrumb and back-stack workspace", "Layout: A compact breadcrumb and back control sit above content, with no permanent side navigation required. Interaction: Users traverse nested records and return to prior contexts without rebuilding the full search state. Variants: Breadcrumb-only, breadcrumb plus history menu, or breadcrumb plus split view.", BreadcrumbAndBackStackWorkspaceSample.class, BreadcrumbAndBackStackWorkspaceSample::create);
    initPage();
  }
}
