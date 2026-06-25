package org.dominokit.showcases.samples.colors;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_elevation_4;
import static org.dominokit.domino.ui.utils.Domino.dui_fg;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_sm;
import static org.dominokit.domino.ui.utils.Domino.dui_text_center;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ColorsSample extends BaseDominoElement<HTMLDivElement, ColorsSample> {

  private static final List<List<Palette>> PALETTE_ROWS =
      Arrays.asList(
          Arrays.asList(
              Palette.of(Color.RED, ColorScheme.RED),
              Palette.of(Color.PINK, ColorScheme.PINK),
              Palette.of(Color.PURPLE, ColorScheme.PURPLE),
              Palette.of(Color.DEEP_PURPLE, ColorScheme.DEEP_PURPLE)),
          Arrays.asList(
              Palette.of(Color.INDIGO, ColorScheme.INDIGO),
              Palette.of(Color.BLUE, ColorScheme.BLUE),
              Palette.of(Color.LIGHT_BLUE, ColorScheme.LIGHT_BLUE),
              Palette.of(Color.CYAN, ColorScheme.CYAN)),
          Arrays.asList(
              Palette.of(Color.TEAL, ColorScheme.TEAL),
              Palette.of(Color.GREEN, ColorScheme.GREEN),
              Palette.of(Color.LIGHT_GREEN, ColorScheme.LIGHT_GREEN),
              Palette.of(Color.LIME, ColorScheme.LIME)),
          Arrays.asList(
              Palette.of(Color.YELLOW, ColorScheme.YELLOW),
              Palette.of(Color.AMBER, ColorScheme.AMBER),
              Palette.of(Color.ORANGE, ColorScheme.ORANGE),
              Palette.of(Color.DEEP_ORANGE, ColorScheme.DEEP_ORANGE)),
          Arrays.asList(
              Palette.of(Color.BROWN, ColorScheme.BROWN),
              Palette.of(Color.GREY, ColorScheme.GREY),
              Palette.of(Color.BLUE_GREY, ColorScheme.BLUE_GREY),
              Palette.of(Color.BLACK, ColorScheme.BLACK)),
          Arrays.asList(
              Palette.of(Color.DOMINANT, ColorScheme.DOMINANT),
              Palette.of(Color.PRIMARY, ColorScheme.PRIMARY),
              Palette.of(Color.SECONDARY, ColorScheme.SECONDARY),
              Palette.of(Color.ACCENT, ColorScheme.ACCENT)),
          Arrays.asList(
              Palette.of(Color.SUCCESS, ColorScheme.SUCCESS),
              Palette.of(Color.INFO, ColorScheme.INFO),
              Palette.of(Color.WARNING, ColorScheme.WARNING),
              Palette.of(Color.ERROR, ColorScheme.ERROR)));

  private final DivElement element;

  public static ColorsSample create() {
    return new ColorsSample();
  }

  public ColorsSample() {
    this.element = div().addCss(dui_p_2);
    PALETTE_ROWS.forEach(paletteRow -> element.appendChild(createPaletteRow(paletteRow)));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  private Row createPaletteRow(List<Palette> palettes) {
    Row row = Row.create();
    palettes.forEach(palette -> row.appendChild(createPaletteColumn(palette)));
    return row;
  }

  private Column createPaletteColumn(Palette palette) {
    Column column = Column.span3();
    palette.colors().forEach(color -> column.appendChild(makeColorBox(color)));
    return column;
  }

  private DivElement makeColorBox(Color color) {
    return div()
        .addCss(
            dui_m_y_4,
            dui_flex,
            dui_flex_col,
            dui_w_full,
            dui_rounded_sm,
            dui_border,
            dui_border_solid,
            color.getBorderColor(),
            dui_elevation_4)
        .appendChild(
            div()
                .addCss(dui_flex, dui_flex_col)
                .appendChild(
                    div()
                        .addCss(dui_p_4, dui_w_full, dui_text_center, dui_fg, color.getCss())
                        .textContent(color.getCss().getCssClass().replace("dui-ctx ", "")))
                .appendChild(
                    div()
                        .addCss(dui_p_4, dui_w_full, dui_text_center, color.getBackground())
                        .textContent("dui_bg_" + color.getName().toLowerCase()))
                .appendChild(
                    div()
                        .addCss(dui_p_4, dui_w_full, dui_text_center, dui_fg, color.getBackground())
                        .textContent("dui_bg_" + color.getName().toLowerCase()))
                .appendChild(
                    div()
                        .addCss(dui_p_4, dui_w_full, dui_text_center, color.getForeground())
                        .textContent("dui_fg_" + color.getName().toLowerCase())));
  }

  private static final class Palette {
    private final Color baseColor;
    private final ColorScheme colorScheme;

    private Palette(Color baseColor, ColorScheme colorScheme) {
      this.baseColor = baseColor;
      this.colorScheme = colorScheme;
    }

    private static Palette of(Color baseColor, ColorScheme colorScheme) {
      return new Palette(baseColor, colorScheme);
    }

    private List<Color> colors() {
      return Arrays.asList(
          colorScheme.darker_4(),
          colorScheme.darker_3(),
          colorScheme.darker_2(),
          colorScheme.darker_1(),
          baseColor,
          colorScheme.lighten_1(),
          colorScheme.lighten_2(),
          colorScheme.lighten_3(),
          colorScheme.lighten_4(),
          colorScheme.lighten_5());
    }
  }
}
