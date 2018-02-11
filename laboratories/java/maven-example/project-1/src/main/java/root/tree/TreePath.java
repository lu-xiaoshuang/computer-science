/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.tree;

import java.util.LinkedList;

public class TreePath {
    private static void path(BinaryTreeNode binaryTreeNode, LinkedList<BinaryTreeNode> result) {
        if (binaryTreeNode == null) {
            return;
        }

        if (binaryTreeNode.left == null && binaryTreeNode.right == null) {
            result.addLast(binaryTreeNode);
            for (BinaryTreeNode node : result) {
                System.out.print(binaryTreeNode.value + " ");
            }
            System.out.println();
            result.removeLast();
            return;
        }
        result.addLast(binaryTreeNode);
        path(binaryTreeNode.left, result);
        path(binaryTreeNode.right, result);
        result.removeLast();
    }

    public static void main(String[] stringArray) {
        BinaryTreeNode[] tree = new BinaryTreeNode[7];
        for (int i = 0; i < 7; ++ i) {
            tree[i] = new BinaryTreeNode();
            tree[i].value = "" + i;
        }
        tree[0].left = null;
        tree[0].right = null;
        tree[1].left = tree[0];
        tree[1].right = tree[2];
        tree[2].left = null;
        tree[2].right = null;
        tree[3].left = tree[1];
        tree[3].right = tree[5];
        tree[4].left = null;
        tree[4].right = null;
        tree[5].left = tree[4];
        tree[5].right = tree[6];
        tree[6].left = null;
        tree[6].right = null;
        BinaryTreeNode.preOrder(tree[3]);
        BinaryTreeNode.inOrder(tree[3]);
        BinaryTreeNode.postOrder(tree[3]);
        path(tree[3], new LinkedList<BinaryTreeNode>());
    }
}
