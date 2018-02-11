/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.tree;

import java.util.LinkedList;

public class BinaryTree {
    private static void depthFirstSearch(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        LinkedList<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();
        stack.addLast(binaryTreeNode);
        while (! stack.isEmpty()) {
            BinaryTreeNode node = stack.removeLast();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                stack.addLast(node.left);
            }
        }
        System.out.println();
    }

    private static void breadthFirstSearch1(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.addLast(binaryTreeNode);
        while (! queue.isEmpty()) {
            BinaryTreeNode node = queue.removeFirst();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        System.out.println();
    }

    private static void breadthFirstSearch2(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        LinkedList<LinkedList<BinaryTreeNode>> queue = new LinkedList<LinkedList<BinaryTreeNode>>();
        LinkedList<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
        level.addLast(binaryTreeNode);
        queue.addLast(level);
        while (! queue.isEmpty()) {
            LinkedList<BinaryTreeNode> currentLevel = queue.removeFirst();
            LinkedList<BinaryTreeNode> nextLevel = new LinkedList<BinaryTreeNode>();
            for (BinaryTreeNode node : currentLevel) {
                System.out.print(node.value + " ");
                if (node.left != null) {
                    nextLevel.addLast(node.left);
                }
                if (node.right != null) {
                    nextLevel.addLast(node.right);
                }
            }
            System.out.println();
            if (! nextLevel.isEmpty()) {
                queue.addLast(nextLevel);
            }
        }
    }

    private static void path(BinaryTreeNode binaryTreeNode, LinkedList<BinaryTreeNode> result) {
        if (binaryTreeNode == null) {
            return;
        }
        result.addLast(binaryTreeNode);
        if (binaryTreeNode.left == null && binaryTreeNode.right == null) {
            for (BinaryTreeNode node : result) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
        System.out.println();
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
        depthFirstSearch(tree[3]);
        breadthFirstSearch1(tree[3]);
        breadthFirstSearch2(tree[3]);
        path(tree[3], new LinkedList<BinaryTreeNode>());
    }
}
