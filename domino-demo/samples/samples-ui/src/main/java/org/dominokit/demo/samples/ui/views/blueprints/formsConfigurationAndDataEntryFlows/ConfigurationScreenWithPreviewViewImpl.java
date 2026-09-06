package org.dominokit.demo.samples.ui.views.blueprints.formsConfigurationAndDataEntryFlows;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.ConfigurationScreenWithPreviewView;
import org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows.ConfigurationScreenWithPreviewSample;

@UiView
public class ConfigurationScreenWithPreviewViewImpl extends SamplePageView<ConfigurationScreenWithPreviewView.ConfigurationScreenWithPreviewUiHandlers>
    implements ConfigurationScreenWithPreviewView {

  @Inject
  public ConfigurationScreenWithPreviewViewImpl() {
    super("Configuration screen with preview", "Layout: Configuration controls occupy one region and a live or sample preview occupies another. Interaction: Users change settings, compare preview states, reset defaults, and publish/apply. Variants: Theme builder, notification template, report layout, or form designer.");
    addSample("Configuration screen with preview", "Layout: Configuration controls occupy one region and a live or sample preview occupies another. Interaction: Users change settings, compare preview states, reset defaults, and publish/apply. Variants: Theme builder, notification template, report layout, or form designer.", ConfigurationScreenWithPreviewSample.class, ConfigurationScreenWithPreviewSample::create);
    initPage();
  }
}
