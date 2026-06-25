package org.dominokit.demo.shell.ui.views.shell;

import static org.dominokit.domino.ui.grid.Column.span4;
import static org.dominokit.domino.ui.utils.Domino.body;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;
import static org.dominokit.domino.ui.utils.Domino.dui_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_order_20;

import elemental2.core.Global;
import elemental2.dom.HTMLDivElement;
import java.util.Locale;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.api.Slot;
import org.dominokit.brix.impl.AcceptOneElementSlot;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.shell.ui.components.ProfileCard;
import org.dominokit.demo.shell.ui.components.ThemeDrawer;
import org.dominokit.demo.shell.views.shell.ShellView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.lib.MdiTags;
import org.dominokit.domino.ui.layout.AppLayout;
import org.dominokit.domino.ui.layout.AppLayoutStyles;
import org.dominokit.domino.ui.layout.LeftDrawerSize;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.scroll.ScrollTop;
import org.dominokit.domino.ui.style.SpacingCss;
import org.dominokit.domino.ui.themes.DominoThemeDark;
import org.dominokit.domino.ui.themes.DominoThemeLight;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.tree.TreeItemIcon;
import org.dominokit.domino.ui.utils.ElementHandler;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.gwtproject.core.client.Scheduler;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

@UiView
public class ShellViewImpl extends BrixView<HTMLDivElement, ShellView.ShellUiHandlers> implements ShellView {

  private final AppLayout layout;
  private Loader loader;
  private Tree<String> menu;
  private boolean locked = false;
  private boolean spanUp = false;
  private boolean spanDown = true;
  private ToggleMdiIcon lockIcon;

  @Inject
  public ShellViewImpl() {
    this.layout = AppLayout.create("Domino UI demo");
    configureLayout();
    init(this);
    Scheduler.get().scheduleDeferred(this::addMediaQueries);
  }

  private static ElementHandler<TreeItem<String>> addToggleIcon() {
    return self -> {
      ToggleMdiIcon icon = ToggleMdiIcon.create(Icons.plus(), Icons.minus());
      self.appendChild(PostfixAddOn.of(icon));
      self.addBeforeCollapseListener(icon::toggle);
      self.addBeforeExpandListener(icon::toggle);
    };
  }

  private static String iconTagRoute(String tag) {
    return "mdiicons/" + Global.encodeURI(tag.replace("/", "--").toLowerCase(Locale.ROOT));
  }

  private void configureLayout() {
    layout.withFooter((parent, footer) -> footer.appendChild(div()
        .css("dui-p-4")
        .appendChild(createFooterRow())
        .appendChild(div()
            .addCss("dui-text-center")
            .appendChild(p()
                .css("dui")
                .style("line-height: 45px; height: 45px; margin: 0px; text-align: center;")
                .textContent("© 2018 Copyright DominoKit"))
            .element())));

    body().appendChild(ScrollTop.create(Icons.arrow_up()).setBottom(60));
    layout.setLeftDrawerSpanDown(true);

    layout.withLeftDrawerContent((parent, drawer) -> {
      drawer.addCss(dui_flex, dui_flex_col);
      drawer.appendChild(ProfileCard.create());
      drawer.appendChild(createMenu());
    });

    layout.withRightDrawerContent((parent, drawer) -> {
      drawer.addCss(dui_flex, dui_flex_col);
      drawer.appendChild(ThemeDrawer.create());
    });

    layout.setRightDrawerToggleIcon(Icons.arrow_left().setTooltip("Theme settings"));
    layout.withNavBar((parent, navBar) -> navBar
        .appendChild(PostfixAddOn.of(Icons.theme_light_dark()
            .setTooltip("Dark mode on/off", DropDirection.BEST_MIDDLE_SIDE)
            .clickable()
            .addClickListener(evt -> {
              if (DominoThemeDark.INSTANCE.isApplied()) {
                DominoThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE);
              } else {
                DominoThemeManager.INSTANCE.apply(DominoThemeDark.INSTANCE);
              }
            })))
        .appendChild(PostfixAddOn.of(Icons.menu()
            .clickable()
            .setDropMenu(createNavMenu()))));

