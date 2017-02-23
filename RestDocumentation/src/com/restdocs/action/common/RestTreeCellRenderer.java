package com.restdocs.action.common;

import com.intellij.icons.AllIcons;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class RestTreeCellRenderer implements TreeCellRenderer {

    private JLabel label;

    public RestTreeCellRenderer() {
        label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                  boolean expanded, boolean leaf, int row, boolean hasFocus) {

        Object o = ((DefaultMutableTreeNode) value).getUserObject();

        if (o instanceof RestServiceNode) {
            RestServiceNode restServiceNode = (RestServiceNode) o;

            label.setIcon(AllIcons.FileTypes.Config);
            label.setText(restServiceNode.getUrl());
        } else if (o instanceof HttpMethod) {
            label.setIcon(AllIcons.CodeStyle.Gear);
            label.setText(((HttpMethod) o).name());
        } else {
            label.setIcon(AllIcons.Actions.Module);
            label.setText(o.toString());
        }

        return label;
    }
}
