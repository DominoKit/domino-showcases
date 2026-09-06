package org.dominokit.showcases.samples.blueprints.masterdetail;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

public final class MasterDetailHierarchyPane extends BaseDominoElement<HTMLDivElement, MasterDetailHierarchyPane> {

  private final DivElement root;
  private final MasterDetailWorkspaceState state;
  private String selectedNodeId;

  private MasterDetailHierarchyPane(MasterDetailWorkspaceState state) {
    this.state = state;
    root = div().cssText("display: grid; grid-template-columns: minmax(220px, 1fr) minmax(280px, 2fr); gap: 16px;");
    render();
    init(this);
  }

  public static MasterDetailHierarchyPane create(MasterDetailWorkspaceState state) {
    return new MasterDetailHierarchyPane(state);
  }

  private void render() {
    root.clearElement();
    DivElement tree = div().cssText("display: flex; flex-direction: column; gap: 6px;")
        .appendChild(h(5).textContent("Entity hierarchy"));
    for (MasterDetailFixtures.HierarchyNode node : MasterDetailFixtures.hierarchy()) {
      renderNode(tree, node, 0);
    }
    root.appendChild(tree).appendChild(renderDetail());
  }

  private void renderNode(DivElement tree, MasterDetailFixtures.HierarchyNode node, int depth) {
    String marker = node.hasChildren() ? (state.isExpanded(node.id()) ? "▾ " : "▸ ") : "• ";
    tree.appendChild(div().cssText("display: flex; gap: 6px; align-items: center; margin-left: " + (depth * 16) + "px;")
        .appendChild(Button.create(marker + node.label()).addClickListener(event -> {
          selectedNodeId = node.id();
          if (node.hasChildren()) {
            state.toggleExpanded(node.id());
          }
          render();
        })));
    if (node.hasChildren() && state.isExpanded(node.id())) {
      for (MasterDetailFixtures.HierarchyNode child : node.children()) {
        renderNode(tree, child, depth + 1);
      }
    }
  }

  private DivElement renderDetail() {
    DivElement detail = div().cssText("border: 1px solid var(--dui-border-color, #d9e1ea); border-radius: 6px; padding: 12px;");
    if (selectedNodeId == null) {
      return detail.appendChild(p().textContent("Select a node to inspect its hierarchy context."));
    }
    MasterDetailFixtures.HierarchyNode selected = find(MasterDetailFixtures.hierarchy(), selectedNodeId);
    if (selected == null) {
      return detail.appendChild(p().textContent("The selected hierarchy node is no longer available."));
    }
    return detail.appendChild(h(4).textContent(selected.label()))
        .appendChild(p().textContent("This detail pane can host child records, permissions, and scoped actions."))
        .appendChild(Button.create("Add child").addClickListener(event ->
            detail.appendChild(p().textContent("A new child can be added under " + selected.label() + "."))));
  }

  private MasterDetailFixtures.HierarchyNode find(
      java.util.List<MasterDetailFixtures.HierarchyNode> nodes, String id) {
    for (MasterDetailFixtures.HierarchyNode node : nodes) {
      if (node.id().equals(id)) {
        return node;
      }
      MasterDetailFixtures.HierarchyNode child = find(node.children(), id);
      if (child != null) {
        return child;
      }
    }
    return null;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