    loader = Loader.create(layout.getContent(), LoaderEffect.PULSE);
  }

  private Menu<String> createNavMenu() {
    return Menu.<String>create()
        .setDropDirection(DropDirection.TOP_MIDDLE)
        .appendChild(menuItem("Item 1"))
        .appendChild(menuItem("Item 2"))
        .appendChild(menuItem("Item 3"))
        .appendChild(menuItem("Item 4"))
        .appendChild(menuItem("Item 5"))
        .appendChild(menuItem("Item 6"));
  }

  private MenuItem<String> menuItem(String title) {
    MenuItem<String> item = MenuItem.create(title);
    item.setMenu(Menu.<String>create()
        .setDropDirection(DropDirection.TOP_MIDDLE)
        .appendChild(MenuItem.create("Sub Item 1"))
        .appendChild(MenuItem.create("Sub Item 2"))
        .appendChild(MenuItem.create("Sub Item 3"))
        .appendChild(MenuItem.create("Sub Item 4"))
        .appendChild(MenuItem.create("Sub Item 5"))
        .appendChild(MenuItem.create("Sub Item 6")));
    return item;
  }

  private Row createFooterRow() {
    return Row.create()
        .setMargin("0px")
        .appendChild(span4()
            .setMarginBottom("20px")
            .appendChild(h(4).textContent("Support us"))
            .appendChild(p().textContent(
                "Your donation will help us to continue working on domino-ui and let it grow to meet your needs, and is highly appreciated."))
            .appendChild(div().setInnerHtml(new SafeHtmlBuilder().appendHtmlConstant(
                "<form action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\" target=\"_top\">\n"
                    + "<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" />\n"
                    + "<input type=\"hidden\" name=\"lc\" value=\"US\" />\n"
                    + "<input type=\"hidden\" name=\"hosted_button_id\" value=\"AW5YG4LTTYNPS\" />\n"
                    + "<input type=\"image\" src=\"https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif\" border=\"0\" name=\"submit\" title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />\n"
                    + "<img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_JO/i/scr/pixel.gif\" width=\"1\" height=\"1\" />\n"
                    + "</form>\n").toSafeHtml())))
        .appendChild(span4()
            .setMarginBottom("20px")
            .appendChild(h(4).textContent("Join discussions"))
            .appendChild(p().textContent(
                "Join our Gitter channel for positive discussions, feedback, announcements and ask questions, it is lively in there."))
            .appendChild(p().setInnerHtml(new SafeHtmlBuilder().appendHtmlConstant(
                "<a title=\"Gitter\" href=\"https://gitter.im/domino-gwt/domino-ui\" rel=\"nofollow\"><img src=\"https://camo.githubusercontent.com/da2edb525cde1455a622c58c0effc3a90b9a181c/68747470733a2f2f6261646765732e6769747465722e696d2f4a6f696e253230436861742e737667\" data-canonical-src=\"https://badges.gitter.im/Join%20Chat.svg\" style=\"max-width:100%;\"></a>").toSafeHtml())))
        .appendChild(span4()
            .setMarginBottom("20px")
            .appendChild(h(4).textContent("Our repository"))
            .appendChild(p().textContent(
                "Contribute to our library at our official Domino-ui Github repository by forking, making pull requests or filing issues."))
            .appendChild(div().setInnerHtml(new SafeHtmlBuilder().appendHtmlConstant(
                "<iframe src=\"https://ghbtns.com/github-btn.html?user=DominoKit&amp;repo=domino-ui&amp;type=star&amp;count=true&amp;size=large\" frameborder=\"0\" scrolling=\"0\" width=\"125px\" height=\"30px\"></iframe>").toSafeHtml())));
  }

  private Tree<String> createMenu() {
    lockIcon = ToggleMdiIcon.create(
        Icons.lock_open().addCss(SpacingCss.dui_font_size_4).clickable(),
        Icons.lock().addCss(SpacingCss.dui_font_size_4).clickable());

    menu = Tree.<String>create("Demo menu")
        .addCss(dui_order_20)
        .withHeader((self, header) -> header
            .addCss(dui_h_12)
            .appendChild(PostfixAddOn.of(lockIcon.apply(icon -> icon.addClickListener(evt -> {
              if (locked) {
                handlers().onUnLocked();
                locked = false;
              } else {
                handlers().onLocked();
                locked = true;
              }
              icon.toggle();
            }))))
            .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(
                    Icons.arrow_collapse_up().addCss(SpacingCss.dui_font_size_4).clickable(),
                    Icons.arrow_collapse_down().addCss(SpacingCss.dui_font_size_4).clickable())
                .clickable()
                .apply(icon -> icon.addClickListener(evt -> {
                  handlers().onSpanUp(!spanUp);
                  spanUp = !spanUp;
                  icon.toggle();
                }))))
            .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(
                    Icons.arrow_collapse_up().addCss(SpacingCss.dui_font_size_4).clickable(),
                    Icons.arrow_collapse_down().addCss(SpacingCss.dui_font_size_4).clickable())
                .clickable()
                .apply(icon -> icon.addClickListener(evt -> {
                  handlers().onSpanDown(!spanDown);
                  spanDown = !spanDown;
                  icon.toggle();
                })))))
        .setSearchable(true)
        .setAutoExpandFound(true);

    addMenuItems();
    return menu;
  }

  private void addMenuItems() {
    menu
        .appendChild(TreeItem.create(Icons.home(), "Home")
            .apply(self -> self.getClickableElement().setAttribute("href", "home"))
            .addClickListener(evt -> {
              evt.preventDefault();
              handlers().onMenuItemSelected("home");
            }))
        .appendChild(TreeItem.create(Icons.view_dashboard(), "Layout")
            .apply(addToggleIcon())
            .appendChild(makeSubMenu("App layout", "layout/app-layout"))
            .appendChild(makeSubMenu("Grid layout", "layout/grid-layout"))
            .appendChild(makeSubMenu("Grids", "layout/grids"))
            .appendChild(makeSubMenu("Split panel", "layout/split-panel"))
            .appendChild(makeSubMenu("Flex layout", "layout/flex-layout")))
        .appendChild(TreeItem.create(Icons.widgets(), "Components")
            .apply(addToggleIcon())
            .appendChild(makeSubMenu("Alerts", "components/alerts"))
            .appendChild(makeSubMenu("Badges", "components/badges"))
            .appendChild(makeSubMenu("Breadcrumbs", "components/breadcrumbs"))
            .appendChild(makeSubMenu("Boards", "components/boards", true))
            .appendChild(makeSubMenu("Buttons", "components/buttons"))
            .appendChild(makeSubMenu("Cards", "components/cards"))
            .appendChild(makeSubMenu("Carousel", "components/carousel"))
            .appendChild(makeSubMenu("Chips", "components/chips"))
            .appendChild(makeSubMenu("Collapse", "components/collapse"))
            .appendChild(makeSubMenu("Color picker", "components/color-picker", true))
            .appendChild(makeSubMenu("Counters", "components/counters", true))
            .appendChild(makeSubMenu("Dialogs", "components/dialogs"))
            .appendChild(makeSubMenu("Drag and drop", "components/dnd"))
            .appendChild(makeSubMenu("Info box", "components/infobox"))
            .appendChild(makeSubMenu("Labels", "components/labels"))
            .appendChild(makeSubMenu("Lists", "components/lists"))
            .appendChild(makeSubMenu("Loaders", "components/loaders"))
            .appendChild(makeSubMenu("Media objects", "components/media"))
            .appendChild(makeSubMenu("Menu", "components/menu"))
            .appendChild(makeSubMenu("Menu bar", "components/menu-bar", true))
            .appendChild(makeSubMenu("Modals", "components/modals"))
            .appendChild(makeSubMenu("Navigation bar", "components/navbar"))
            .appendChild(makeSubMenu("Notifications", "components/notifications"))
            .appendChild(makeSubMenu("Pagination", "components/pagination"))
            .appendChild(makeSubMenu("Preloaders", "components/preloaders"))
            .appendChild(makeSubMenu("Progress bars", "components/progress"))
            .appendChild(makeSubMenu("Rich text editor", "components/rich-text-editor"))
            .appendChild(makeSubMenu("Range slider", "components/range-slider", true))
            .appendChild(makeSubMenu("Sliders", "components/sliders"))
            .appendChild(makeSubMenu("Spin", "components/spin"))
            .appendChild(makeSubMenu("Tabs", "components/tabs"))
            .appendChild(makeSubMenu("Thumbnails", "components/thumbnails"))
            .appendChild(makeSubMenu("Tooltip & Popover", "components/tooltips-popover"))
            .appendChild(makeSubMenu("Tree", "components/tree"))
            .appendChild(makeSubMenu("Check Tree", "components/check-tree", true))
            .appendChild(makeSubMenu("Waves", "components/waves")))
        .appendChild(TreeItem.create(Icons.form_textbox(), "Forms")
            .apply(addToggleIcon())
            .appendChild(makeSubMenu("Basic forms", "forms/basic-form-elements"))
            .appendChild(makeSubMenu("Advanced forms", "forms/advanced-form-elements"))
            .appendChild(makeSubMenu("Date picker", "forms/datepicker"))
            .appendChild(makeSubMenu("Time picker", "forms/timepicker"))
            .appendChild(makeSubMenu("Field decoration", "forms/fields-decoration"))
            .appendChild(makeSubMenu("Input fields", "forms/input-fields"))
            .appendChild(makeSubMenu("Input mask", "components/input-mask", true))
            .appendChild(makeSubMenu("Steppers", "forms/steppers")))
        .appendChild(TreeItem.create(Icons.view_headline(), "Data")
            .apply(addToggleIcon())
            .appendChild(makeSubMenu("Data list", "data/data-list", true))
            .appendChild(makeSubMenu("Data select", "data/data-select", true)))
        .appendChild(TreeItem.create(Icons.view_list(), "Data table")
            .apply(addToggleIcon())
            .appendChild(makeSubMenu("Basic table", "datatable/basic-table"))
            .appendChild(makeSubMenu("Benchmark table", "datatable/benchmark-table"))
            .appendChild(makeSubMenu("Column resize plugin", "datatable/column-resize-plugin"))
            .appendChild(makeSubMenu("Column pin plugin", "datatable/column-pin-plugin"))
            .appendChild(makeSubMenu("Column groups", "datatable/column-groups"))
            .appendChild(makeSubMenu("Drag-Drop plugin", "datatable/drag-drop-plugin"))
            .appendChild(makeSubMenu("Editable table", "datatable/editable-table"))
            .appendChild(makeSubMenu("Empty state", "datatable/empty-state"))
            .appendChild(makeSubMenu("Fixed table", "datatable/fixed-table"))
            .appendChild(makeSubMenu("Grouping plugin", "datatable/grouping-plugin"))
            .appendChild(makeSubMenu("Header bar plugin", "datatable/header-bar-plugin"))
            .appendChild(makeSubMenu("Live grid", "datatable/live-grid", true))
            .appendChild(makeSubMenu("Marker plugin", "datatable/marker-plugin"))
            .appendChild(makeSubMenu("Selection plugin", "datatable/selection-plugin"))
            .appendChild(makeSubMenu("Pagination plugins", "datatable/pagination-plugin"))
            .appendChild(makeSubMenu("Record details plugin", "datatable/record-details-plugin"))
            .appendChild(makeSubMenu("Row menu plugin", "datatable/row-menu-plugin"))
            .appendChild(makeSubMenu("Sort and search plugins", "datatable/sort-search-plugin"))
            .appendChild(makeSubMenu("Scroll loading", "datatable/scroll-loading"))
            .appendChild(makeSubMenu("Summary plugin", "datatable/summary-plugin"))
            .appendChild(makeSubMenu("Top panel plugin", "datatable/top-panel-plugin"))
            .appendChild(makeSubMenu("Tree plugin - eager", "datatable/eager-tree-plugin"))
            .appendChild(makeSubMenu("Tree plugin - Lazy", "datatable/lazy-tree-plugin"))
            .appendChild(makeSubMenu("Plugins mix", "datatable/mix-plugins")))
        .appendChild(TreeItem.create(Icons.flower(), "MDI Icons")
            .apply(addToggleIcon())
            .apply(self -> {
              self.appendChild(TreeItem.create("All Icons")
                      .addClickListener(evt -> {
                        evt.preventDefault();
                        handlers().onMenuItemSelected("mdiicons/all");
                      }))
                  .appendChild(TreeItem.create("Untagged")
                      .addClickListener(evt -> {
                        evt.preventDefault();
                        handlers().onMenuItemSelected("mdiicons/untagged");
                      }));
              MdiTags.TAGS.forEach(tag -> self.appendChild(TreeItem.create(tag)
                  .addClickListener(evt -> {
                    evt.preventDefault();
                    handlers().onMenuItemSelected(iconTagRoute(tag));
                  })));
            }))
        .appendChild(TreeItem.create(Icons.format_font(), "Typography")
            .apply(self -> self.getClickableElement().setAttribute("href", "typography"))
            .addClickListener(evt -> {
              evt.preventDefault();
              handlers().onMenuItemSelected("typography");
            }))
        .appendChild(TreeItem.create(Icons.layers(), "Helper classes")
            .apply(self -> self.getClickableElement().setAttribute("href", "helpers"))
            .addClickListener(evt -> {
              evt.preventDefault();
              handlers().onMenuItemSelected("helpers");
            }))
        .appendChild(TreeItem.create(Icons.select_color(), "Colors")
            .apply(self -> self.getClickableElement().setAttribute("href", "colors"))
            .addClickListener(evt -> {
              evt.preventDefault();
              handlers().onMenuItemSelected("colors");
            }))
        .appendChild(TreeItem.create(Icons.animation(), "Animations")
            .apply(self -> self.getClickableElement().setAttribute("href", "animations"))
            .addClickListener(evt -> {
              evt.preventDefault();
              handlers().onMenuItemSelected("animations");
            }));
  }

  private void addMediaQueries() {
    MediaQuery.addOnXLargeListener(() -> {
      handlers().onXLargeMedia();
      fix();
      Notification.create("Switched to XLarge screen")
          .setPosition(Notification.Position.TOP_MIDDLE)
          .show();
    });

    MediaQuery.addOnLargeListener(() -> {
      handlers().onLargeMedia();
      fix();
      Notification.create("Switched to Large screen")
          .setPosition(Notification.Position.TOP_MIDDLE)
          .show();
    });

    MediaQuery.addOnMediumListener(() -> {
      handlers().onMediumMedia();
      unfix();
      Notification.create("Switched to Medium screen")
          .setPosition(Notification.Position.TOP_MIDDLE)
          .show();
    });

    MediaQuery.addOnSmallListener(() -> {
      handlers().onSmallMedia();
      unfix();
      Notification.create("Switched to Small screen")
          .setPosition(Notification.Position.TOP_MIDDLE)
          .show();
    });

    MediaQuery.addOnXSmallListener(() -> {
      handlers().onXSmallMedia();
      unfix();
      Notification.create("Switched to XSmall screen")
          .setPosition(Notification.Position.TOP_MIDDLE)
          .show();
    });
  }

  private TreeItem<String> makeSubMenu(String title, String token) {
    return makeSubMenu(title, token, false);
  }

  private TreeItem<String> makeSubMenu(String title, String token, boolean pro) {
    return TreeItem.create(title)
        .setIcon(TreeItemIcon.of(
            Icons.circle_small(),
            Icons.circle_small(),
            Icons.circle_small(),
            Icons.chevron_right()))
        .apply(self -> self.getClickableElement().setAttribute("href", token))
        .apply(self -> {
          if (pro) {
            self.appendChild(PostfixAddOn.of(Badge.create("Pro")));
          }
        })
        .addClickListener(evt -> {
          evt.preventDefault();
          handlers().onMenuItemSelected(token);
        });
  }

  private void fix() {
    lockIcon.show();
    locked = true;
  }

  private void unfix() {
    lockIcon.hide();
    locked = false;
  }

  @Override
  public Slot contentSlot(String slotKey) {
    return AcceptOneElementSlot.of(slotKey, layout.getContent());
  }

  @Override
  public void startLoading() {
    loader.start();
  }

  @Override
  public void stopLoading() {
    loader.stop();
  }

  @Override
  public void spanDown(boolean spanDown) {
    layout.setLeftDrawerSpanDown(spanDown);
  }

  @Override
  public void spanUp(boolean spanUp) {
    layout.setLeftDrawerSpanUp(spanUp);
  }

  @Override
  public void toggleRightPanel() {
    layout.toggleRightDrawer();
  }

  @Override
  public ShellView showRightPanel() {
    layout.showRightDrawer();
    return this;
  }

  @Override
  public ShellView hideRightPanel() {
    layout.hideRightDrawer();
    return this;
  }

  @Override
  public void toggleLeftPanel() {
    layout.toggleLeftDrawer();
  }

  @Override
  public ShellView showLeftPanel() {
    layout.showLeftDrawer();
    return this;
  }

  @Override
  public ShellView hideLeftPanel() {
    layout.hideLeftDrawer();
    return this;
  }

  @Override
  public ShellView setTitle(String title) {
    layout.withNavBar((parent, navBar) -> navBar.setTitle(title));
    return this;
  }

  @Override
  public boolean isRightPanelVisible() {
    return layout.containsCss(AppLayoutStyles.dui_right_open.getCssClass());
  }

  @Override
  public ShellView fixLeftPanelPosition() {
    layout.showLeftDrawer();
    layout.setShrinkContent(true);
    layout.setAutoCloseLeftDrawer(false);
    return this;
  }

  @Override
  public ShellView unfixLeftPanelPosition() {
    layout.setShrinkContent(false);
    layout.setAutoCloseLeftDrawer(true);
    return this;
  }

  @Override
  public ShellView setLeftPanelSize(String size) {
    layout.setLeftDrawerSize(LeftDrawerSize.valueOf(size));
    return this;
  }

  @Override
  public ShellView scrollTop() {
    ElementUtil.scrollTop();
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return layout.element();
  }
}
