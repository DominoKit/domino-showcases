# WidgetElement Integration

This document shows how to add a minimal bridge between Domino UI elements and GWT widgets so you can
reuse existing widget-based code inside a Domino-based application without rewriting everything at once.

The bridge is made of two classes:

- `com.google.gwt.user.client.ui.WidgetWrapper`
- `com.dominokit.samples.WidgetElement` in this sample repository, or the package of your choice in your application

## What the bridge does

`WidgetWrapper` exists in the GWT widget package so it can call the protected `Widget.onAttach()`
and `Widget.onDetach()` methods. `WidgetElement` then uses that wrapper to keep widget attachment
and detachment aligned with the Domino element lifecycle.

That gives you both directions:

- wrap a `Widget` or `IsWidget` as a Domino element
- wrap a Domino `IsElement` back into a GWT `Widget`

## Add the classes

Create these files in your application:

- `src/main/java/com/google/gwt/user/client/ui/WidgetWrapper.java`
- `src/main/java/com/dominokit/samples/WidgetElement.java` or another application package

The `WidgetElement` snippet below intentionally omits the `package` declaration so you can place it in
your own namespace.

## Source: WidgetWrapper

```java
package com.google.gwt.user.client.ui;

import static java.util.Objects.nonNull;

/**
 * Thin adapter that exposes a widget's protected attach and detach lifecycle methods.
 *
 * <p>Domino elements can manage attachment from the outside, but {@link Widget#onAttach()} and
 * {@link Widget#onDetach()} remain protected in GWT. This class lives in the same package as
 * {@link Widget} so the bridge code can forward lifecycle changes without subclassing the widget
 * itself.
 */
public class WidgetWrapper {
    private Widget widget;

    /**
     * Creates a wrapper around the supplied widget.
     *
     * @param widget the non-null widget whose lifecycle should be driven externally
     */
    public WidgetWrapper(Widget widget) {
        this.widget = widget;
    }

    /**
     * Attaches the wrapped widget when it is not already attached.
     */
    public void attach() {
        onAttach();
    }

    /**
     * Detaches the wrapped widget when it is currently attached.
     */
    public void detach() {
        onDetach();
    }

    /**
     * Invokes {@link Widget#onAttach()} only when the widget is not yet attached.
     */
    private void onAttach() {
        if(!isAttached()) {
            widget.onAttach();
        }
    }

    /**
     * Invokes {@link Widget#onDetach()} only when the widget is currently attached.
     */
    private void onDetach() {
        if(isAttached()) {
            widget.onDetach();
        }
    }

    /**
     * Returns whether the wrapped widget exists and is already attached.
     *
     * @return {@code true} when the widget is non-null and attached; otherwise {@code false}
     */
    private boolean isAttached() {
        return nonNull(widget) && widget.isAttached();
    }
}
```

## Source: WidgetElement

