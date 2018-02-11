/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateBinaryTree {
    private static BinaryTreeNode doDirtyWork(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        LinkedList<BinaryTreeNode> tree = new LinkedList<BinaryTreeNode>();
        for (int i = 0; i < list.size(); ++ i) {
            BinaryTreeNode binaryTreeNode = null;
            String value = list.get(i);
            if (value != null) {
                binaryTreeNode = new BinaryTreeNode();
                binaryTreeNode.value = value;
            }
            tree.addLast(binaryTreeNode);
        }
        for (int i = 0; i < tree.size(); ++ i) {
            BinaryTreeNode binaryTreeNode = tree.get(i);
            if (binaryTreeNode == null) {
                continue;
            }
            int left = i * 2 + 1;
            if (left < tree.size()) {
                binaryTreeNode.left = tree.get(left);
            }
            int right = i * 2 + 2;
            if (right < tree.size()) {
                binaryTreeNode.right = tree.get(right);
            }
        }
        BinaryTreeNode root = tree.get(0);
        tree.clear();
        return root;
    }

    public static void main(String[] stringArray) {
        List<String> list =
            new ArrayList<String>() {
                {
                    add("4");
                    add("1");
                    add("6");
                    add("0");
                    add("2");
                    add("5");
                    add("7");
                    add(null);
                    add(null);
                    add(null);
                    add("3");
                    add(null);
                    add(null);
                    add(null);
                    add("8");
                }
            };
        BinaryTreeNode root = doDirtyWork(list);
        BinaryTreeNode.preOrder(root);
        BinaryTreeNode.inOrder(root);
        BinaryTreeNode.postOrder(root);
    }
}
