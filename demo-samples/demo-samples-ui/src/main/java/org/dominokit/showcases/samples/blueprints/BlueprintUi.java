package org.dominokit.showcases.samples.blueprints;

import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.typography.BlockHeader;

public final class BlueprintUi {

  private BlueprintUi() {}

  public static Badge statusBadge(String status) {
    return Badge.create(status);
  }

  public static Button toolbarButton(String label) {
    return Button.create(label);
  }

  public static BlockHeader sectionTitle(String title, String description) {
    return BlockHeader.create(title, description);
  }
}