```java
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetWrapper;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.dominokit.domino.ui.utils.Domino.wrap;

/**
 * Bridges GWT widgets and Domino UI elements without requiring a full rewrite.
 *
 * <p>This helper supports both directions:
 * <ul>
 *   <li>wrap a GWT {@link Widget} or {@link IsWidget} as a Domino {@link DominoElement}</li>
 *   <li>wrap a Domino {@link IsElement} back into a GWT {@link Widget}</li>
 * </ul>
 *
 * <p>The widget-to-element path keeps the original widget root element and forwards attachment and
 * detachment through {@link WidgetWrapper} so the widget lifecycle stays aligned with the Domino
 * element lifecycle.
 */
public class WidgetElement extends BaseDominoElement<HTMLElement, WidgetElement> {

    private final HTMLElement root;

    /**
     * Creates a Domino element view over the supplied widget.
     *
     * @param widget the widget whose root element should back this Domino element
     */
    private WidgetElement(Widget widget) {
        this.root = Js.uncheckedCast(widget.getElement());
        init(this);
    }

    /**
     * Returns the underlying HTML element that backs this Domino wrapper.
     *
     * @return the widget root element exposed as an {@link HTMLElement}
     */
    @Override
    public HTMLElement element() {
        return this.root;
    }

    /**
     * Wraps a Domino element as a GWT widget.
     *
     * <p>If the supplied element already is a {@link Widget}, it is returned unchanged. Otherwise a
     * lightweight adapter is created that points the widget to the same DOM element.
     *
     * @param element the Domino element to expose through the Widget API
     * @return the original widget or a widget adapter over the same root element
     */
    public static Widget toElementWidget(IsElement<? extends HTMLElement> element) {
        if (element instanceof Widget) {
            return (Widget) element;
        }
        return new ElementWidget(element);
    }

    /**
     * Converts an {@link IsWidget} into a {@link WidgetElement}.
     *
     * <p>The returned Domino element is backed by the same HTML element used by the widget.
     *
     * @param isWidget the source widget abstraction
     * @return a Domino element wrapper over the widget root element
     * @throws NullPointerException when the {@link IsWidget} cannot be resolved to a widget instance
     */
    public static WidgetElement toWidgetElement(IsWidget isWidget) {
        Widget widget = Widget.asWidgetOrNull(isWidget);
        if (widget == null) {
            throw new NullPointerException("isWidget cannot be null");
        }
        return new WidgetElement(widget);
    }

    /**
     * Converts a GWT {@link Widget} into a Domino element and keeps its lifecycle synchronized.
     *
     * <p>When the Domino element is attached, the widget receives {@link Widget#onAttach()}; when
     * it is detached, the widget receives {@link Widget#onDetach()}.
     *
     * @param widget the widget to expose as a Domino element
     * @return a Domino element view backed by the widget's root HTML element
     */
    public static DominoElement<HTMLElement> toWidgetElement(Widget widget) {
        return wrap(Js.<HTMLElement>uncheckedCast(widget.getElement()))
                .apply(dominoElement -> {
                    dominoElement.registerNowAndWhenAttached(() -> {
                        new WidgetWrapper(widget).attach();
                    });
                    dominoElement.nowAndWhenDetached(() -> {
                        new WidgetWrapper(widget).detach();
                    });
                });
    }

    /**
     * Simple widget adapter that exposes a Domino element as a GWT widget.
     */
    private static class ElementWidget extends Widget {
        /**
         * Creates a widget that reuses the supplied Domino element's root HTML element.
         *
         * @param dominoElement the Domino element to expose through the Widget API
         */
        public ElementWidget(IsElement<? extends HTMLElement> dominoElement) {
            setElement(Js.uncheckedCast(dominoElement.element()));
        }
    }
}
```

## Usage examples

### Wrap a GWT widget as a Domino element

```java
import com.google.gwt.user.client.ui.TextBox;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.DominoElement;

TextBox legacyTextBox = new TextBox();
legacyTextBox.setValue("Legacy GWT widget");

DominoElement<HTMLElement> bridgedWidget = WidgetElement.toWidgetElement(legacyTextBox);

Row row = Row.create();
row.appendChild(bridgedWidget);
```

### Use the `IsWidget` overload

```java
import com.google.gwt.user.client.ui.IsWidget;
import org.dominokit.domino.ui.utils.DominoElement;

IsWidget widgetView = someWidget;
DominoElement<HTMLElement> bridgedWidget = WidgetElement.toWidgetElement(widgetView);
```

### Wrap a Domino element as a GWT widget

```java
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import org.dominokit.domino.ui.forms.TextBox;

TextBox dominoTextBox = TextBox.create().withValue("Domino element exposed as a Widget");

Widget widgetAdapter = WidgetElement.toElementWidget(dominoTextBox);
RootPanel.get().add(widgetAdapter);
```

### Minimal entry point example

```java
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.DominoElement;

public class BridgeExample implements EntryPoint {
    @Override
    public void onModuleLoad() {
        TextBox legacyTextBox = new TextBox();
        legacyTextBox.setValue("GWT widget inside Domino");

        DominoElement<HTMLElement> bridgedWidget = WidgetElement.toWidgetElement(legacyTextBox);

        Row row = Row.create();
        row.appendChild(bridgedWidget);

        org.dominokit.domino.ui.forms.TextBox dominoTextBox =
                org.dominokit.domino.ui.forms.TextBox.create().withValue("Domino element inside GWT");
        Widget widgetAdapter = WidgetElement.toElementWidget(dominoTextBox);

        RootPanel.get().add(widgetAdapter);
    }
}
```

## Notes

- Keep `WidgetWrapper` in `com/google/gwt/user/client/ui`. That package placement is what makes the
  protected widget lifecycle methods accessible.
- `WidgetElement.toWidgetElement(Widget)` does not copy the widget. It reuses the same root element
  and synchronizes attach and detach.
- `WidgetElement.toElementWidget(IsElement)` returns the original widget unchanged when the input
  is already a `Widget`.
