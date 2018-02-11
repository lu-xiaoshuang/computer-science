/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.tree;

public class BinaryTreeNode {
    public BinaryTreeNode parent;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public String value;

    private static void doPreOrder(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            System.out.print(binaryTreeNode.value + " ");
            doPreOrder(binaryTreeNode.left);
            doPreOrder(binaryTreeNode.right);
        }
    }

    public static void preOrder(BinaryTreeNode binaryTreeNode) {
        doPreOrder(binaryTreeNode);
        if (binaryTreeNode != null) {
            System.out.println();
        }
    }

    private static void doInOrder(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            doInOrder(binaryTreeNode.left);
            System.out.print(binaryTreeNode.value + " ");
            doInOrder(binaryTreeNode.right);
        }
    }

    public static void inOrder(BinaryTreeNode binaryTreeNode) {
        doInOrder(binaryTreeNode);
        if (binaryTreeNode != null) {
            System.out.println();
        }
    }

    private static void doPostOrder(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            doPostOrder(binaryTreeNode.left);
            doPostOrder(binaryTreeNode.right);
            System.out.print(binaryTreeNode.value + " ");
        }
    }

    public static void postOrder(BinaryTreeNode binaryTreeNode) {
        doPostOrder(binaryTreeNode);
        if (binaryTreeNode != null) {
            System.out.println();
        }
    }

    public static void main(String[] stringArray) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.parent = null;
        binaryTreeNode.left = null;
        binaryTreeNode.right = null;
    }
}
