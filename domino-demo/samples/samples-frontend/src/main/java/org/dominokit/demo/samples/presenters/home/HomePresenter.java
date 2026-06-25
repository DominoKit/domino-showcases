package org.dominokit.demo.samples.presenters.home;

import org.dominokit.brix.Brix;
import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.UiHandler;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.presenters.components.AlertsPresenter;
import org.dominokit.demo.samples.presenters.components.ButtonsPresenter;
import org.dominokit.demo.samples.presenters.components.CardsPresenter;
import org.dominokit.demo.samples.presenters.colors.ColorsPresenter;
import org.dominokit.demo.samples.presenters.datatable.BasicDataTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.BenchmarkTablePresenter;
import org.dominokit.demo.samples.presenters.forms.BasicFormElementsPresenter;
import org.dominokit.demo.samples.presenters.forms.InputFieldsPresenter;
import org.dominokit.demo.samples.presenters.forms.SteppersPresenter;
import org.dominokit.demo.samples.views.home.HomeView;
import org.dominokit.demo.samples.presenters.icons.IconsPresenter;
import org.dominokit.demo.samples.presenters.layouts.AppLayoutPresenter;
import org.dominokit.demo.samples.presenters.layouts.FlexLayoutPresenter;
import org.dominokit.demo.samples.presenters.typography.TypographyPresenter;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;
import org.dominokit.domino.history.StateToken;

@BrixPresenter
@BrixRoute(HomePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class HomePresenter extends ChildPresenter<ShellPresenter, HomeView>
    implements HomeView.HomeUiHandlers {

  public static final String ROUTE = "home";

  @UiHandler
  public void openAlerts() {
    Brix.get().router().fireState(StateToken.of(AlertsPresenter.ROUTE));
  }

  @UiHandler
  public void openButtons() {
    Brix.get().router().fireState(StateToken.of(ButtonsPresenter.ROUTE));
  }

  @UiHandler
  public void openCards() {
    Brix.get().router().fireState(StateToken.of(CardsPresenter.ROUTE));
  }

  @UiHandler
  public void openBasicFormElements() {
    Brix.get().router().fireState(StateToken.of(BasicFormElementsPresenter.ROUTE));
  }

  @UiHandler
  public void openInputFields() {
    Brix.get().router().fireState(StateToken.of(InputFieldsPresenter.ROUTE));
  }

  @UiHandler
  public void openSteppers() {
    Brix.get().router().fireState(StateToken.of(SteppersPresenter.ROUTE));
  }

  @UiHandler
  public void openBasicDataTable() {
    Brix.get().router().fireState(StateToken.of(BasicDataTablePresenter.ROUTE));
  }

  @UiHandler
  public void openBenchmarkTable() {
    Brix.get().router().fireState(StateToken.of(BenchmarkTablePresenter.ROUTE));
  }

  @UiHandler
  public void openColors() {
    Brix.get().router().fireState(StateToken.of(ColorsPresenter.ROUTE));
  }

  @UiHandler
  public void openIcons() {
    Brix.get().router().fireState(StateToken.of(IconsPresenter.ROUTE));
  }

  @UiHandler
  public void openTypography() {
    Brix.get().router().fireState(StateToken.of(TypographyPresenter.ROUTE));
  }

  @UiHandler
  public void openFlexLayout() {
    Brix.get().router().fireState(StateToken.of(FlexLayoutPresenter.ROUTE));
  }

  @UiHandler
  public void openAppLayout() {
    Brix.get().router().fireState(StateToken.of(AppLayoutPresenter.ROUTE));
  }
}
