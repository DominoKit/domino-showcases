package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.ConfigurationScreenWithPreviewView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ConfigurationScreenWithPreviewPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ConfigurationScreenWithPreviewPresenter extends ChildPresenter<ShellPresenter, ConfigurationScreenWithPreviewView>
    implements ConfigurationScreenWithPreviewView.ConfigurationScreenWithPreviewUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows/configuration-screen-with-preview";
}
